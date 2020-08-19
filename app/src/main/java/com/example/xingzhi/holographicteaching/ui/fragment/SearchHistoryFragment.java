package com.example.xingzhi.holographicteaching.ui.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.adpter.TagAdapter;
import com.example.xingzhi.holographicteaching.base.MvpFragment;
import com.example.xingzhi.holographicteaching.bean.HotKeyResultBean;
import com.example.xingzhi.holographicteaching.core.RecordsDao;
import com.example.xingzhi.holographicteaching.databinding.FraSearchHistoryBinding;
import com.example.xingzhi.holographicteaching.presenter.HotKeyPresenter;
import com.example.xingzhi.holographicteaching.ui.activity.SearchActivity;
import com.example.xingzhi.holographicteaching.utils.Utils;
import com.example.xingzhi.holographicteaching.view.FlowLayout;
import com.example.xingzhi.holographicteaching.view.HotKeywordView;
import com.example.xingzhi.holographicteaching.view.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * A fragment representing a list of Items.
 */
public class SearchHistoryFragment  extends MvpFragment<HotKeyPresenter> implements HotKeywordView {


    FraSearchHistoryBinding binding;
    private List searchList;
    private Bundle bundle;

    private RecordsDao mRecordsDao;
    //默然展示词条个数
    private final int DEFAULT_RECORD_NUMBER = 10;
    private List<String> recordList = new ArrayList<>();
    private TagAdapter mRecordsAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,  R.layout.fra_search_history, container, false);
//        itemListModel = ViewModelProviders.of(getActivity()).get(ItemListModel.class);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //初始化数据库
        mRecordsDao = SearchActivity.mRecordsDao;
        initData();
        initView();

        searchList = new ArrayList();
//        searchList.add("人之初");
//        searchList.add("性本善");
//        searchList.add("性相近习相远");
//        searchList.add("耶");
//        searchList.add("千里之行始于足下");
//        searchList.add("Never underestimate your power");
//        searchList.add("to change yourself");
//        searchList.add("outside");
//        searchList.add("wide");

    }

    @Override
    protected void lazyLoadData() {

    }

    @Override
    protected HotKeyPresenter createPresenter() {
        return new HotKeyPresenter(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        mvpPresenter.getHotKey();
    }

    @Override
    public void getHotKeySuccess(HotKeyResultBean bean) {
        for (HotKeyResultBean.HotKeyData data : bean.getData()) {
            searchList.add(data.getKeyword());
        }
        Utils.ScrollViewLayout(getActivity(),searchList, binding.llHistory);
    }

    @Override
    public void getHotKeyFail(String msg) {
        toastShow(getString(R.string.net_error));
    }

    private void initData() {
        Observable.create(new ObservableOnSubscribe<List<String>>() {
            @Override
            public void subscribe(ObservableEmitter<List<String>> emitter) throws Exception {
                emitter.onNext(mRecordsDao.getRecordsByNumber(DEFAULT_RECORD_NUMBER));
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<String>>() {
                    @Override
                    public void accept(List<String> s) throws Exception {
                        recordList.clear();
                        recordList = s;
                        if (null == recordList || recordList.size() == 0) {
//                            binding.llHistoryContent.setVisibility(View.GONE);
                        } else {
                            binding.llHistoryContent.setVisibility(View.VISIBLE);
                        }
                        if (mRecordsAdapter != null) {
                            mRecordsAdapter.setData(recordList);
                            mRecordsAdapter.notifyDataChanged();
                        }
                    }
                });
    }
    private void initView() {
        //创建历史标签适配器
        //为标签设置对应的内容
        mRecordsAdapter = new TagAdapter<String>(recordList) {

            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.item_history_search, binding.tagHistoryFlowLayout, false);
                //为标签设置对应的内容
                tv.setText(s);
                return tv;
            }
        };


        binding.tagHistoryFlowLayout.setAdapter(mRecordsAdapter);
        binding.tagHistoryFlowLayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public void onTagClick(View view, int position, FlowLayout parent) {
                Toast.makeText(getActivity(), recordList.get(position).toString(), Toast.LENGTH_SHORT).show();
                //清空editText之前的数据
//                editText.setText("");
//                //将获取到的字符串传到搜索结果界面,点击后搜索对应条目内容
//                editText.setText(recordList.get(position));
//                editText.setSelection(editText.length());
            }
        });
        //删除某个条目
        binding.tagHistoryFlowLayout.setOnLongClickListener(new TagFlowLayout.OnLongClickListener() {
            @Override
            public void onLongClick(View view, final int position) {
                showDialog("确定要删除该条历史记录？", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //删除某一条记录
                        mRecordsDao.deleteRecord(recordList.get(position));
                    }
                });
            }
        });

        //view加载完成时回调
        binding.tagHistoryFlowLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                boolean isOverFlow = binding.tagHistoryFlowLayout.isOverFlow();
                boolean isLimit = binding.tagHistoryFlowLayout.isLimit();
                if (isLimit && isOverFlow) {
                    binding.ivMore.setVisibility(View.VISIBLE);
                } else {
                    binding.ivMore.setVisibility(View.GONE);
                }
            }
        });

        binding.ivMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.tagHistoryFlowLayout.setLimit(false);
                mRecordsAdapter.notifyDataChanged();
            }
        });

        //清除所有记录
        binding.clearAllRecords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog("确定要删除全部历史记录？", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        binding.tagHistoryFlowLayout.setLimit(true);
                        //清除所有数据
                        mRecordsDao.deleteUsernameAllRecords();
                    }
                });
            }
        });

        binding.ivMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String record = bundle.getString(SearchActivity.InputEditString);
                if (!TextUtils.isEmpty(record)) {
                    //添加数据
                    mRecordsDao.addRecords(record);
                }
            }
        });

//        clearSearch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //清除搜索历史
////                editText.setText("");
//            }
//        });

        mRecordsDao.setNotifyDataChanged(new RecordsDao.NotifyDataChanged() {
            @Override
            public void notifyDataChanged() {
                initData();
            }
        });
    }

    private void showDialog(String dialogTitle, @NonNull DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(dialogTitle);
        builder.setPositiveButton("确定", onClickListener);
        builder.setNegativeButton("取消", null);
        builder.create().show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}

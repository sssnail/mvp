package com.example.xingzhi.holographicteaching.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.databinding.FragmentHomeBinding;
import com.example.xingzhi.holographicteaching.base.MvpFragment;
import com.example.xingzhi.holographicteaching.modle.MainModel;
import com.example.xingzhi.holographicteaching.presenter.MainPresenter;
import com.example.xingzhi.holographicteaching.ui.activity.SearchActivity;
import com.example.xingzhi.holographicteaching.view.MainView;
import com.example.xingzhi.holographicteaching.view.ScaleTransitionPagerTitleView;
import com.example.xingzhi.holographicteaching.viewmodel.HomeViewModel;

import net.lucode.hackware.magicindicator.FragmentContainerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeFragment extends MvpFragment<MainPresenter> implements MainView, View.OnClickListener {

    private View root;
    private static HomeFragment homeFragment;
    private HomeViewModel homeViewModel;
    FragmentHomeBinding homeBinding;
    private static final String[] CHANNELS = new String[]{"推荐", "新游", "卡牌", "传奇", "三国", "RPG", "H5", "仙侠"};
    private List<String> mDataList = Arrays.asList(CHANNELS);
    private List<Fragment> mFragments = new ArrayList<Fragment>();
    private FragmentContainerHelper mFragmentContainerHelper = new FragmentContainerHelper();

    CommonNavigator commonNavigator;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(getActivity()).get(HomeViewModel.class);
//        root = inflater.inflate(R.layout.fragment_home, container, false);
        homeBinding = DataBindingUtil.inflate(inflater,  R.layout.fragment_home, container, false);
        homeBinding.llSearch.setOnClickListener(this);
//        final TextView textView = root.findViewById(R.id.text_home);
        Log.d("ddd", "HomeFragment");
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                homeBinding.textHome.setText(s);
//            }
//        });
        initFragments();
        initMagicIndicator();
        mFragmentContainerHelper.handlePageSelected(0, false);
        switchPages(0);


        return homeBinding.getRoot();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden){//可视

        }
    }

    @Override
    protected void lazyLoadData() {

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        homeBinding.textHome.setText("1111");
//
        homeBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "ss", Toast.LENGTH_SHORT).show();
                mvpPresenter.loadDataByRetrofitRxjava("101310222");

            }
        });
    }

    @Override
    public void getMainModelSuccess(MainModel model) {
        //接口请求回来
        homeViewModel.setmText(model.getWeatherinfo().getCity());
//        homeBinding.textHome.setText("city:"+ model.getWeatherinfo().getCity());
    }

    @Override
    public void getMainModelFail(String msg) {
        homeViewModel.setmText("error");
//        homeBinding.textHome.setText("error");
    }



    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    private void initFragments() {
        for (int i = 0; i < CHANNELS.length; i++) {
            TestFragment testFragment = new TestFragment();
            Bundle bundle = new Bundle();
            bundle.putString(TestFragment.EXTRA_TEXT, CHANNELS[i]);
            testFragment.setArguments(bundle);
            mFragments.add(testFragment);
        }
    }

    private void switchPages(int index) {
//         fragmentManager = getFragmentManager();
         fragmentManager = getChildFragmentManager();
         fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment;
        for (int i = 0, j = mFragments.size(); i < j; i++) {
            if (i == index) {
                continue;
            }
            fragment = mFragments.get(i);
            if (fragment.isAdded()) {
                fragmentTransaction.hide(fragment);
            }
        }
        fragment = mFragments.get(index);
        if (fragment.isAdded()) {
            fragmentTransaction.show(fragment);
        } else {
            fragmentTransaction.add(R.id.fragment_container, fragment);
        }
        fragmentTransaction.commitAllowingStateLoss();
    }

    private void initMagicIndicator() {
        homeBinding.magicIndicator6.setBackgroundColor(Color.WHITE);
         commonNavigator = new CommonNavigator(getActivity());
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return mDataList == null ? 0 : mDataList.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                SimplePagerTitleView simplePagerTitleView = new ScaleTransitionPagerTitleView(context);
                simplePagerTitleView.setText(mDataList.get(index));
                simplePagerTitleView.setTextSize(18);
                simplePagerTitleView.setNormalColor(Color.GRAY);
                simplePagerTitleView.setSelectedColor(getResources().getColor(R.color.colorBlue, null));
                simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        mViewPager.setCurrentItem(index);
                        mFragmentContainerHelper.handlePageSelected(index);
                        switchPages(index);
                    }
                });
                return simplePagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                return null;
            }
        });
        homeBinding.magicIndicator6.setNavigator(commonNavigator);
        mFragmentContainerHelper.attachMagicIndicator(homeBinding.magicIndicator6);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_search:
                startActivity(new Intent(getActivity(), SearchActivity.class));
                break;
        }
    }

//    public void setItem(int index){
//        homeBinding.viewPager.setCurrentItem(index);
//    }


}

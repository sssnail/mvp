package com.example.xingzhi.holographicteaching.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.base.MvpFragment;
import com.example.xingzhi.holographicteaching.bean.CenterResultBean;
import com.example.xingzhi.holographicteaching.bean.LoginResultBean;
import com.example.xingzhi.holographicteaching.core.AppControl;
import com.example.xingzhi.holographicteaching.databinding.FragmentMineBinding;
import com.example.xingzhi.holographicteaching.presenter.CenterPresenter;
import com.example.xingzhi.holographicteaching.ui.activity.GameCenterActivity;
import com.example.xingzhi.holographicteaching.ui.activity.LoginActivity;
import com.example.xingzhi.holographicteaching.ui.activity.MineCenterActivity;
import com.example.xingzhi.holographicteaching.ui.activity.MsgActivity;
import com.example.xingzhi.holographicteaching.view.CenterView;
import com.example.xingzhi.holographicteaching.viewmodel.MineViewModel;

public class MineFragment  extends MvpFragment<CenterPresenter> implements CenterView {

    private MineViewModel mineViewModel;
    FragmentMineBinding mineBinding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mineViewModel =
                ViewModelProviders.of(this).get(MineViewModel.class);
        mineBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_mine, container, false);
        mineBinding.setClickEvent(new MineClickEvent());

        Log.d("ddd", "NotificationsFragment");
        mineViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
//                textView.setText(s);
            }
        });
        return mineBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        String string = getString(R.string.mine_balance, String.valueOf(1400));
//        mineBinding.tvBalance.setText(Html.fromHtml(string));
    }

    @Override
    protected void lazyLoadData() {
    }

    @Override
    protected CenterPresenter createPresenter() {
        return new CenterPresenter(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!AppControl.isLogin()) {
            startActivity(new Intent(getActivity(), LoginActivity.class));
            return;
        }
        mvpPresenter.getCenterData();
    }

    @Override
    public void getCenterSuccess(CenterResultBean bean) {
        mineBinding.setBean(bean.getData());
        String string = getString(R.string.mine_balance, String.valueOf(bean.getData().getCoin()));
        mineBinding.tvBalance.setText(Html.fromHtml(string));
        Glide.with(getActivity()).load(bean.getData().getAvatar()).apply(RequestOptions.circleCropTransform()).into(mineBinding.ivPortrait);
    }

    @Override
    public void getCenterFail(String msg) {
        toastShow(getString(R.string.net_error));
    }

    public class MineClickEvent {
        public void gameCenterOnClick(View view) {
            Intent intent = new Intent(getActivity(), GameCenterActivity.class);
            startActivity(intent);
        }

        public void msgCenterOnClick(View view) {
            Intent intent = new Intent(getActivity(), MsgActivity.class);
            startActivity(intent);
        }

        public void personCenterOnClick(View view) {
            Intent intent = new Intent(getActivity(), MineCenterActivity.class);
            startActivity(intent);
        }


    }
}

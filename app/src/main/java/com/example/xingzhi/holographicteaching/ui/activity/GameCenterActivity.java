package com.example.xingzhi.holographicteaching.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.databinding.ActivityGameCenterBinding;
import com.example.xingzhi.holographicteaching.ui.fragment.CenterFootFragment;

import net.lucode.hackware.magicindicator.FragmentContainerHelper;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ClipPagerTitleView;

import java.util.ArrayList;
import java.util.List;

import static net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator.MODE_EXACTLY;

public class GameCenterActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityGameCenterBinding gameCenterBinding;
    private static final String[] CHANNELS = new String[]{"游戏足迹", "我的收藏", "我的预约"};
    private List<Fragment> mFragments = new ArrayList<Fragment>();
    private FragmentContainerHelper mFragmentContainerHelper = new FragmentContainerHelper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameCenterBinding = DataBindingUtil.setContentView(this, R.layout.activity_game_center);
//        gameCenterBinding.setClickEvent(new ClickEvent());
        initFragments();
        initMagicIndicator();
        mFragmentContainerHelper.handlePageSelected(0, false);
        switchPages(0);

        gameCenterBinding.ivBack.setOnClickListener(this);

    }




    private void initFragments() {
        for (int i = 0; i < CHANNELS.length; i++) {
            CenterFootFragment fragment = new CenterFootFragment();
            Bundle bundle = new Bundle();
            bundle.putString(CenterFootFragment.EXTRA_TEXT, CHANNELS[i]);
            fragment.setArguments(bundle);
            mFragments.add(fragment);
        }

    }

    private void initMagicIndicator() {
//        MagicIndicator magicIndicator = (MagicIndicator) findViewById(R.id.magic_indicator1);
//        magicIndicator.setBackgroundResource(R.drawable.round_indicator_bg);
        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return CHANNELS.length;
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                ClipPagerTitleView clipPagerTitleView = new ClipPagerTitleView(context);
                clipPagerTitleView.setText(CHANNELS[index]);
                clipPagerTitleView.setTextColor(Color.parseColor("#999999"));
                clipPagerTitleView.setClipColor(Color.parseColor("#017BFF"));
                clipPagerTitleView.setTextSize(UIUtil.dip2px(context, 20));
                clipPagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mFragmentContainerHelper.handlePageSelected(index);
                        switchPages(index);
                    }
                });
                return clipPagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                indicator.setMode(MODE_EXACTLY);
                indicator.setColors(Color.parseColor("#017BFF"));
                indicator.setLineWidth(25);
                return indicator;
            }
        });
        gameCenterBinding.magicIndicator.setNavigator(commonNavigator);
        mFragmentContainerHelper.attachMagicIndicator(gameCenterBinding.magicIndicator);
    }

    private void switchPages(int index) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                GameCenterActivity.this.finish();
                break;
        }
    }
}

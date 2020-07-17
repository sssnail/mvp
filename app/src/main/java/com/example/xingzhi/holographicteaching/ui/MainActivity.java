package com.example.xingzhi.holographicteaching.ui;


import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.databinding.ActivityMainBinding;
import com.example.xingzhi.holographicteaching.ui.fragment.DashboardFragment;
import com.example.xingzhi.holographicteaching.ui.fragment.HomeFragment;
import com.example.xingzhi.holographicteaching.ui.fragment.MineFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.tencent.mmkv.MMKV;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;

/**
 * @author JC.
 * @explain
 * @creat time 2019/10/30 15:29.
 */
public class MainActivity extends FragmentActivity{


//    @BindView(R.id.text)
//    TextView text;

//    @BindView(R.id.llinearLayout)
//    LinearLayout llinearLayout;

//    @BindView(R.id.nav_view)
//    BottomNavigationView bottomNav;
    private ActivityMainBinding mainBinding;

    //记录当前正在使用的fragment
    private Fragment isFragment;
    private HomeFragment homeFragment;
    private DashboardFragment dashboardFragment;
    private MineFragment mineFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        MMKV mmkv = MMKV.defaultMMKV();
//        mmkv.encode("int",1);
//        int sint = mmkv.decodeInt("int");
//        mmkv.removeValueForKey("int");

//        this.initToolBarAsHome(getString(R.string.hello_world));
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
        //初始化Fragment及底部导航栏
        initFragment(savedInstanceState);
        mainBinding.navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
//        initToolBar("hello");

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    if (homeFragment == null) {
                        homeFragment = new HomeFragment();
                    }
                    switchContent(isFragment, homeFragment);
                    return true;
                case R.id.navigation_dashboard:
                    if (dashboardFragment == null) {
                        dashboardFragment = new DashboardFragment();
                    }
                    switchContent(isFragment, dashboardFragment);
                    return true;
                case R.id.navigation_notifications:
                    if (mineFragment == null) {
                        mineFragment = new MineFragment();
                    }
                    switchContent(isFragment, mineFragment);
                    return true;

            }
            return false;
        }

    };


    public void switchContent(Fragment from, Fragment to) {
        if (isFragment != to) {
            isFragment = to;
            FragmentManager fm = getSupportFragmentManager();
            //添加渐隐渐现的动画
            FragmentTransaction ft = fm.beginTransaction();
            if (!to.isAdded()) {    // 先判断是否被add过
                ft.hide(from).add(R.id.nav_host_fragment, to).commit(); // 隐藏当前的fragment，add下一个到Activity中
            } else {
                ft.hide(from).show(to).commit(); // 隐藏当前的fragment，显示下一个
            }
        }
    }

    public void initFragment(Bundle savedInstanceState) {
        //判断activity是否重建，如果不是，则不需要重新建立fragment.
        if (savedInstanceState == null) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            if (homeFragment == null) {
                homeFragment = new HomeFragment();
            }
            isFragment = homeFragment;
            ft.replace(R.id.nav_host_fragment, homeFragment).commit();
        }
    }

//    @Override
//    protected MainPresenter createPresenter() {
//        return new MainPresenter(this);
//    }
//
//
//    @Override
//    public void getDataSuccess(MainModel model) {
//        //接口成功回调
//        dataSuccess(model);
//    }
//
//    @Override
//    public void getDataFail(String msg) {
//        toastShow(getString(R.string.net_error));
//
//    }


//    public void onClick(View view) {
//
//        //请求接口
//        mvpPresenter.loadDataByRetrofitRxjava("101310222");
//    }


//    private void dataSuccess(MainModel model) {
//        MainModel.WeatherinfoBean weatherinfo = model.getWeatherinfo();
//        String showData = getResources().getString(R.string.city) + weatherinfo.getCity()
//                + getResources().getString(R.string.wd) + weatherinfo.getWD()
//                + getResources().getString(R.string.ws) + weatherinfo.getWS()
//                + getResources().getString(R.string.time) + weatherinfo.getTime();
//        text.setText(showData);
//    }
}

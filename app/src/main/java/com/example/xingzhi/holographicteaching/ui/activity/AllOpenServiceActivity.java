package com.example.xingzhi.holographicteaching.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;

import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.adpter.OpenServiceAdapter;
import com.example.xingzhi.holographicteaching.bean.MsgListBean;
import com.example.xingzhi.holographicteaching.databinding.AcAllOpenServiceBinding;

public class AllOpenServiceActivity extends AppCompatActivity {

    private AcAllOpenServiceBinding binding;
    private OpenServiceAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AllOpenServiceActivity.this.setFinishOnTouchOutside(true);
        binding = DataBindingUtil.setContentView(this, R.layout.ac_all_open_service);
        adapter = new OpenServiceAdapter(this);
        GridLayoutManager manager = new GridLayoutManager(this, 2);
        binding.rvAllService.setLayoutManager(manager);
        binding.rvAllService.setAdapter(adapter);
        for (int i = 0; i < 20; i++) {
            adapter.getItems().add(new MsgListBean.ItemListBean( true, "系统消息", "8小时前", "您于2020年7月7日提现的奖励金¥5789元已到账，请注意查收！"));
        }
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        View view = getWindow().getDecorView();
        WindowManager.LayoutParams lp = (WindowManager.LayoutParams) view.getLayoutParams();
        lp.gravity = Gravity.BOTTOM;
//        lp.x = 10;
//        lp.y = 10;
        lp.width = getWindowManager().getDefaultDisplay().getWidth();
        lp.height = (int)((getWindowManager().getDefaultDisplay().getHeight()) * 0.6);
        getWindowManager().updateViewLayout(view, lp);
    }
}

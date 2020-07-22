package com.example.xingzhi.holographicteaching.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.adpter.DetailAcNoticeAdapter;
import com.example.xingzhi.holographicteaching.adpter.DetailCardAdapter;
import com.example.xingzhi.holographicteaching.bean.DetailNoticeBean;
import com.example.xingzhi.holographicteaching.databinding.ActivityGameDetailBinding;
import com.example.xingzhi.holographicteaching.listener.ItemListener;
import com.example.xingzhi.holographicteaching.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class GameDetailActivity extends AppCompatActivity {

    private ActivityGameDetailBinding binding;
    private DetailAcNoticeAdapter AcNoticeAdapter;
    private DetailAcNoticeAdapter AcBeforeAdapter;
    private DetailCardAdapter cardAdapter;
    private List<String> list;
    private List<View> viewList = new ArrayList<>();
//    private ViewpagerAdapter viewpagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_game_detail);
        AcNoticeAdapter = new DetailAcNoticeAdapter(this);
        AcBeforeAdapter = new DetailAcNoticeAdapter(this);
        cardAdapter = new DetailCardAdapter(this);
        binding.rvAcNotice.setAdapter(AcNoticeAdapter);
        binding.rvAcBefore.setAdapter(AcBeforeAdapter);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);
        binding.rvCard.setLayoutManager(llm);
        binding.rvCard.setAdapter(cardAdapter);
        for (int i = 0; i < 3; i++) {
            AcNoticeAdapter.getItems().add(new DetailNoticeBean.AcNoticeBean( 1, "《星辰战区》代金券活动", "活动有效期：2020-07-07 24:00至2020-07-08 23:59"));
        }
        for (int i = 0; i < 2; i++) {
            AcBeforeAdapter.getItems().add(new DetailNoticeBean.AcNoticeBean( 1, "《星辰战区》代金券活动", "活动有效期：2020-07-07 24:00至2020-07-08 23:59"));
        }
        for (int i = 0; i < 6; i++) {
            cardAdapter.getItems().add(new DetailNoticeBean.DetailCardBean(Utils.getImageUrl()));
        }
        AcNoticeAdapter.setOnItemClickListener(new ItemListener() {
            @Override
            public void itemClick(int i) {
                Toast.makeText(GameDetailActivity.this, String.valueOf(i).concat("点击了"), Toast.LENGTH_SHORT).show();
            }
        });

    }
}

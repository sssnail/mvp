package com.example.xingzhi.holographicteaching.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.adpter.DetailAcNoticeAdapter;
import com.example.xingzhi.holographicteaching.adpter.ViewpagerAdapter;
import com.example.xingzhi.holographicteaching.bean.DetailNoticeBean;
import com.example.xingzhi.holographicteaching.databinding.ActivityGameDetailBinding;
import com.example.xingzhi.holographicteaching.listener.ItemListener;

import java.util.ArrayList;
import java.util.List;

public class GameDetailActivity extends AppCompatActivity {

    private ActivityGameDetailBinding binding;
    private DetailAcNoticeAdapter AcNoticeAdapter;
    private DetailAcNoticeAdapter AcBeforeAdapter;
    private List<String> list;
    private List<View> viewList = new ArrayList<>();
    private ViewpagerAdapter viewpagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_game_detail);
        AcNoticeAdapter = new DetailAcNoticeAdapter(this);
        AcBeforeAdapter = new DetailAcNoticeAdapter(this);
        binding.rvAcNotice.setAdapter(AcNoticeAdapter);
        binding.rvAcBefore.setAdapter(AcBeforeAdapter);
        for (int i = 0; i < 3; i++) {
            AcNoticeAdapter.getItems().add(new DetailNoticeBean.AcNoticeBean( 1, "《星辰战区》代金券活动", "活动有效期：2020-07-07 24:00至2020-07-08 23:59"));
        }
        for (int i = 0; i < 2; i++) {
            AcBeforeAdapter.getItems().add(new DetailNoticeBean.AcNoticeBean( 1, "《星辰战区》代金券活动", "活动有效期：2020-07-07 24:00至2020-07-08 23:59"));
        }
        AcNoticeAdapter.setOnItemClickListener(new ItemListener() {
            @Override
            public void itemClick(int i) {
                Toast.makeText(GameDetailActivity.this, String.valueOf(i).concat("点击了"), Toast.LENGTH_SHORT).show();
            }
        });
        list = new ArrayList<>();
        for (int i = 0; i<5; i++){
            list.add("https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=%E5%9B%BE%E7%89%87&hs=2&pn=4&spn=0&di=48840&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&ie=utf-8&oe=utf-8&cl=2&lm=-1&cs=3984473917%2C238095211&os=3887611006%2C4056826897&simid=3473107907%2C406562779&adpicid=0&lpn=0&ln=30&fr=ala&fm=&sme=&cg=&bdtype=0&oriquery=%E5%9B%BE%E7%89%87&objurl=http%3A%2F%2Fp2.so.qhimgs1.com%2Ft01dfcbc38578dac4c2.jpg&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3Bsjyt3v_z%26e3Bv54AzdH3F1AzdH3F%25Em%25BE%25Bm%25D8%25b0%25Em%25Bn%25lA%25El%25bD%25Ac%25Ec%25bl%25A0%25Ec%25Ad%25lmAzdH3F&gsm=5&islist=&querylist=");
            ImageView imageView = new ImageView(this);
            Glide.with(this).load(list.get(i)).into(imageView);
            viewList.add(imageView);
        }
        binding.viewpager.setAdapter(new ViewpagerAdapter(this, viewList));
        binding.viewpager.setOffscreenPageLimit(3);

    }
}

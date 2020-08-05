package com.example.xingzhi.holographicteaching.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.adpter.GameCardAdapter;
import com.example.xingzhi.holographicteaching.adpter.HomeGameAdapter;
import com.example.xingzhi.holographicteaching.adpter.HomeHotTypeAdapter;
import com.example.xingzhi.holographicteaching.adpter.HomeNewGameAdapter;
import com.example.xingzhi.holographicteaching.adpter.OpenRecordAdapter;
import com.example.xingzhi.holographicteaching.bean.DetailNoticeBean;
import com.example.xingzhi.holographicteaching.bean.ItemListModel;
import com.example.xingzhi.holographicteaching.bean.OpenRecordModel;
import com.example.xingzhi.holographicteaching.databinding.FraGameBinding;
import com.example.xingzhi.holographicteaching.listener.ItemListener;
import com.example.xingzhi.holographicteaching.ui.MainActivity;
import com.example.xingzhi.holographicteaching.ui.activity.GameDetailActivity;
import com.example.xingzhi.holographicteaching.ui.activity.RankingActivity;
import com.example.xingzhi.holographicteaching.utils.GlideImageLoader;
import com.example.xingzhi.holographicteaching.utils.Utils;
import com.example.xingzhi.holographicteaching.view.BannerLayout;

import java.util.ArrayList;
import java.util.List;


public class GameFragment extends Fragment implements View.OnClickListener {
    public static final String EXTRA_TEXT = "extra_string";
    FraGameBinding binding;
    private OpenRecordAdapter adapter;
    private GameCardAdapter gameCardAdapter;
    private HomeGameAdapter hotGameAdapter;
    private HomeNewGameAdapter newGameAdapter;
    private HomeHotTypeAdapter hotTypeAdapter;
    private List bannerList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,  R.layout.fra_game, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        binding.llRanking.setOnClickListener(this);
        TextView textView = (TextView) view.findViewById(R.id.text_view);
        Bundle bundle = getArguments();
        if (bundle != null) {
            textView.setText(bundle.getString(EXTRA_TEXT));
        }
        bannerList = new ArrayList();
        bannerList.add(Utils.getImageUrl());
        bannerList.add(Utils.getImageUrl());
        bannerList.add(Utils.getImageUrl());

        /**
         * 此为动态生成title和content， 现在暂时先固定内容
         *
         */
//          Glide.with(getActivity()).load(Utils.getImageUrl()).into(binding.ivTop);


          if (bundle.getString(EXTRA_TEXT).equals("推荐")){

              //设置加载器
              binding.banner.setImageLoader(new GlideImageLoader());
              binding.banner.setViewUrls(bannerList);
//添加点击监听
              binding.banner.setOnBannerItemClickListener(new BannerLayout.OnBannerItemClickListener() {
                  @Override
                  public void onItemClick(int position) {
                      Toast.makeText(getActivity(), String.valueOf(position), Toast.LENGTH_SHORT).show();
                  }
              });
              //精品推荐部分处理
              binding.homeFraLayout.recommentTitle.tvTitle.setText("精品推荐");
              gameCardAdapter = new GameCardAdapter(getActivity());
              LinearLayoutManager llm = new LinearLayoutManager(getActivity());
              llm.setOrientation(LinearLayoutManager.HORIZONTAL);
              binding.homeFraLayout.rvRecomCard.setLayoutManager(llm);
              binding.homeFraLayout.rvRecomCard.setAdapter(gameCardAdapter);
              for (int i = 0; i < 3; i++) {
                  gameCardAdapter.getItems().add(new DetailNoticeBean.DetailCardBean(Utils.getImageUrl()));
              }
              //热门游戏部分处理
              binding.homeFraLayout.hotGameTitle.tvTitle.setText("热门游戏");
              hotGameAdapter = new HomeGameAdapter(getActivity());
              binding.homeFraLayout.rvHotGame.setAdapter(hotGameAdapter);
              for (int i = 0; i < 3; i++) {
                  hotGameAdapter.getItems().add(new ItemListModel.ItemListBean( "胜者为王", "4.5折", "全方位体验一个不一样的...", "传奇", "传奇9服", 0, Utils.getLabels()));
              }
              //新游预告部分处理
              binding.homeFraLayout.newGameTitle.tvTitle.setText("新游预告");
              binding.homeFraLayout.newGameTitle.tvMore.setVisibility(View.GONE);
              binding.homeFraLayout.newGameTitle.tvContent.setText("已有55555预约");
              binding.homeFraLayout.newGameTitle.tvContent.setVisibility(View.VISIBLE);
              newGameAdapter = new HomeNewGameAdapter(getActivity());
              LinearLayoutManager llnewGame = new LinearLayoutManager(getActivity());
              llnewGame.setOrientation(LinearLayoutManager.HORIZONTAL);
              binding.homeFraLayout.rvNewGameCard.setLayoutManager(llnewGame);
              binding.homeFraLayout.rvNewGameCard.setAdapter(newGameAdapter);
              for (int i = 0; i < 3; i++) {
                  newGameAdapter.getItems().add(new DetailNoticeBean.DetailCardBean(Utils.getImageUrl()));
              }
              binding.homeFraLayout.rvNewGame.setAdapter(hotGameAdapter);

              //传奇部分处理
              binding.homeFraLayout.legendTitle.tvTitle.setText("传奇");
              binding.homeFraLayout.legendTitle.tvContent.setText("和兄弟一起重温攻沙热血！");
              binding.homeFraLayout.legendTitle.tvContent.setVisibility(View.VISIBLE);
              binding.homeFraLayout.rvLegend.setAdapter(hotGameAdapter);
              //卡牌部分
              binding.homeFraLayout.cardTitle.tvTitle.setText("卡牌");
              binding.homeFraLayout.cardTitle.tvContent.setText("来一起感受欧皇十连抽！");
              binding.homeFraLayout.cardTitle.tvContent.setVisibility(View.VISIBLE);
              binding.homeFraLayout.rvCard.setAdapter(hotGameAdapter);
              //三国部分
              binding.homeFraLayout.nationTitle.tvTitle.setText("三国");
              binding.homeFraLayout.nationTitle.tvContent.setText("一起主宰乱世的战火纷争！");
              binding.homeFraLayout.nationTitle.tvContent.setVisibility(View.VISIBLE);
              binding.homeFraLayout.rvNation.setAdapter(hotGameAdapter);
              //PRG部分
              binding.homeFraLayout.prgTitle.tvTitle.setText("RPG");
              binding.homeFraLayout.prgTitle.tvContent.setText("一起感受异世界的奇幻情缘！");
              binding.homeFraLayout.prgTitle.tvContent.setVisibility(View.VISIBLE);
              binding.homeFraLayout.rvPrg.setAdapter(hotGameAdapter);
              //热门类型部分
              binding.homeFraLayout.hotTypeTitle.tvTitle.setText("热门类型");
              binding.homeFraLayout.hotTypeTitle.ivFire.setVisibility(View.VISIBLE);
              binding.homeFraLayout.hotTypeTitle.tvMore.setVisibility(View.GONE);
              hotTypeAdapter = new HomeHotTypeAdapter(getActivity());
              for (int i = 0; i < 8; i++) {
                  hotTypeAdapter.getItems().add(new DetailNoticeBean.DetailCardBean(Utils.getImageUrl()));
              }
              binding.homeFraLayout.rvHotType.setLayoutManager(new GridLayoutManager(getActivity(), 4));
              binding.homeFraLayout.rvHotType.setAdapter(hotTypeAdapter);
          }else {
              binding.homeFraLayout.rlLayout.setVisibility(View.GONE);
              binding.llRanking.setVisibility(View.GONE);
              binding.banner.setVisibility(View.GONE);
              binding.openRecordRv.setVisibility(View.VISIBLE);
              adapter = new OpenRecordAdapter(getActivity());
              binding.openRecordRv.setAdapter(adapter);
              adapter.setDate(new OpenRecordModel().getData());
              adapter.setOnItemClickListener(new ItemListener() {
                  @Override
                  public void itemClick(int i) {
                      startActivity(new Intent(getActivity(), GameDetailActivity.class));
                  }
              });
          }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_ranking:
                startActivity(new Intent(getActivity(), RankingActivity.class));
                break;
        }
    }
}

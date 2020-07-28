package com.example.xingzhi.holographicteaching.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.adpter.GameCardAdapter;
import com.example.xingzhi.holographicteaching.adpter.GameCenterAdapter;
import com.example.xingzhi.holographicteaching.adpter.HomeGameAdapter;
import com.example.xingzhi.holographicteaching.adpter.HomeHotTypeAdapter;
import com.example.xingzhi.holographicteaching.adpter.HomeNewGameAdapter;
import com.example.xingzhi.holographicteaching.adpter.OpenRecordAdapter;
import com.example.xingzhi.holographicteaching.bean.DetailNoticeBean;
import com.example.xingzhi.holographicteaching.bean.ItemListModel;
import com.example.xingzhi.holographicteaching.bean.OpenRecordModel;
import com.example.xingzhi.holographicteaching.databinding.FraGameBinding;
import com.example.xingzhi.holographicteaching.listener.ItemListener;
import com.example.xingzhi.holographicteaching.ui.activity.GameDetailActivity;
import com.example.xingzhi.holographicteaching.ui.activity.RankingActivity;
import com.example.xingzhi.holographicteaching.utils.Utils;


public class GameFragment extends Fragment implements View.OnClickListener {
    public static final String EXTRA_TEXT = "extra_string";
    FraGameBinding binding;
    private OpenRecordAdapter adapter;
    private GameCardAdapter gameCardAdapter;
    private HomeGameAdapter hotGameAdapter;
    private HomeNewGameAdapter newGameAdapter;
    private HomeHotTypeAdapter hotTypeAdapter;

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

        /**
         * 此为动态生成title和content， 现在暂时先固定内容
         * Glide.with(getActivity()).load(Utils.getImageUrl()).into(binding.ivTop);
         *         adapter = new OpenRecordAdapter(getActivity());
         *         binding.openRecordRv.setAdapter(adapter);
         *         adapter.setDate(new OpenRecordModel().getData());
         *         adapter.setOnItemClickListener(new ItemListener() {
         *             @Override
         *             public void itemClick(int i) {
         *                 startActivity(new Intent(getActivity(), GameDetailActivity.class));
         *             }
         *         });
         */
        //精品推荐部分处理
        binding.recommentTitle.tvTitle.setText("精品推荐");
        gameCardAdapter = new GameCardAdapter(getActivity());
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);
        binding.rvRecomCard.setLayoutManager(llm);
        binding.rvRecomCard.setAdapter(gameCardAdapter);
        for (int i = 0; i < 3; i++) {
            gameCardAdapter.getItems().add(new DetailNoticeBean.DetailCardBean(Utils.getImageUrl()));
        }
        //热门游戏部分处理
        binding.hotGameTitle.tvTitle.setText("热门游戏");
        hotGameAdapter = new HomeGameAdapter(getActivity());
        binding.rvHotGame.setAdapter(hotGameAdapter);
        for (int i = 0; i < 3; i++) {
            hotGameAdapter.getItems().add(new ItemListModel.ItemListBean( "胜者为王", "4.5折", "全方位体验一个不一样的...", "传奇", "传奇9服", 0, Utils.getLabels()));
        }
        //新游预告部分处理
        binding.newGameTitle.tvTitle.setText("新游预告");
        binding.newGameTitle.tvMore.setVisibility(View.GONE);
        binding.newGameTitle.tvContent.setText("已有55555预约");
        binding.newGameTitle.tvContent.setVisibility(View.VISIBLE);
        newGameAdapter = new HomeNewGameAdapter(getActivity());
        LinearLayoutManager llnewGame = new LinearLayoutManager(getActivity());
        llnewGame.setOrientation(LinearLayoutManager.HORIZONTAL);
        binding.rvNewGameCard.setLayoutManager(llnewGame);
        binding.rvNewGameCard.setAdapter(newGameAdapter);
        for (int i = 0; i < 3; i++) {
            newGameAdapter.getItems().add(new DetailNoticeBean.DetailCardBean(Utils.getImageUrl()));
        }
        binding.rvNewGame.setAdapter(hotGameAdapter);

        //传奇部分处理
        binding.legendTitle.tvTitle.setText("传奇");
        binding.legendTitle.tvContent.setText("和兄弟一起重温攻沙热血！");
        binding.legendTitle.tvContent.setVisibility(View.VISIBLE);
        binding.rvLegend.setAdapter(hotGameAdapter);
        //卡牌部分
        binding.cardTitle.tvTitle.setText("卡牌");
        binding.cardTitle.tvContent.setText("来一起感受欧皇十连抽！");
        binding.cardTitle.tvContent.setVisibility(View.VISIBLE);
        binding.rvCard.setAdapter(hotGameAdapter);
        //热门类型部分
        binding.hotTypeTitle.tvTitle.setText("热门类型");
        binding.hotTypeTitle.ivFire.setVisibility(View.VISIBLE);
        binding.hotTypeTitle.tvMore.setVisibility(View.GONE);
        hotTypeAdapter = new HomeHotTypeAdapter(getActivity());
        for (int i = 0; i < 8; i++) {
            hotTypeAdapter.getItems().add(new DetailNoticeBean.DetailCardBean(Utils.getImageUrl()));
        }
        binding.rvHotType.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        binding.rvHotType.setAdapter(hotTypeAdapter);
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

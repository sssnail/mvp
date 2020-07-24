package com.example.xingzhi.holographicteaching.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.adpter.GameCenterAdapter;
import com.example.xingzhi.holographicteaching.databinding.FraSearchResultBinding;
import com.example.xingzhi.holographicteaching.listener.ItemListener;
import com.example.xingzhi.holographicteaching.bean.ItemListModel;
import com.example.xingzhi.holographicteaching.ui.activity.GameDetailActivity;
import com.example.xingzhi.holographicteaching.utils.Utils;

/**
 * A fragment representing a list of Items.
 */
public class SearchResultFragment extends Fragment {

    public static final String EXTRA_TEXT = "extra_foot";

    private GameCenterAdapter gameCenterAdapter;
//    ItemListModel itemListModel;
    private String searchText;

    FraSearchResultBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,  R.layout.fra_search_result, container, false);
//        itemListModel = ViewModelProviders.of(getActivity()).get(ItemListModel.class);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        gameCenterAdapter = new GameCenterAdapter(getContext());
        binding.list.setAdapter(gameCenterAdapter);

        Bundle bundle = getArguments();
        if (bundle != null) {
//            binding.textView.setText(bundle.getString(EXTRA_TEXT));
        }
        for (int i = 0; i < 3; i++) {
            gameCenterAdapter.getItems().add(new ItemListModel.ItemListBean( "搜索", "4.5折", "全方位体验一个不一样的...", "传奇", "传奇9服", 0, Utils.getLabels()));
        }
        gameCenterAdapter.setOnItemClickListener(new ItemListener() {
            @Override
            public void itemClick(int i) {
                startActivity(new Intent(getActivity(), GameDetailActivity.class));
//                Toast.makeText(getActivity(), String.valueOf(i).concat("点击了"), Toast.LENGTH_SHORT).show();
            }
        });



//        binding.textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getActivity(), "dd", Toast.LENGTH_SHORT).show();
//                gameCenterAdapter.showFootView();
//            }
//        });
    }
}

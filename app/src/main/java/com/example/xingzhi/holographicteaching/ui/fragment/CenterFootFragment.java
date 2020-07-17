package com.example.xingzhi.holographicteaching.ui.fragment;

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
import com.example.xingzhi.holographicteaching.databinding.FraFootprintBinding;
import com.example.xingzhi.holographicteaching.adpter.GameCenterAdapter;
import com.example.xingzhi.holographicteaching.listener.ItemListener;
import com.example.xingzhi.holographicteaching.modle.ItemListModel;

/**
 * A fragment representing a list of Items.
 */
public class CenterFootFragment extends Fragment {

    FraFootprintBinding footprintBinding;
    public static final String EXTRA_TEXT = "extra_foot";

    private GameCenterAdapter gameCenterAdapter;
//    ItemListModel itemListModel;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        footprintBinding = DataBindingUtil.inflate(inflater,  R.layout.fra_footprint, container, false);
//        itemListModel = ViewModelProviders.of(getActivity()).get(ItemListModel.class);

        return footprintBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        gameCenterAdapter = new GameCenterAdapter(getContext());
        footprintBinding.list.setAdapter(gameCenterAdapter);
        for (int i = 0; i < 3; i++) {
            gameCenterAdapter.getItems().add(new ItemListModel.ItemListBean( "胜者为王", "4.5折", "全方位体验一个不一样的...", "传奇", "传奇9服", 0));
        }
        gameCenterAdapter.setOnItemClickListener(new ItemListener() {
            @Override
            public void itemClick(int i) {
                Toast.makeText(getActivity(), String.valueOf(i).concat("点击了"), Toast.LENGTH_SHORT).show();
            }
        });

        Bundle bundle = getArguments();
        if (bundle != null) {
            footprintBinding.textView.setText(bundle.getString(EXTRA_TEXT));
        }

        footprintBinding.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "dd", Toast.LENGTH_SHORT).show();
                gameCenterAdapter.showFootView();
            }
        });
    }
}

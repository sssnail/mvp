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
import com.example.xingzhi.holographicteaching.adpter.PartnerAdapter;
import com.example.xingzhi.holographicteaching.bean.ItemListModel;
import com.example.xingzhi.holographicteaching.databinding.LayoutRvBinding;
import com.example.xingzhi.holographicteaching.listener.ItemListener;
import com.example.xingzhi.holographicteaching.ui.activity.PartnerOrderActivity;
import com.example.xingzhi.holographicteaching.utils.Utils;

/**
 * A fragment representing a list of Items.
 */
public class PartnerFragment extends Fragment {

    LayoutRvBinding binding;
    public static final String EXTRA_TEXT = "extra_foot";

    private PartnerAdapter adapter;
//    ItemListModel itemListModel;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,  R.layout.layout_rv, container, false);
//        itemListModel = ViewModelProviders.of(getActivity()).get(ItemListModel.class);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapter = new PartnerAdapter(getContext());
        binding.list.setAdapter(adapter);
        for (int i = 0; i < 3; i++) {
            adapter.getItems().add(new ItemListModel.ItemListBean( "用户昵称", "4.5折", "178***5862", "传奇", "注册时间:2020-06-27 11:33", 0, Utils.getLabels()));
        }
        adapter.setOnItemClickListener(new ItemListener() {
            @Override
            public void itemClick(int i) {
                startActivity(new Intent(getActivity(), PartnerOrderActivity.class));
            }
        });

        Bundle bundle = getArguments();
        if (bundle != null) {
            binding.textView.setText(bundle.getString(EXTRA_TEXT));
        }

        binding.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "dd", Toast.LENGTH_SHORT).show();
                adapter.showFootView();
            }
        });
    }
}

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

import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.adpter.OpenRecordAdapter;
import com.example.xingzhi.holographicteaching.bean.OpenRecordModel;
import com.example.xingzhi.holographicteaching.databinding.FraGameBinding;
import com.example.xingzhi.holographicteaching.listener.ItemListener;
import com.example.xingzhi.holographicteaching.ui.activity.GameDetailActivity;


public class GameFragment extends Fragment {
    public static final String EXTRA_TEXT = "extra_string";
    FraGameBinding binding;
    private OpenRecordAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,  R.layout.fra_game, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        TextView textView = (TextView) view.findViewById(R.id.text_view);
        Bundle bundle = getArguments();
        if (bundle != null) {
            textView.setText(bundle.getString(EXTRA_TEXT));
        }
        adapter = new OpenRecordAdapter();
        binding.openRecordRv.setAdapter(adapter);
        adapter.setDate(new OpenRecordModel().getData());
        adapter.setOnItemClickListener(new ItemListener() {
            @Override
            public void itemClick(int i) {
                startActivity(new Intent(getActivity(), GameDetailActivity.class));
            }
        });
//        binding.openRecordRv.setLayoutManager(new LinearLayoutManager(getActivity()){
//            @Override
//            public boolean canScrollVertically() {
//                return false;
//            }
//        });

    }
}

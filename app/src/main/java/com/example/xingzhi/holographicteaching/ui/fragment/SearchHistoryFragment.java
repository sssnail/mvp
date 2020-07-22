package com.example.xingzhi.holographicteaching.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.databinding.FraSearchHistoryBinding;

/**
 * A fragment representing a list of Items.
 */
public class SearchHistoryFragment extends Fragment {


    FraSearchHistoryBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,  R.layout.fra_search_history, container, false);
//        itemListModel = ViewModelProviders.of(getActivity()).get(ItemListModel.class);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        Bundle bundle = getArguments();
        if (bundle != null) {
//            binding.textView.setText(bundle.getString(EXTRA_TEXT));
        }



//        binding.textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getActivity(), "dd", Toast.LENGTH_SHORT).show();
//                gameCenterAdapter.showFootView();
//            }
//        });
    }
}

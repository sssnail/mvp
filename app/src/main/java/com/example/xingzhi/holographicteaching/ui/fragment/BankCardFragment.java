package com.example.xingzhi.holographicteaching.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.databinding.FraBankCardBinding;
import com.example.xingzhi.holographicteaching.ui.activity.WithdrawActivity;

/**
 * A fragment representing a list of Items.
 */
public class BankCardFragment extends Fragment implements View.OnClickListener {

    FraBankCardBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,  R.layout.fra_bank_card, container, false);
        binding.bindConfirm.setOnClickListener(this);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bind_confirm:
                startActivity(new Intent(getActivity(), WithdrawActivity.class));
                break;
        }
    }
}

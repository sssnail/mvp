package com.example.xingzhi.holographicteaching.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.databinding.FragmentDashboardBinding;
import com.example.xingzhi.holographicteaching.ui.activity.AccountBillActivity;
import com.example.xingzhi.holographicteaching.ui.activity.ActivateVipActivity;
import com.example.xingzhi.holographicteaching.ui.activity.MyProfitActivity;
import com.example.xingzhi.holographicteaching.ui.activity.PartnerActivity;
import com.example.xingzhi.holographicteaching.ui.activity.WidrawExplainActivity;
import com.example.xingzhi.holographicteaching.viewmodel.DashboardViewModel;


public class DashboardFragment extends Fragment implements View.OnClickListener {

    private FragmentDashboardBinding binding;
    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel = ViewModelProviders.of(this).get(DashboardViewModel.class);
        binding = DataBindingUtil.inflate(inflater,  R.layout.fragment_dashboard, container, false);
        binding.setClickEvent(new VipClickEvent());
        binding.layoutPower.titleVip.setOnClickListener(this);
//        final TextView textView = root.findViewById(R.id.text_dashboard);
        Log.d("ddd", "DashboardFragment");
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
//                textView.setText(s);
            }
        });
        return binding.getRoot();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.title_vip:
                startActivity(new Intent(getActivity(), MyProfitActivity.class));
                break;
        }
    }

    public class VipClickEvent{
        public void toActivateClick(View view){
            startActivity(new Intent(getActivity(), ActivateVipActivity.class));
        }
        public void toWithdrawClick(View view){
            startActivity(new Intent(getActivity(), WidrawExplainActivity.class));
        }
        public void toBillClick(View view){
            startActivity(new Intent(getActivity(), AccountBillActivity.class));
        }
        public void toPartnerClick(View view){
            startActivity(new Intent(getActivity(), PartnerActivity.class));
        }
    }


}

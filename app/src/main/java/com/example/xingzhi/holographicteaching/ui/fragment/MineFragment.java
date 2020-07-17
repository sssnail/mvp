package com.example.xingzhi.holographicteaching.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
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
import com.example.xingzhi.holographicteaching.databinding.FragmentMineBinding;
import com.example.xingzhi.holographicteaching.ui.activity.GameCenterActivity;
import com.example.xingzhi.holographicteaching.ui.activity.LoginActivity;
import com.example.xingzhi.holographicteaching.ui.activity.MineCenterActivity;
import com.example.xingzhi.holographicteaching.ui.activity.MsgActivity;
import com.example.xingzhi.holographicteaching.viewmodel.MineViewModel;

public class MineFragment extends Fragment {

    private MineViewModel mineViewModel;
    FragmentMineBinding mineBinding ;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mineViewModel =
                ViewModelProviders.of(this).get(MineViewModel.class);
        mineBinding = DataBindingUtil.inflate(inflater,  R.layout.fragment_mine, container, false);
        mineBinding.setClickEvent(new MineClickEvent());

//        View root = inflater.inflate(R.layout.fragment_mine, container, false);
//        final TextView textView = root.findViewById(R.id.text_notifications);
        Log.d("ddd", "NotificationsFragment");
        mineViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
//                textView.setText(s);
            }
        });
        return mineBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String string = getString(R.string.mine_balance, String.valueOf(1400));
        mineBinding.tvBalance.setText(Html.fromHtml(string));
    }

//    @Override
//    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.tv_mine_game_center:
//                Intent intent = new Intent(getActivity(), GameCenterActivity.class);
//                startActivity(intent);
//                break;
//        }
//    }

    public class MineClickEvent{
        public void gameCenterOnClick(View view){
            Intent intent = new Intent(getActivity(), GameCenterActivity.class);
            startActivity(intent);
        }
        public void msgCenterOnClick(View view){
            Intent intent = new Intent(getActivity(), MsgActivity.class);
            startActivity(intent);
        }
        public void personCenterOnClick(View view){
            Intent intent = new Intent(getActivity(), MineCenterActivity.class);
            startActivity(intent);
        }
        public void toLoginOnClick(View view){
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
        }


    }
}

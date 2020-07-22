package com.example.xingzhi.holographicteaching.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.databinding.ActivitySearchBinding;
import com.example.xingzhi.holographicteaching.ui.fragment.SearchHistoryFragment;
import com.example.xingzhi.holographicteaching.ui.fragment.SearchResultFragment;
import com.example.xingzhi.holographicteaching.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener, TextWatcher {

    private ActivitySearchBinding binding;

    public static List<Fragment> fragments = new ArrayList<>();
    public static Fragment curFragment;
    public static FragmentManager fragmentManager;
    public static FragmentTransaction transaction;
    private int SEARCH_HISTORY = 0;
    private int SEARCH_RESULT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_search);
        Utils.setInputEtShowIconListener(binding.etSearch, binding.ivCancel);
        binding.ivCancel.setOnClickListener(this);
        binding.tvSearch.setOnClickListener(this);
        binding.ivBack.setOnClickListener(this);
        binding.etSearch.addTextChangedListener(this);
        fragments = getFragments();
        defaultFragment();
    }

    private void defaultFragment(){
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        curFragment = fragments.get(SEARCH_HISTORY);
        transaction.replace(R.id.fragment_container, curFragment);
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_cancel:
                binding.etSearch.setText(null);
                break;
            case R.id.tv_search:
                setFraChanged(SEARCH_RESULT);
                break;
            case R.id.iv_back:
                SearchActivity.this.finish();
            break;
        }
    }

    public List<Fragment> getFragments(){
        fragments.add(new SearchHistoryFragment());
        fragments.add(new SearchResultFragment());
        return fragments;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    @Override
    public void afterTextChanged(Editable s) {
        if(curFragment != fragments.get(SEARCH_HISTORY)){
            Log.d("ddd", "afterTextChanged");
            setFraChanged(SEARCH_HISTORY);
        }
    }

    private void setFraChanged(int index){
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        curFragment = fragments.get(index);
        transaction.replace(R.id.fragment_container, curFragment);
        transaction.commit();
    }
}

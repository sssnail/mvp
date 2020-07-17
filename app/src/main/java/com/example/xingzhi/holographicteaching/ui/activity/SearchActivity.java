package com.example.xingzhi.holographicteaching.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.databinding.ActivitySearchBinding;
import com.example.xingzhi.holographicteaching.utils.Utils;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivitySearchBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_search);
        Utils.setInputEtShowIconListener(binding.etSearch, binding.ivCancel);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_cancel:
                binding.etSearch.setText(null);
                break;
        }
    }
}

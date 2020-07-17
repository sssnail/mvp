package com.example.xingzhi.holographicteaching.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.xingzhi.holographicteaching.R;



public class TestFragment extends Fragment {
    public static final String EXTRA_TEXT = "extra_string";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.simple_fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        TextView textView = (TextView) view.findViewById(R.id.text_view);
        Bundle bundle = getArguments();
        if (bundle != null) {
            textView.setText(bundle.getString(EXTRA_TEXT));
        }
    }
}

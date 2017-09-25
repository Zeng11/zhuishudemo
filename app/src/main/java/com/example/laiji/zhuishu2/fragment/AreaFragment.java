package com.example.laiji.zhuishu2.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by laiji on 2017/9/24.
 */

public class AreaFragment extends BaseFragment {
    @Override
    public View onChildCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView textView = new TextView(getContext());
        textView.setText(text);
        textView.setTextSize(30);
        return textView;
    }

    @Override
    protected void initData() {

    }
}

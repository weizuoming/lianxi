package com.dash.a02_butter_knife;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Dash on 2018/3/9.
 */
public class ButterKnifeFragment extends Fragment {

    //2.
    @BindView(R.id.button_02)
    Button button_02;
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_butter_kbife_layout, container, false);

        //1.使用butterKnife绑定
        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        button_02.setText("这是fragment的按钮");

    }

    /**
     * 视图销毁的生命周期方法
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        
        //解除绑定
        unbinder.unbind();
    }
}

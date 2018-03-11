package com.dash.a02_event_bus;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by Dash on 2018/3/9.
 */
public class DingYueFragment extends Fragment {

    private TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        textView = new TextView(getActivity());
        textView.setBackgroundColor(Color.RED);

        textView.setText("这是fragment的订阅者");

        return textView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        EventBus.getDefault().register(this);

    }

    @Subscribe(threadMode = ThreadMode.MAIN,priority = -1000)
    public void onToastEvent(ToastEvent toastEvent) {

        textView.setText(toastEvent.getContent());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        EventBus.getDefault().unregister(this);
    }
}

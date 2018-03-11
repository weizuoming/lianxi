package com.dash.a02_event_bus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * 粘性事件
 */
public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }

    public void post(View view) {
        //发送的是粘性事件
        EventBus.getDefault().postSticky(new ToastEvent("粘性事件的发送"));
    }

    public void dingyue(View view) {
        EventBus.getDefault().register(this);

    }

    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void onToastEvent(ToastEvent toastEvent) {
        Toast.makeText(this,toastEvent.getContent(),Toast.LENGTH_SHORT).show();
    }

    public void yiChu(View view) {
        //移除
        EventBus.getDefault().removeStickyEvent(ToastEvent.class);
        EventBus.getDefault().removeAllStickyEvents();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        EventBus.getDefault().unregister(this);
    }
}

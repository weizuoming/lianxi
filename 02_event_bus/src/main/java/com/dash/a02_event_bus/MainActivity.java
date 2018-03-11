package com.dash.a02_event_bus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * 事件的订阅者
 *
 * activity之间 fragment之间 以及fragment与activity之间的传值
 *
 */
public class MainActivity extends AppCompatActivity {


    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        //注册事件
        EventBus.getDefault().register(this);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content,new DingYueFragment()).commit();

    }

    /**
     * 具体注册了对什么事件的订阅，这个需要onEvent()方法来说明
     * @param toastEvent
     *
     * ThreadMode.MAIN不管消息在哪里发送 都在主线程接收这个事件
     *  ThreadMode.BACKGROUND
     *  Async处理事件会开启一个新的线程 这种模式可以耗时操作
     */
    @Subscribe(threadMode = ThreadMode.MAIN,priority = 1000)
    public void onToastEvent(ToastEvent toastEvent) {//参数就是订阅的事件(其实就是传递数据的类)
        //Toast.makeText(this,toastEvent.getContent(),Toast.LENGTH_SHORT).show();
        //取消事件的传送
        EventBus.getDefault().cancelEventDelivery(toastEvent);

        button.setText(toastEvent.getContent());

    }

    //接触事件的订阅
    @Override
    protected void onDestroy() {
        super.onDestroy();

        EventBus.getDefault().unregister(this);
    }

    public void tiaoZhuan(View view) {

        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);
    }
}

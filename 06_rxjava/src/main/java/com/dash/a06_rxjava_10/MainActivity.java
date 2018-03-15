package com.dash.a06_rxjava_10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void rx(View view) {

        //Observable.fromArray();
        Observable<String> observable1 = Observable.just("hello", "rx", "java");
        // onNext("Hello");
        // onNext("Hi");
        // onNext("Aloha");
        // onCompleted();//执行的顺序

        //ApiService---请求数据的接口---被观察者

        //被观察者
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {

                //从而 Observable 可以在需要的时候发出事件来通知 Observer
                emitter.onNext("rxjava");


                emitter.onNext("你好 我是被观察者");
                emitter.onNext("你观察到我的变化了吗");
                emitter.onComplete();
            }
        });
        //观察者
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                Log.e("----",s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.e("---","结束");
            }
        };
        //订阅
        observable.subscribe(observer);
    }
}

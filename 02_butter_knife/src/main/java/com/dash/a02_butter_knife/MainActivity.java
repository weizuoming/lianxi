package com.dash.a02_butter_knife;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindColor;
import butterknife.BindDrawable;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 之前点击事件的写法
 * 1.onClick属性....写一个方法
 * 2.setonclickListner(this)
 * 3.setonClickListner(new 匿名内部类)
 * 4.setonclickListner(内部类对象)
 * <p>
 * 5.使用butterKnife设置点击事件
 */
public class MainActivity extends AppCompatActivity {

    //2.找控件
    @BindView(R.id.hello_world)
    TextView hello_world;

    //3.找到res目录下的资源
    @BindString(R.string.app_name)
    String app_name;

    @BindDrawable(R.mipmap.ic_launcher)
    Drawable bitmapDrawable;

    @BindColor(R.color.colorAccent)
    int color;

    /**
     * 使用butterKnife插件生成控件
     */
    @BindView(R.id.button_01)
    Button button01;
    @BindView(R.id.button_03)
    Button button03;
    @BindView(R.id.button_04)
    Button button04;
    @BindView(R.id.button_05)
    Button button05;
    @BindView(R.id.button_06)
    Button button06;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1.butterKnife绑定当前的activity...一定是在setContentView的下面
        ButterKnife.bind(this);


        hello_world.setText("你好 黄油刀");


    }

    /**
     * 1.随便写一个方法 参数可有可无
     * 2.加一个注解 onClick(id)
     */
    @OnClick(R.id.button_01)
    public void onButtonClick() {
        Toast.makeText(this, "按钮被点击了", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}

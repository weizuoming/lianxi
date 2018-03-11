package com.dash.a02_butter_knife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        getSupportFragmentManager().beginTransaction().replace(R.id.relative_layotut,new ButterKnifeFragment()).commit();

    }
}

package com.example.hello.rikao20180309;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Person person=new Person();
        //解读json串
     //   JsonArray array = new JsonParser().parse(person).getAsJsonArray();
        Gson gson = new Gson();
        Class<Person> cls = null;
        Class clz = this.getClass();
        ParameterizedType type = (ParameterizedType) clz.getGenericSuperclass();
       // Person[] types = type.getActualTypeArguments();
       // cls = (Class<Person>) types[0];
      //  for(final JsonElement elem : array){
      //      mList.add((Person) gson.fromJson(elem, cls));
      //  }
    }
}

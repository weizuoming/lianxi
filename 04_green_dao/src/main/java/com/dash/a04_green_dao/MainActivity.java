package com.dash.a04_green_dao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.dash.a04_green_dao.gen.PersonDao;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.text_note)
    TextView textNote;
    private PersonDao personDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //butterKinife
        ButterKnife.bind(this);

        //获取dao对象
        personDao = DashApplication.getInstances().getDaoSession().getPersonDao();

    }

    @OnClick({R.id.button_add, R.id.button_delete, R.id.button_update, R.id.button_qurey})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_add:

                Person person = new Person();
                person.setAge(23);
                person.setName("张三");
                person.setSex("男");
                personDao.insert(person);//添加一个实体对象

                //personDao.insertInTx();//添加多个实体对象,,,,可变参数

                break;
            case R.id.button_delete:

                //personDao.deleteAll();//删除所有
                //personDao.delete(删除一个人);
                personDao.deleteByKey(1L);//根据主键进行删除

                break;
            case R.id.button_update:

                personDao.update(new Person(1L,"lisi","girl",24));

                break;
            case R.id.button_qurey:

                /*List<Person> list = personDao.loadAll();//查询全部
                if (list.size() != 0) {

                    Log.e("---",list.get(0).getName());
                }

                Person person1 = personDao.load(1L);//根据主键进行查询
                Log.e("----", person1.toString());*/

                //select * from person where id = ? and name= ?
                List<Person> list1 = personDao.queryRaw("where _id = ? and name =?", "3","张三");
                Log.e("---","list集合长度是:"+list1.size());
                break;
        }
    }
}

package com.dash.a04_green_dao;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.dash.a04_green_dao.gen.DaoMaster;
import com.dash.a04_green_dao.gen.DaoSession;

/**
 * Created by Dash on 2018/3/10.
 */
public class DashApplication extends Application {

    private static DashApplication instances;//整个应用的上下文
    private DaoMaster.DevOpenHelper mHelper;
    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        instances = this;

        setDatabase();//设置greenDao
    }

    /**
     * 设置greenDao
     *
     * 1.获取helper对象 目的是为了拿到数据库
     * 2.拿到数据库 目的创建DaoMaster对象
     * 3.使用daoMaster创建seesion对象,会话....使用会话对象拿到personDao
     *
     */
    private void setDatabase() {

        mHelper = new DaoMaster.DevOpenHelper(this, "bawei", null);//string便是数据库的名字
        db = mHelper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();

    }

    /**
     * 对外提供获取seesion的方法
     * @return
     */
    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    /**
     * 对外提供获取数据库的方法
     * @return
     */
    public SQLiteDatabase getDb() {
        return db;
    }


    /**
     * 对外地宫返回上下文的方法
     * @return
     */
    public static DashApplication getInstances(){
        return instances;
    }
}

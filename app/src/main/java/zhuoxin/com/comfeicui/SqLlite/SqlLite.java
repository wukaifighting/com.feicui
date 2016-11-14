package zhuoxin.com.comfeicui.SqLlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import zhuoxin.com.comfeicui.db.DBInfo;

/**
 * Created by Administrator on 2016/11/8.
 */

public class SqlLite extends SQLiteOpenHelper {
    //创建的方法
    //Context context 上下文
    //String name数据库名字
    //SQLiteDatabase.CursorFactory factory  游标工厂 null则使用磨人的游标
    //int version  数据库版本
    public SqlLite(Context context) {
        super(context, DBInfo.DB_NAME, null, DBInfo.DB_VERSION);
    }

    //重写构造方法
    //创建数据库
    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建表
        String sql = "create table %1$s(%2$s text,%3$s text,%4$s text,%5$s integer,%6$s text,%7$s text,%8$s integer)";
        String fomart = String.format(sql, DBInfo.TABLE_NAME, DBInfo.summary, DBInfo.icon, DBInfo.stamp, DBInfo.title, DBInfo.nid, DBInfo.link, DBInfo.type);
        db.execSQL(fomart);
// String sql="create table data(summary Text,icon Text,stamp Text,title Text,nid Integer,link Text,type Integer)";
        //执行SQL语句，创建一张表
//        db.execSQL(sql);

    }

    //版本更新
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

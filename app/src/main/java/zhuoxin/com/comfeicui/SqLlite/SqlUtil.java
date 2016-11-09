package zhuoxin.com.comfeicui.SqLlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import zhuoxin.com.comfeicui.db.DBInfo;

/**
 * Created by Administrator on 2016/11/9.
 */

public class SqlUtil {
    Context mContext;
    SqlLite sqlLite;

    public SqlUtil(Context mContext) {
        this.mContext = mContext;
        sqlLite = new SqlLite(mContext);
    }
    //插入数据
    public  void insert(String summary,String icon,String stamp,String title,String nid,String link,String type){
       SQLiteDatabase database=sqlLite.getWritableDatabase();
//        String sql="insert into test values(1,)";
//        database.execSQL(sql);
        ContentValues values=new ContentValues();
        values.put(DBInfo.summary,"");
        values.put(DBInfo.icon,"");
        values.put(DBInfo.stamp,"");
        values.put(DBInfo.title,"");
        values.put(DBInfo.nid,"");
        values.put(DBInfo.link,"");
        values.put(DBInfo.type,"");
 database.insert(DBInfo.TABLE_NAME,null,values);

    }
}

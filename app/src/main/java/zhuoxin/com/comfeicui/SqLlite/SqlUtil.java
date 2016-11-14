package zhuoxin.com.comfeicui.SqLlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import zhuoxin.com.comfeicui.Info.Centerchild;
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
//    public void  insertl(){
//        SQLiteDatabase database=sqlLite.getWritableDatabase();
//        ContentValues values=new ContentValues();
//        values.put(DBInfo.summary,"1");
//        values.put(DBInfo.icon,"2");
//        values.put(DBInfo.stamp,"3");
//        values.put(DBInfo.title,"4");
//        values.put(DBInfo.nid,"5");
//        values.put(DBInfo.link,"6");
//        values.put(DBInfo.type,"7");
//        database.insert(DBInfo.TABLE_NAME,null,values);
//    };
    //插入数据
    public  void insert(String summary,String icon,String stamp,String title,String  nid,String link,String type){
       SQLiteDatabase database=sqlLite.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(DBInfo.summary,summary);
        values.put(DBInfo.icon,icon);
        values.put(DBInfo.stamp,stamp);
        values.put(DBInfo.title,title);
        values.put(DBInfo.nid,nid);
        values.put(DBInfo.link,link);
        values.put(DBInfo.type,type);
 database.insert(DBInfo.TABLE_NAME,null,values);

    }
   public   ArrayList<Centerchild>  query(){
       SQLiteDatabase sqLiteDatabase=sqlLite.getReadableDatabase();
       ArrayList<Centerchild>  list=new ArrayList<>();
       Cursor cursor=sqLiteDatabase.query(DBInfo.TABLE_NAME,null,null,null,null,null,null,null);
       while (cursor.moveToNext()){
           String summary=cursor.getString(cursor.getColumnIndex("summary"));
           String icon=cursor.getString(cursor.getColumnIndex("icon"));
           String stamp=cursor.getString(cursor.getColumnIndex("stamp"));
           String title=cursor.getString(cursor.getColumnIndex("title"));
           String nid=cursor.getString(cursor.getColumnIndex("nid"));
           String link=cursor.getString(cursor.getColumnIndex("link"));
           String type=cursor.getString(cursor.getColumnIndex("type"));
           list.add(new Centerchild(summary,icon,stamp,title,nid,link,type));
       }
       return list;
   }


//删除
    public void delete(int nid){
        SQLiteDatabase db=sqlLite.getWritableDatabase();
          db.delete(DBInfo.TABLE_NAME,"nid"+"=?",new String[]{nid+""});

    }
}

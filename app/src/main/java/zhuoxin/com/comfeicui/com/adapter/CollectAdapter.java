package zhuoxin.com.comfeicui.com.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import zhuoxin.com.comfeicui.Info.Centerchild;
import zhuoxin.com.comfeicui.R;

/**
 * Created by Administrator on 2016/11/14.
 */

public class CollectAdapter  extends BaseAdapter {
    ArrayList<Centerchild> mList;
    Context mContext;
    public CollectAdapter(ArrayList<Centerchild> mList,  Context mContext){
         this.mList=mList;
        this.mContext=mContext;
    }
    @Override
    public int getCount() {
        return null==mList?0:mList.size();
    }

    @Override
    public Object getItem(int position) {
        return getItem(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Hodle hodle=null;
        if (convertView==null){
            hodle=new Hodle();
            convertView= LayoutInflater.from(mContext).inflate(R.layout.collectadapter,parent,false);
            hodle.imageView= (ImageView) convertView.findViewById(R.id.img_collect);
            hodle.mTxt_0= (TextView) convertView.findViewById(R.id.txt_collectadapter_0);
            hodle.mTxt_1= (TextView) convertView.findViewById(R.id.txt_collectadapter_1);
            hodle.mTxt_2= (TextView) convertView.findViewById(R.id.txt_collectadapter_2);

        }
        return null;
    }
    static class Hodle{
        ImageView imageView;
        TextView mTxt_0;
        TextView mTxt_1;
        TextView mTxt_2;

    }
}

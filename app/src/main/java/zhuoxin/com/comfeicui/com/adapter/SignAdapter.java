package zhuoxin.com.comfeicui.com.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import zhuoxin.com.comfeicui.Info.SignInfo;
import zhuoxin.com.comfeicui.R;

/**
 * Created by Administrator on 2016/11/10.
 */

public class SignAdapter extends BaseAdapter {
     ArrayList<SignInfo>  mList;
    Context context;

    public SignAdapter( ArrayList<SignInfo>  mList,Context context){
         this.mList=mList;
        this.context=context;
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
      holder holder=null;
        if (null==convertView) {
            holder=new holder();
            convertView = LayoutInflater.from(context).inflate(R.layout.signdladapter, parent, false);
            holder.mTxt_date= (TextView) convertView.findViewById(R.id.txt_sign_dateadapter);
            holder.mTxt_local= (TextView) convertView.findViewById(R.id.txt_sign_localadapter);
            holder.mTxt_datelocal= (TextView) convertView.findViewById(R.id.txt_sign_datelocaladapter);
            convertView.setTag(holder);
        }else {
            holder= (holder) convertView.getTag();
            //时间
            holder.mTxt_date.setText(mList.get(position).getDate());
            //地点
            holder.mTxt_local.setText(mList.get(position).getLocal());
            //实时信息
            holder.mTxt_datelocal.setText(mList.get(position).getLocaldate());
        }
        return convertView;
    }
    static class  holder{
        TextView mTxt_date;
        TextView  mTxt_local;
        TextView mTxt_datelocal;
    }
}

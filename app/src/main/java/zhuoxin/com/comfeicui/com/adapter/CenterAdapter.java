package zhuoxin.com.comfeicui.com.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import zhuoxin.com.comfeicui.Info.Centerchild;
import zhuoxin.com.comfeicui.R;

/**
 * Created by Administrator on 2016/10/31.
 */

public class CenterAdapter extends BaseAdapter {
    ArrayList<Centerchild> list;
    Context context;
    //    public CenterAdapter( ArrayList<Centerchild> list,  Context context) {
//        super(context);
//       this.context=context;
//        this.list=list;
//
//
//    }
//    @Override
//    public View setview(int position, View convertView, ViewGroup parent) {
//        Holder holder=null;
//        if (convertView==null){
//            holder=new Holder();
//            convertView= inflater.inflate(R.layout.centerlistview,parent,false);
//            holder.mImg= (ImageView) convertView.findViewById(R.id.img_centerlst);
//            holder.mTxt_0= (TextView) convertView.findViewById(R.id.txt_centerlst0);
//            holder.mTxt_1= (TextView) convertView.findViewById(R.id.txt_centerlst1);
//            holder.mTxt_2= (TextView) convertView.findViewById(R.id.txt_centerlst2);
//            convertView.setTag(holder);
//        }else {
//          holder= (Holder) convertView.getTag();
////获取图片
//            Glide.with(context).load(list.get(position).getIcon()).into(holder.mImg);
//            //标题
//            holder.mTxt_0.setText(list.get(position).getTitle());
//            //内容
//            holder.mTxt_1.setText(list.get(position).getSummary());
//            //时间
//            holder.mTxt_2.setText(list.get(position).getStamp());
//        }
//        return convertView;
//    }
    public CenterAdapter(ArrayList<Centerchild> list, Context context) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return null == list ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = null;
        if (convertView == null) {
            holder = new Holder();
            convertView = LayoutInflater.from(context).inflate(R.layout.centerlistview, parent, false);
            holder.mImg = (ImageView) convertView.findViewById(R.id.img_centerlst);
            holder.mTxt_0 = (TextView) convertView.findViewById(R.id.txt_centerlst0);
            holder.mTxt_1 = (TextView) convertView.findViewById(R.id.txt_centerlst1);
            holder.mTxt_2 = (TextView) convertView.findViewById(R.id.txt_centerlst2);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
//获取图片
            Glide.with(context).load(list.get(position).getIcon()).into(holder.mImg);
            //标题
            holder.mTxt_0.setText(list.get(position).getTitle());
            //内容
            holder.mTxt_1.setText(list.get(position).getSummary());
            //时间
            holder.mTxt_2.setText(list.get(position).getStamp());
            //网址

        }
        return convertView;
    }

    static class Holder {
        ImageView mImg;
        TextView mTxt_0;
        TextView mTxt_1;
        TextView mTxt_2;


    }
}

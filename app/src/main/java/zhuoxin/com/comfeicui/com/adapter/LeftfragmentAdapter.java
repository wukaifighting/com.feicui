package zhuoxin.com.comfeicui.com.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import zhuoxin.com.comfeicui.Info.LeftfragmentInfo;
import zhuoxin.com.comfeicui.R;

/**
 * Created by Administrator on 2016/10/28.
 */

public class LeftfragmentAdapter extends BaseAdapter {
    Context mContext;
    String[] name = {"新闻", "收藏", "本地", "跟帖", "图片"};
    String[] ename = {"NEWS", "FAVORITE", "LOCAL", "COMMENT", "PHOTO"};
    int[] img = {R.drawable.biz_navigation_tab_news, R.drawable.biz_navigation_tab_read, R.drawable.biz_navigation_tab_local_news, R.drawable.biz_navigation_tab_ties,
            R.drawable.biz_navigation_tab_pics};
    ArrayList<LeftfragmentInfo> mData = new ArrayList<>();

    public LeftfragmentAdapter(Context mContext) {
        this.mContext = mContext;
        mData.clear();

        for (int i = 0; i < 5; i++) {
            mData.add(new LeftfragmentInfo(name[i], ename[i]));
        }

    }

    @Override
    public int getCount() {
        return null == mData ? 0 : mData.size();
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
        holder holder = null;
        if (null == convertView) {
            holder = new holder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.leftfragement_main, parent, false);
           holder.txt_a = (TextView) convertView.findViewById(R.id.txt_left_frag0);
            holder.txt_b= (TextView) convertView.findViewById(R.id.txt_left_frag1);
            holder.imgleft= (ImageView) convertView.findViewById(R.id.img_lestfrage);
            convertView.setTag(holder);
        }else {
            holder= (holder) convertView.getTag();
        }
        holder.imgleft.setImageResource(img[position]);
        holder.txt_a.setText(mData.get(position).getName());
        holder.txt_b.setText(mData.get(position).getEname());

      return  convertView;

    }

    static class holder {
        ImageView imgleft;
        TextView txt_a;
        TextView txt_b;
    }
}

package zhuoxin.com.comfeicui.com.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/10/31.
 */

public abstract class PriAdapter<T> extends BaseAdapter {
    //加泛型
    ArrayList<T> list;
    LayoutInflater inflater;

    public PriAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<T> list) {
        if (this.list != null) {
            this.list.clear();
        }
        this.list.addAll(list);
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

        return setview(position, convertView, parent);
    }

    public abstract View setview(int position, View convertView, ViewGroup parent);
}

package zhuoxin.com.comfeicui.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import me.maxwin.view.XListView;
import zhuoxin.com.comfeicui.Activity.CenterActivity;
import zhuoxin.com.comfeicui.Info.Centerchild;
import zhuoxin.com.comfeicui.Info.Centerperson;
import zhuoxin.com.comfeicui.R;
import zhuoxin.com.comfeicui.Util.Centilutil;
import zhuoxin.com.comfeicui.com.adapter.CenterAdapter;
import zhuoxin.com.comfeicui.interfacea.Centerinterface;

/**
 * Created by Administrator on 2016/11/1.
 */

public class CenterFragment extends Fragment implements Centerinterface, XListView.IXListViewListener, AdapterView.OnItemClickListener {
    XListView mXlistview;
    public static final String PATH = "http://118.244.212.82:9092/newsClient/news_list?ver=1&subid=1&dir=1&nid=1&stamp=20140321&cnt=20";
    static ArrayList<Centerchild> list = new ArrayList<>();
    Context context;
    Handler handle;
    int mPosition;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.center_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mXlistview = (XListView) view.findViewById(R.id.xlst);
        //监听事件，不监听没反应
        mXlistview.setXListViewListener(this);
        initData();
    }

    private void initData() {
        Centilutil centuil = new Centilutil();
        centuil.Centilutil(this);
        centuil.execute(PATH);

    }

    @Override
    public void onRefresh() {
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                stop();
            }
        }, 2000);
    }

    //停止加载和刷新
    public void stop() {
        mXlistview.stopLoadMore();
        mXlistview.stopRefresh();
        //设置时间‘

        SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        mXlistview.setRefreshTime(format.format(System.currentTimeMillis()));
    }

    @Override
    public void onLoadMore() {

        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                stop();
            }
        }, 2000);

    }

    @Override
    public void centerface(String string) {
        Gson gson = new Gson();
        Type type = new TypeToken<Centerperson>() {
        }.getType();
        Centerperson person = gson.fromJson(string, type);
        list = (ArrayList<Centerchild>) person.getData();
        CenterAdapter centeradapter = new CenterAdapter(list, getContext());
        mXlistview.setAdapter(centeradapter);
        //监听
        mXlistview.setOnItemClickListener(this);
        centeradapter.notifyDataSetChanged();
        handle = new Handler();
        //上拉加载，下拉刷新
        mXlistview.setPullLoadEnable(true);
        mXlistview.setPullRefreshEnable(true);


    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getActivity(), CenterActivity.class);
        intent.putExtra("position",position-1);
        startActivity(intent);
    }

    public static ArrayList<Centerchild> getlist() {
        return list;
    }
}




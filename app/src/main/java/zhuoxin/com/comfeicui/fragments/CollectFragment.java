package zhuoxin.com.comfeicui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import zhuoxin.com.comfeicui.Activity.CollectActivity;
import zhuoxin.com.comfeicui.Info.Centerchild;
import zhuoxin.com.comfeicui.R;
import zhuoxin.com.comfeicui.SqLlite.SqlUtil;
import zhuoxin.com.comfeicui.com.adapter.CenterAdapter;

/**
 * Created by Administrator on 2016/11/4.
 */

public class CollectFragment extends Fragment implements AdapterView.OnItemClickListener
{
    ArrayList<Centerchild> list;
    ListView mlst_collect;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.collect_main,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    mlst_collect= (ListView) view.findViewById(R.id.lst_collection);
        mlst_collect.setOnItemClickListener(this);
        initdata();
    }

    private void initdata() {
        SqlUtil squlit=new SqlUtil(getActivity());
        list=squlit.query();
        CenterAdapter centeradapter=new CenterAdapter(list,getActivity());
        mlst_collect.setAdapter(centeradapter);
        centeradapter.notifyDataSetChanged();
        Log.e("===","list=="+list);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent= new Intent(getActivity(), CollectActivity.class);
        intent.putExtra("position",position);


////////        startActivityForResult(intent,-1);
       startActivity(intent);
    }

















//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode == -1) {
//            switch (requestCode) {
//
//                case 1:
//                {if(data!=null) {
//                    Bundle bun = data.getBundleExtra("data");
//                   bun.getInt("position");
//                }
//                    break;}
//
//    }}}
}

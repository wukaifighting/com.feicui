package zhuoxin.com.comfeicui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import zhuoxin.com.comfeicui.Activity.MainActivity;
import zhuoxin.com.comfeicui.R;

/**
 * Created by Administrator on 2016/10/28.
 */

public class LeftFragment extends Fragment implements AdapterView.OnItemClickListener {
    ListView mlst;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.left, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mlst = (ListView) view.findViewById(R.id.lst_left);

        mlst.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                CenterFragment centerFragment = new CenterFragment();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.center, centerFragment);
                fragmentTransaction.commit();
                MainActivity.close();
                break;
            case 1:
                CollectFragment collectFragment = new CollectFragment();
                FragmentTransaction collect = getActivity().getSupportFragmentManager().beginTransaction();
                collect.replace(R.id.center, collectFragment);
                collect.commit();
                MainActivity.close();
        }
    }
}


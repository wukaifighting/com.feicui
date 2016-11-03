package zhuoxin.com.comfeicui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import zhuoxin.com.comfeicui.Activity.MainActivity;
import zhuoxin.com.comfeicui.R;

/**
 * Created by Administrator on 2016/10/28.
 */

public class RightFragment extends Fragment implements View.OnClickListener{
    ImageView mImg_right_y;
    TextView  mTxt_right;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.right,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        mTxt_right= (TextView) view.findViewById(R.id.txt_right_dl);
        CenterFragment centerFragment=new CenterFragment();
        //获取业务处理器
        FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.center,centerFragment);
        fragmentTransaction.commit();

        mTxt_right.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
switch (v.getId()){

    case R.id.txt_right_dl:
         LoginFragment dengluFragment=new LoginFragment();
        FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.center,dengluFragment);
        fragmentTransaction.commit();
        MainActivity.close();

}
    }
}

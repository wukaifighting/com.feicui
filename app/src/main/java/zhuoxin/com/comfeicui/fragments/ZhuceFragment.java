package zhuoxin.com.comfeicui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import zhuoxin.com.comfeicui.R;

/**
 * Created by Administrator on 2016/11/2.
 */

public class ZhuceFragment extends Fragment implements View.OnClickListener
//        ,HttpInterface
{
    RequestQueue requestQueue;
  EditText mEdit_email;
  EditText mEdit_name;
  EditText mEdit_password;
    Button mBtn_zc;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.zhuce_main, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        requestQueue= Volley.newRequestQueue(getActivity());
        mEdit_email= (EditText) view.findViewById(R.id.edt_email);
        mEdit_name= (EditText) view.findViewById(R.id.edt_name);
        mEdit_password= (EditText) view.findViewById(R.id.edt_password);
        mBtn_zc= (Button) view.findViewById(R.id.btn_zc);
        mEdit_name.setOnClickListener(this);
        mEdit_email.setOnClickListener(this);
        mEdit_password.setOnClickListener(this);
        mBtn_zc.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_zc:
                     String name = mEdit_name.getText().toString();
                     String email = mEdit_email.getText().toString();
                     String password = mEdit_password.getText().toString();
//                StringRequest request=new HttpUtil().getconnection( HttpInfo.BASE_URL+ HttpInfo.REGISTER+"ver=1&uid="+name+"&email="+email+"&pwd="+password",this,)
        }
//        HttpInfo.BASE_URL+HttpInfo.REGISTER+"ver=1&uid="+name+"&email="+email+"&pwd="+password"
    }

//    @Override
//    public void getresponse(String message) {

//    }
}
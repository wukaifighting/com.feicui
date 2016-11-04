package zhuoxin.com.comfeicui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import zhuoxin.com.comfeicui.Info.HttpInfo;
import zhuoxin.com.comfeicui.R;
import zhuoxin.com.comfeicui.Util.HttpUtil;
import zhuoxin.com.comfeicui.interfacea.HttpInterface;

/**
 * Created by Administrator on 2016/11/2.
 */

public class LoginFragment extends Fragment implements View.OnClickListener, HttpInterface {
    Button mBtn_zc;
    Button mBtn_wjmm;
    Button mBtn_ddl;
    EditText mEdt_name;
    EditText mEdit_password;
    RequestQueue requestQueue;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.denglu, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mEdt_name = (EditText) view.findViewById(R.id.edit_dl_name);
        mEdit_password = (EditText) view.findViewById(R.id.edt_dl_password);
        mBtn_zc = (Button) view.findViewById(R.id.btn_denglu_zhuce);
        mBtn_wjmm = (Button) view.findViewById(R.id.btn_denglu_wjmm);
        mBtn_ddl = (Button) view.findViewById(R.id.btn_denglu_dl);
        mBtn_ddl.setOnClickListener(this);
        mBtn_wjmm.setOnClickListener(this);
        mBtn_zc.setOnClickListener(this);
        requestQueue = Volley.newRequestQueue(getActivity());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_denglu_zhuce:
                RegistFragment fragment = new RegistFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.center, fragment);
                fragmentTransaction.commit();
                Toast.makeText(getActivity(),"开始注册",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_denglu_wjmm:
                ForgetFragment wjmmFragment = new ForgetFragment();
                FragmentTransaction fragmentT = getFragmentManager().beginTransaction();
                fragmentT.replace(R.id.center, wjmmFragment);
                fragmentT.commit();
                Toast.makeText(getActivity(),"请按提示输入",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_denglu_dl:
                String name = mEdt_name.getText().toString();
                String password = mEdit_password.getText().toString();
                new HttpUtil().startconnection(HttpInfo.BASE_URL + HttpInfo.START, name, password, this, requestQueue);
                SignFragment signFragment=new SignFragment();
                FragmentTransaction sign=getFragmentManager().beginTransaction();
                sign.replace(R.id.center,signFragment);
                sign.commit();
                Toast.makeText(getActivity(),"登录成功",Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void getresponse(String message) {

        Log.e("messagr", "message" + message);
//        try {
//            JSONObject jsonObject=new JSONObject(message);
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
    }
}

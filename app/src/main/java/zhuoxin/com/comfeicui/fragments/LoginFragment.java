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

import org.json.JSONException;
import org.json.JSONObject;

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
    int status=-1;
    String explian;
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

                switch (status){
                    case -1:
                        Toast.makeText(getActivity(),"请重新输入",Toast.LENGTH_SHORT).show();
                        break;

                    case 0:
                        SignFragment signFragment=new SignFragment();
                        FragmentTransaction sign=getFragmentManager().beginTransaction();
                        sign.replace(R.id.center,signFragment);
                        sign.commit();
                        Toast.makeText( getActivity(),explian,Toast.LENGTH_SHORT).show();
                        break;
                }


        }
    }

    @Override
    public void getresponse(String message) {

        Log.e("messagr", "message" + message);

        try {
            JSONObject jsonObject=new JSONObject(message);
            String message1=jsonObject.getString("message");
            status=jsonObject.getInt("status");
            JSONObject data=jsonObject.getJSONObject("data");
            int result=data.getInt("result");
            String token=data.getString("token");
               explian=data.getString("explain");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

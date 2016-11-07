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

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;
import zhuoxin.com.comfeicui.Activity.MainActivity;
import zhuoxin.com.comfeicui.R;

/**
 * Created by Administrator on 2016/10/28.
 */

public class RightFragment extends Fragment implements View.OnClickListener {
    ImageView mImg_right_y;
    TextView mTxt_right;
    ImageView mImg_weixin;
    ImageView mImg_qq;
    ImageView mImg_freiends;
    ImageView mImg_weibo;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.right, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        mTxt_right = (TextView) view.findViewById(R.id.txt_right_dl);
        mImg_weixin = (ImageView) view.findViewById(R.id.img_wexin);
        mImg_qq = (ImageView) view.findViewById(R.id.img_qq);
        mImg_freiends = (ImageView) view.findViewById(R.id.img_friends);
        mImg_weibo = (ImageView) view.findViewById(R.id.img_weibo);
        CenterFragment centerFragment = new CenterFragment();
        //获取业务处理器
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.center, centerFragment);
        fragmentTransaction.commit();

        mTxt_right.setOnClickListener(this);
        mImg_weibo.setOnClickListener(this);
        mImg_freiends.setOnClickListener(this);
        mImg_qq.setOnClickListener(this);
        mImg_weixin.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.txt_right_dl:
                LoginFragment dengluFragment = new LoginFragment();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.center, dengluFragment);
                fragmentTransaction.commit();
                MainActivity.close();
                break;
            case R.id.img_wexin:
                //初始化sdk
                ShareSDK.initSDK(getActivity());
                //实例化对象
                OnekeyShare onekeyShare = new OnekeyShare();
                //关闭sso授权
                onekeyShare.disableSSOWhenAuthorize();
                //开启分享
                onekeyShare.show(getActivity());
                break;
            case R.id.img_friends:
                //初始化sdk
                ShareSDK.initSDK(getActivity());
                //实例化对象
                OnekeyShare frends = new OnekeyShare();
                //关闭sso授权
                frends.disableSSOWhenAuthorize();
                //开启分享
                frends.show(getActivity());
                break;
            case R.id.img_qq:
                //初始化sdk
                ShareSDK.initSDK(getActivity());
                //实例化对象
                OnekeyShare qq = new OnekeyShare();
                //关闭sso授权
                qq.disableSSOWhenAuthorize();
                //开启分享
                qq.show(getActivity());
                break;
            case R.id.img_weibo:
                //初始化sdk
                ShareSDK.initSDK(getActivity());
                //实例化对象
                OnekeyShare weibo = new OnekeyShare();
                //关闭sso授权
                weibo.disableSSOWhenAuthorize();
                //开启分享
                weibo.show(getActivity());
                break;

        }
    }

}

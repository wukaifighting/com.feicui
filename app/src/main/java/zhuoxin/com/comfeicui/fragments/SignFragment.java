package zhuoxin.com.comfeicui.fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;

import java.io.File;

import zhuoxin.com.comfeicui.R;

/**
 * Created by Administrator on 2016/11/4.
 */

public class SignFragment extends Fragment implements View.OnClickListener ,AdapterView.OnItemClickListener{
    Button mBtn_sign;
    ImageView mImg_sign;
    ImageView mImg_camera;
    ImageView mImg_packup;
    PopupWindow popupWindow;
    File file;
    String path;
     ListView mLst_sign;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout
                .signdl, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBtn_sign = (Button) view.findViewById(R.id.btn_sign);
        mImg_sign = (ImageView) view.findViewById(R.id.img_signdl);
        mLst_sign= (ListView) view.findViewById(R.id.lst_sign);
        mBtn_sign.setOnClickListener(this);
        mImg_sign.setOnClickListener(this);
        mLst_sign.setOnItemClickListener(this);
        popupWindow = new PopupWindow();
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.signpopupwindow, null, false);
        popupWindow.setContentView(inflate);
        mImg_camera = (ImageView) inflate.findViewById(R.id.camera);
        mImg_packup = (ImageView) inflate.findViewById(R.id.packup);
        mImg_camera.setOnClickListener(this);
        mImg_packup.setOnClickListener(this);
        //设置焦点
        popupWindow.setFocusable(true);
        //设置点击取消
        popupWindow.setOutsideTouchable(true);
        //设置背景，没有背景取消不掉
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        //设置宽高
        popupWindow.setHeight(LinearLayout.LayoutParams.MATCH_PARENT);
        popupWindow.setWidth(LinearLayout.LayoutParams.WRAP_CONTENT);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1) {
            switch (requestCode) {
                case 1: {
//                    Bitmap bitmap = BitmapFactory.decodeFile(file.getPath());
//                    mImg_sign.setImageBitmap(bitmap);
                    cropfile(file);
                    break;
                }
                case 2: {
//                    //通过内容提供者获取系统数据
//                    ContentResolver contentresolver = getActivity().getContentResolver();
//                    //根据拿数据
//                    // 地址
//                    Uri uri = data.getData();
//                    String[] aray = {MediaStore.Images.Media.DATA};
//                    Cursor cursor = contentresolver.query(uri, aray, null, null, null);
//                    cursor.moveToFirst();
//                    String path = cursor.getString(cursor.getColumnIndex(aray[0]));
//                    //关闭游标
//                    cursor.close();
//                    //拿图pian
//                    Bitmap bitmap = BitmapFactory.decodeFile(path);
//                    mImg_sign.setImageBitmap(bitmap);
                    crop(data.getData());
                    break;
                }
                case 3:
                    Bitmap bitmap = data.getParcelableExtra("data");
                    mImg_sign.setImageBitmap(bitmap);
                    break;


            }


        }
    }

    //剪切图库图片
    public void crop(Uri uri) {
        //使用意图剪切照片
        Intent intent = new Intent();
        //设置剪切图片和类型
        intent.setDataAndType(uri, "image/*");
        //设置剪切意图
        intent.setAction("com.android.camera.action.CROP");
        //开启剪切
        intent.putExtra("crop", "true");
        //设置比例
        intent.putExtra("asppectX", 1);
        intent.putExtra("asppectY", 1);
        //设置裁剪后输出的照片大小
        intent.putExtra("outputX", 200);
        intent.putExtra("outputY", 200);
        //设置剪切圆形照片
        intent.putExtra("circleCrop","true");
        intent.putExtra("scale",true);
        //设置返回数据
        intent.putExtra("return-data", true);
        //启动
        startActivityForResult(intent, 3);


    }

    //剪切照片图片
    public void cropfile(File file) {
        //使用意图剪切照片
        Intent intent = new Intent();
        //设置剪切图片和类型
        intent.setDataAndType(Uri.fromFile(file), "image/*");
        //设置剪切意图
        intent.setAction("com.android.camera.action.CROP");
        //开启剪切
        intent.putExtra("crop", "true");
        //设置比例
        intent.putExtra("asppectX", 1);
        intent.putExtra("asppectY", 1);
        //设置裁剪后输出的照片大小
        intent.putExtra("outputX", 200);
        intent.putExtra("outputY", 200);
        //设置剪切圆形照片
        intent.putExtra("circleCrop","true");
        intent.putExtra("scale",true);
        //设置返回数据
        intent.putExtra("return-data", true);
        //启动
        startActivityForResult(intent, 3);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_sign:
                CenterFragment centerFragment = new CenterFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.center, centerFragment);
                fragmentTransaction.commit();
                break;

            case R.id.img_signdl:
                popupWindow.showAsDropDown(v, 0, 550);
//                popupWindow.showAtLocation(getActivity().getLayoutInflater().inflate(R.layout.signdl,null), Gravity.BOTTOM,0,0);
                break;
            //调用系统相机
            case R.id.camera: {
                //调用系统相机
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //z照相,需要提供路径用于保存照
//                if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                 String   path = Environment.getExternalStorageDirectory().getPath();
//                }

                //文件
                // //separator  分隔符
                file = new File(path + File.separator + System.currentTimeMillis() + ".jpg");
                //设置保存路径
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                //启动回调
                startActivityForResult(intent, 1);


                break;
            }
            //从图库中获取照片
            case R.id.packup: {
                //进入图库获取照片意图
                Intent intent = new Intent(Intent.ACTION_PICK);
                //设置类型
                intent.setType("image/*");
                startActivityForResult(intent, 2);

                break;
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}

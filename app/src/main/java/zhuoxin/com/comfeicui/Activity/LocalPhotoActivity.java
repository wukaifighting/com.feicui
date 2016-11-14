package zhuoxin.com.comfeicui.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import zhuoxin.com.comfeicui.R;
import zhuoxin.com.comfeicui.interfacea.LocalInterface;
import zhuoxin.com.comfeicui.view.LocalPhotoback;

/**
 * Created by Administrator on 2016/11/14.
 */

public class LocalPhotoActivity extends AppCompatActivity implements LocalInterface,View.OnClickListener{
    SurfaceView mSurfaceView;
    Button mButton;
    SeekBar mSeekbar;
    LocalPhotoback callback;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.localphoto);

//        //获取照相机对象打开照相机
//         Camera camera= Camera.open();
//        //获取照相机参数
//        Camera.Parameters parameters=camera.getParameters();

    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        mSurfaceView= (SurfaceView) findViewById(R.id.suface_local);
        mButton= (Button) findViewById(R.id.camera_photo);
        mSeekbar= (SeekBar) findViewById(R.id.seekbar);
        //回调，执行想要的CAMERA
        SurfaceHolder holder=mSurfaceView.getHolder();
        //设置参数
        //设置大小来自布局
         holder.setSizeFromLayout();
        //s设置屏幕常亮
        holder.setKeepScreenOn(true);
        //设置像素
        holder.setFormat(PixelFormat.JPEG);
       //设置surfac中的数据来自于照相机
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        //添加回调.需要自定义view
        callback=new LocalPhotoback(this);
        holder.addCallback(callback);
        mSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                callback.setzoom(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //获得最大焦距
                int maxzoom = callback.getmaxzoom();
                seekBar.setMax(maxzoom);

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
       mButton.setOnClickListener(this);

    }


    @Override
    public void getbitmap(Bitmap bitmap) {
        Intent intent=new Intent(this,ShowLocalPhotoActivity.class);
        intent.putExtra("img", bitmap);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.camera_photo:
            callback.takephoto();
        break;}

    }
}

package zhuoxin.com.comfeicui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageFormat;
import android.hardware.Camera;
import android.os.Environment;
import android.view.SurfaceHolder;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import zhuoxin.com.comfeicui.interfacea.LocalInterface;

/**
 * Created by Administrator on 2016/11/14.
 */

public class LocalPhotoback implements SurfaceHolder.Callback {
    Camera camera;
    LocalInterface localinterface;

    public LocalPhotoback(LocalInterface localinterface) {
        this.localinterface = localinterface;
    }

    //获取相机数量
    public int getnumbercamera(Context context) {
        int numberOfCameras = Camera.getNumberOfCameras();
        if (numberOfCameras == 0) {
            Toast.makeText(context, "相机不存在", Toast.LENGTH_SHORT).show();
        }
        if (numberOfCameras == 1) {
            return 0;
        }
        //多个摄像头
        Camera.CameraInfo camerainfo = new Camera.CameraInfo();
        for (int i = 0; i < numberOfCameras; i++) {
            //匹配
            Camera.getCameraInfo(i, camerainfo);
            if (camerainfo.facing == Camera.CameraInfo.CAMERA_FACING_BACK) {
                return i;
            }
        }
        return 0;
    }

    //设置焦距的方法
    public void setzoom(int zoom) {
        Camera.Parameters parameters = camera.getParameters();
        parameters.setZoom(zoom);
        camera.setParameters(parameters);
    }

    //拿到最大焦距
    public int getmaxzoom() {
        return camera.getParameters().getMaxZoom();

    }

    //拍照
    public void takephoto() {
        camera.takePicture(null, null, new Camera.PictureCallback() {
            @Override
            public void onPictureTaken(byte[] data, Camera camera) {
                //字节数组转为照片
                Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
                //存照片
                String paths = Environment.getExternalStorageDirectory().getPath();
                File file = new File(paths + File.separator + System.currentTimeMillis() + ".jpg");
                try {
                    FileOutputStream output = new FileOutputStream(file);
                    //压缩照片
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 90, output);
                    output.close();
                    if (localinterface != null) {
                        localinterface.getbitmap(bitmap);
                        camera.startPreview();
                    }


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        camera.stopPreview();
    }

    //创建
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        //打开相机，默认打开后置相机
        if (camera != null) {
            camera.stopPreview();
            camera.release();
            camera = null;
        }
        camera = Camera.open();
        //获取照相机参数
        Camera.Parameters parameters = camera.getParameters();
        //图片质量
        parameters.setJpegQuality(80);
        //聚焦
        parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE);
        //设置闪光灯打开状态
        List<String> supportedFlashModes = camera.getParameters().getSupportedFlashModes();
        if (supportedFlashModes != null) {
            parameters.setFlashMode(Camera.Parameters.FLASH_MODE_AUTO);
        }
        //旋转角度
//        parameters.setRotation(180);
        //像素
        parameters.setPictureFormat(ImageFormat.JPEG);
        //保存参数
        camera.setParameters(parameters);
        //开启预览
        camera.startPreview();
        //人脸识别
        camera.startFaceDetection();
        ///设置参数
        camera.setDisplayOrientation(90);
        try {
            camera.setPreviewDisplay(holder);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //改变
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    //销毁
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        if (camera != null) {
            camera.stopPreview();
            camera.release();
            camera = null;
        }
    }
}

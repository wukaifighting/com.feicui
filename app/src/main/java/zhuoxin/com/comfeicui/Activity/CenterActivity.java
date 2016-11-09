package zhuoxin.com.comfeicui.Activity;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import zhuoxin.com.comfeicui.Info.Centerchild;
import zhuoxin.com.comfeicui.Info.Centerperson;
import zhuoxin.com.comfeicui.R;
import zhuoxin.com.comfeicui.Util.Centilutil;
import zhuoxin.com.comfeicui.interfacea.Centerinterface;

/**
 * Created by Administrator on 2016/11/1.
 */

public class CenterActivity extends AppCompatActivity implements Centerinterface ,View.OnClickListener{
    ArrayList<Centerchild> list;
    WebView mWeb;
    int mposition;
    public static final String PATH = "http://118.244.212.82:9092/newsClient/news_list?ver=1&subid=1&dir=1&nid=1&stamp=20140321&cnt=20";
    Button mBtn_left;
    ImageView mImg_right;
    PopupWindow popupWindow;
    Button btn_pup;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = this.getIntent();
        mposition = intent.getIntExtra("position", -1);
        setContentView(R.layout.centershow);

        /////////////////



    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        mWeb = (WebView) findViewById(R.id.wbv_center);
        mBtn_left= (Button) findViewById(R.id.btn_centershow_left);
        mImg_right= (ImageView) findViewById(R.id.btn_centershow_right);
        Centilutil centuil = new Centilutil();
        centuil.Centilutil(this);
        centuil.execute(PATH);
        mBtn_left.setOnClickListener(this);
        mImg_right.setOnClickListener(this);


        //下拉菜单设置
         popupWindow=new PopupWindow();
         //设置VIEW
     View inflate=  this.getLayoutInflater().inflate(R.layout.popupwindow,null,false);

        popupWindow.setContentView(inflate);

          btn_pup = (Button) inflate.findViewById(R.id.btn_pupwindow);
        //设置焦点
        popupWindow.setFocusable(true);
        //设置点击取消
        popupWindow.setOutsideTouchable(true);
        //设置背景，没有 背景取消不了
//      popupWindow.setBackgroundDrawable(getResources().getDrawable(R.mipmap.pupodingwndow));
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        //设置宽高
        popupWindow.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        //显示


    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode== KeyEvent.KEYCODE_BACK) {
//            mWeb.goBack();
//            return true;
//        }
//        return super.onKeyDown(keyCode, event);
//    }


    @Override
    public void centerface(String string) {
        Gson gson = new Gson();
        Type type = new TypeToken<Centerperson>() {
        }.getType();
        Centerperson person = gson.fromJson(string, type);
        ArrayList<Centerchild> list = (ArrayList<Centerchild>) person.getData();
        //加载网页
        mWeb.loadUrl(list.get(mposition - 1).getLink());
        //设置客户端的显示样式
        WebSettings mWebSettings = mWeb.getSettings();
        //js代码 自动识别是网页端手机端
        mWebSettings.setJavaScriptEnabled(true);
        //设置自动适应屏幕大小
//        mWebSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN );
        //设置webview 推荐格式
        mWebSettings.setUseWideViewPort(true);
        //自适应大小并且可以任意放大或缩小
        mWebSettings.setLoadWithOverviewMode(true);
        //设置是否能放大或缩小
        mWebSettings.setSupportZoom(true);
        //设置显示按钮
        mWebSettings.setBuiltInZoomControls(true);
        //设置调制窗口
        mWebSettings.setSupportMultipleWindows(true);
        //设置显示控制器
        mWebSettings.setBuiltInZoomControls(true);
        //设置自己的客户端
        mWeb.setWebViewClient(new WebViewClient() {
                                  @Override
                                  public boolean shouldOverrideUrlLoading(WebView view, String url) {
                                      view.loadUrl(url);
                                      return super.shouldOverrideUrlLoading(view, url);
                                  }
                              }
        );
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){


            case R.id.btn_centershow_right:

               popupWindow.showAsDropDown(v);
                break;
            case R.id.btn_pupwindow:

                Toast.makeText(this,"收藏成功，请在主页面查看",Toast.LENGTH_LONG).show();
                break;
        }
    }
}

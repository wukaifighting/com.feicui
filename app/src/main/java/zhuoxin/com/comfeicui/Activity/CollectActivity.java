package zhuoxin.com.comfeicui.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import zhuoxin.com.comfeicui.R;
import zhuoxin.com.comfeicui.SqLlite.SqlUtil;

/**
 * Created by Administrator on 2016/11/14.
 */

public class CollectActivity extends AppCompatActivity {
    WebView mWeb;
    int mposition;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collectshow);

    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        mWeb = (WebView) findViewById(R.id.web_collect);
        Intent intent = this.getIntent();
        mposition = intent.getIntExtra("position", -1);
        Log.e("mposition","mposition"+mposition);
        SqlUtil sqlUtil = new SqlUtil(this);
        //加载网页
        mWeb.loadUrl(sqlUtil.query().get(mposition).getLink());
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


}


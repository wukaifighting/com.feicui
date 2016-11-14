package zhuoxin.com.comfeicui.Activity;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import java.util.ArrayList;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;
import zhuoxin.com.comfeicui.Info.Centerchild;
import zhuoxin.com.comfeicui.R;
import zhuoxin.com.comfeicui.SqLlite.SqlUtil;
import zhuoxin.com.comfeicui.fragments.CenterFragment;

/**
 * Created by Administrator on 2016/11/1.
 */

public class CenterActivity extends AppCompatActivity implements View.OnClickListener{
    ArrayList<Centerchild> list=new ArrayList<>();
    WebView mWeb;
    int mposition;
     Button btn_share;
    Button mBtn_left;
    ImageView mImg_right;
    PopupWindow popupWindow;
    Button btn_pup;
    Button btn_data;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.centershow);
        mBtn_left= (Button) findViewById(R.id.btn_centershow_left);
        mImg_right= (ImageView) findViewById(R.id.btn_centershow_right);
        mBtn_left.setOnClickListener(this);
        mImg_right.setOnClickListener(this);
        btn_data= (Button) findViewById(R.id.btn_data);
        btn_data.setOnClickListener(this);
        /////////////////
        //下拉菜单设置
        popupWindow=new PopupWindow();
        //设置VIEW
        View inflate=  this.getLayoutInflater().inflate(R.layout.popupwindow,null,false);

        popupWindow.setContentView(inflate);

        btn_pup = (Button) inflate.findViewById(R.id.btn_pupwindow);
        btn_share= (Button) inflate.findViewById(R.id.btn_share);
        btn_pup.setOnClickListener(this);
        btn_share.setOnClickListener(this);
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


    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();


        mWeb = (WebView) findViewById(R.id.wbv_center);
        Intent intent = this.getIntent();
        mposition = intent.getIntExtra("position",-1);
        list=CenterFragment.getlist();
        //加载网页
        mWeb.loadUrl(list.get(mposition).getLink());
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
            case R.id.btn_centershow_left:
//
//                Intent intent=new Intent(this, CenterFragment.class);
////                intent.putExtra("position",-1);
//                startActivity(intent);
                Intent intent=new Intent();
                Bundle  bundle=new Bundle();
                bundle.putInt("position",mposition);
                intent.putExtra("bundle",bundle);
                CenterActivity.this.setResult(-1,intent);
                finish();

                break;

            case R.id.btn_centershow_right:

               popupWindow.showAsDropDown(v);
                break;
            case R.id.btn_pupwindow:
                 SqlUtil squlituil=new SqlUtil(this);
                Log.e("====","集合+++"+list);
                String summary=list.get(mposition).getSummary();
                String  icon =list.get(mposition).getIcon();
                String stamp=list.get(mposition).getStamp();
                String title=list.get(mposition).getTitle();
                String  nid=list.get(mposition).getNid();
                String link=list.get(mposition).getLink();
                String type=list.get(mposition).getType();
                for (int i=0;i<squlituil.query().size();i++){
                    if (nid.equals(squlituil.query().get(i).getNid())) {
                        Toast.makeText(this,"请勿重复收藏",Toast.LENGTH_LONG).show();
                        return;
                    }
                }
                squlituil.insert(summary,icon,stamp,title,nid,link,type);
                Toast.makeText(this,"收藏成功，请在收藏页面查看",Toast.LENGTH_LONG).show();
                break;
            case R.id.btn_share:
                //初始化sdk
                ShareSDK.initSDK(this);
                //实例化对象
                OnekeyShare onekeyShare = new OnekeyShare();
                //关闭sso授权
                onekeyShare.disableSSOWhenAuthorize();
                onekeyShare.setText(list.get(mposition).getTitle());
                onekeyShare.setTitle(list.get(mposition).getSummary());
                onekeyShare.setTitleUrl(list.get(mposition).getLink());
                //开启分享
                onekeyShare.show(this);

                break;
            case R.id.btn_data:
//                ClickDateFragment clickDateFragment=new ClickDateFragment();
//                FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
//                fragmentTransaction.replace(R.id.center,clickDateFragment);
//                fragmentTransaction.commit();

//                Intent intent1=new Intent(CenterActivity.class, ClickDateFragment);

        }
    }
}

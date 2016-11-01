package zhuoxin.com.comfeicui.Activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import zhuoxin.com.comfeicui.R;

/**
 * Created by Administrator on 2016/10/27.
 */

public class logActivity  extends Activity {
//设置常量首值
    public static  final String PREFS_NAME="config";
    public static final  String IS_FIRST="first";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences shard=this.getSharedPreferences(PREFS_NAME,MODE_APPEND);
        //使其默认第一次输入
        boolean flag=shard.getBoolean(IS_FIRST,true);
        if (flag){
            //第一次进入加载控件
            Intent intent=new Intent(logActivity.this,guidActivity.class);
            startActivity(intent);
            SharedPreferences.Editor editor= shard.edit();
            //设置使用之后的值
            editor.putBoolean(IS_FIRST,false);
            editor.commit();
            //结束此次运行
            this.finish();
        }else {
            //加载内容
            setContentView(R.layout.log_main);
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_logo);
            ImageView imageView = (ImageView) findViewById(R.id.img_logo);
            imageView.startAnimation(animation);
            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }


                @Override
                public void onAnimationRepeat(Animation animation) {

                }
                @Override
                public void onAnimationEnd(Animation animation) {
                    Intent intent=new Intent(logActivity.this,MainActivity.class);
                    startActivity(intent);
                    logActivity.this.finish();
                    Log.e("---","-====");
                }

            });
        }
    }
}

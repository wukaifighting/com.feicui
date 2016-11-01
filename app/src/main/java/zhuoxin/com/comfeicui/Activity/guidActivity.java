package zhuoxin.com.comfeicui.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.ImageView;

import zhuoxin.com.comfeicui.R;
import zhuoxin.com.comfeicui.com.adapter.GuidAdapter;

/**
 * Created by Administrator on 2016/10/27.
 */

public class guidActivity extends Activity {
    ViewPager mVpg;
    //四个点的照片
    ImageView[] mImg;
    //滑动图片
    ImageView[] mRes;
    //图片ID设置
    int[] Mid = {R.drawable.welcome, R.drawable.wy, R.drawable.bd, R.drawable.small};
    int mPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载组件
        setContentView(R.layout.guid_main);
        //寻找照片
        mVpg = (ViewPager) findViewById(R.id.vpg_guid);
        //开始隐藏
        mImg = new ImageView[4];
        mRes = new ImageView[4];
        mImg[0] = (ImageView) findViewById(R.id.img_guid_0);
        mImg[1] = (ImageView) findViewById(R.id.img_guid_1);
        mImg[2] = (ImageView) findViewById(R.id.img_guid_2);
        mImg[3] = (ImageView) findViewById(R.id.img_guid_3);
        //设置刚开始都是隐藏的 熊第一位开始变成有颜色的
        mImg[0].setImageResource(R.drawable.adware_style_selected);
        //创建数据源
        for (int i = 0; i < 4; i++) {
            mRes[i] = new ImageView(this);
            mRes[i].setImageResource(Mid[i]);

            //适配器
            GuidAdapter guidAdapter = new GuidAdapter(mRes);
            mVpg.setAdapter(guidAdapter);
            //刷新适配器
            guidAdapter.notifyDataSetChanged();
            //监听事件
            mVpg.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    for (int i = 0; i < mImg.length; i++) {
                        mImg[i].setImageResource(R.drawable.adware_style_default);

                    }
                    mImg[position].setImageResource(R.drawable.adware_style_selected);
                    if (position==3){
                        Intent intent=new Intent(guidActivity.this,logActivity.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.anim_slide,R.anim.anim_logo);
                        guidActivity.this.finish();
                        Log.e("------","mposition"+position);
                    }
                }


                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });

        }

    }
}

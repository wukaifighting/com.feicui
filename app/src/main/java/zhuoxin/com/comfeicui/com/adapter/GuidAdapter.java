package zhuoxin.com.comfeicui.com.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/10/27.
 */

public class GuidAdapter extends PagerAdapter {
    //图片id
    ImageView[] mRes;

    public GuidAdapter(ImageView[] mRes) {
        this.mRes = mRes;
    }

    @Override
    public int getCount() {
        return mRes == null ? 0 : mRes.length
                ;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        //向 container中添加数据
        ImageView imageView = mRes[position];
        container.addView(imageView);
        return imageView;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //将看不见的移除
        container.removeView(mRes[position]);
    }
}

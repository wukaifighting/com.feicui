package zhuoxin.com.comfeicui.Activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import zhuoxin.com.comfeicui.R;

/**
 * Created by Administrator on 2016/11/14.
 */

public class ShowLocalPhotoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showlocalphoto);
        ImageView imageView= (ImageView) findViewById(R.id.img_showlocalphpto);
        Bitmap bitmap= this.getIntent().getParcelableExtra("img");
        imageView.setImageBitmap(bitmap);

    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
    }
}

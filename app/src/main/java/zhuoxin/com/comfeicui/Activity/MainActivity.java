package zhuoxin.com.comfeicui.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import zhuoxin.com.comfeicui.R;
import zhuoxin.com.comfeicui.com.adapter.LeftfragmentAdapter;

public class MainActivity extends AppCompatActivity {
    ListView mlst_left;

    public static final String PATH = "http://118.244.212.82:9092/newsClient/news_list?ver=1&subid=1&dir=1&nid=1&stamp=20140321&cnt=20";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initview();
        initadapter();
    }

    private void initview() {
        mlst_left = (ListView) findViewById(R.id.lst_left);



    }

    private void initadapter() {
        LeftfragmentAdapter leftadapter = new LeftfragmentAdapter(this);
        mlst_left.setAdapter(leftadapter);

    }


}

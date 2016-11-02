package zhuoxin.com.comfeicui.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import zhuoxin.com.comfeicui.R;
import zhuoxin.com.comfeicui.com.adapter.LeftfragmentAdapter;
import zhuoxin.com.comfeicui.fragments.CenterFragment;

public class MainActivity extends AppCompatActivity {
    ListView mlst_left;
    Button mBtn_left;
    Button mBtn_right;

    public static final String PATH = "http://118.244.212.82:9092/newsClient/news_list?ver=1&subid=1&dir=1&nid=1&stamp=20140321&cnt=20";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtn_left = (Button) findViewById(R.id.img_left);
        mBtn_right = (Button) findViewById(R.id.img_share);
        final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mBtn_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
                if (drawerLayout
                        .isDrawerOpen(Gravity.LEFT)) {
                    drawerLayout.closeDrawer(Gravity.LEFT);
                }

            }
        });
        mBtn_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.RIGHT);
                if (drawerLayout.isDrawerOpen(Gravity.RIGHT)) {
                    drawerLayout.closeDrawer(Gravity.RIGHT);
                }
            }
        });
        initview();
        initadapter();
        mlst_left.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        drawerLayout.closeDrawer(Gravity.LEFT);
                        drawerLayout.closeDrawer(Gravity.RIGHT);
                        CenterFragment centerFragment=new CenterFragment();
//                        FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();

                        break;

                }
            }
        });
    }

    private void initview() {
        mlst_left = (ListView) findViewById(R.id.lst_left);


    }

    private void initadapter() {
        LeftfragmentAdapter leftadapter = new LeftfragmentAdapter(this);
        mlst_left.setAdapter(leftadapter);

    }


}

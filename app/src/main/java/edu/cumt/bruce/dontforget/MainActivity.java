package edu.cumt.bruce.dontforget;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import edu.cumt.bruce.dontforget.DontForgetDatabaseHelper;

public class MainActivity extends AppCompatActivity {

    private LinearLayout linearLayout_home;
    private LinearLayout linearLayout_edit;
    private LinearLayout linearLayout_statistics;

    private Button btn_home;
    private Button btn_edit;
    private Button btn_statistics;

    private ViewPager viewPager;

    private MainContentAdapter adapter;

    private List<View> views;

    private DontForgetDatabaseHelper dontForgetDatabaseHelper;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.initView();
    }

    private  void initView(){

        this.linearLayout_home = (LinearLayout)findViewById(R.id.activity_main_linearlayout_bottom_1);
        this.linearLayout_edit = (LinearLayout)findViewById(R.id.activity_main_linearlayout_bottom_2);
        this.linearLayout_statistics = (LinearLayout)findViewById(R.id.activity_main_linearlayout_bottom_3);

        this.btn_home = (Button)findViewById(R.id.activity_main_linearlayout_bottom_1_button);
        this.btn_edit = (Button)findViewById(R.id.activity_main_linearlayout_bottom_2_button);
        this.btn_statistics = (Button)findViewById(R.id.activity_main_linearlayout_bottom_3_button);

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
            }
        });

        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });

        btn_statistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(2);
            }
        });

        this.viewPager = (ViewPager)findViewById(R.id.activity_main_viewpager);

        View page_home = View.inflate(MainActivity.this, R.layout.activity_main_page_home, null);
        View page_edit = View.inflate(MainActivity.this, R.layout.activity_main_page_edit, null);
        View page_statistics = View.inflate(MainActivity.this, R.layout.activity_main_page_statistics, null);
        views = new ArrayList<View>();

        views.add(page_home);
        views.add(page_edit);
        views.add(page_statistics);

        this.adapter = new MainContentAdapter(views);
        viewPager.setAdapter(adapter);
    }

    protected void initDatabase() {
        int versionNum = getResources().getInteger(R.integer.version);
        dontForgetDatabaseHelper = new DontForgetDatabaseHelper(this, getString(R.string.DontForgetDB), null, versionNum);
        dontForgetDatabaseHelper.getWritableDatabase();
    }

    protected void enterMainActivity() {
        Intent intent = new Intent();
    }


    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}

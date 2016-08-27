package com.fruit.baocms.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.fruit.baocms.BaseActivity;
import com.fruit.baocms.BaseFragmentActivity;
import com.fruit.baocms.R;
import com.fruit.baocms.adapter.MainPagerAdapter;
import com.fruit.baocms.widget.NoSlideViewPager;

public class MainActivity extends BaseFragmentActivity implements View.OnClickListener {

    private LinearLayout home_page, category_page, shopcart_page, self_page,
            more_page;
    private ImageView img_home, img_category, img_shopcart, img_self;
    private TextView txt_home, txt_category, txt_shopcart, txt_self;
    private NoSlideViewPager viewPager;
    private int CUR = 0;
    private MainPagerAdapter adapter;
    NotificationManager manager;
    private long time = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {

        home_page = ((LinearLayout) findViewById(R.id.home_page));
        category_page = ((LinearLayout) findViewById(R.id.category_page));
        shopcart_page = ((LinearLayout) findViewById(R.id.shopcart_page));
        self_page = ((LinearLayout) findViewById(R.id.self_page));

        home_page.setOnClickListener(this);
        category_page.setOnClickListener(this);
        self_page.setOnClickListener(this);
        shopcart_page.setOnClickListener(this);

        img_home = ((ImageView) findViewById(R.id.img_home));
        img_category = ((ImageView) findViewById(R.id.img_category));
        img_shopcart = ((ImageView) findViewById(R.id.img_shopcart));
        img_self = ((ImageView) findViewById(R.id.img_self));

        txt_home = ((TextView) findViewById(R.id.txt_home));
        txt_category = ((TextView) findViewById(R.id.txt_category));
        txt_shopcart = ((TextView) findViewById(R.id.txt_shopcart));
        txt_self = ((TextView) findViewById(R.id.txt_self));

        viewPager = ((NoSlideViewPager) findViewById(R.id.viewPager));

        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        adapter = new MainPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(3);
        viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            public void onPageSelected(int num) {
                show(num);
            }
        });
        viewPager.setCurrentItem(CUR);
        show(CUR);
    }

    private void show(int position) {
        img_home.setImageResource(position == 0 ? R.mipmap.icon_home_press
                : R.mipmap.icon_home);
        txt_home.setTextColor(getResources().getColor(
                position == 0 ? R.color.theme_color : R.color.second_txt_color));
        img_category.setImageResource(position == 1 ? R.mipmap.icon_alarm_press
                : R.mipmap.icon_alarm);
        txt_category.setTextColor(getResources().getColor(
                position == 1 ? R.color.theme_color : R.color.second_txt_color));
        img_shopcart.setImageResource(position == 2 ? R.mipmap.icon_shopping_press
                : R.mipmap.icon_shopping);
        txt_shopcart.setTextColor(getResources().getColor(
                position == 2 ? R.color.theme_color : R.color.second_txt_color));
        img_self.setImageResource(position == 3 ? R.mipmap.icon_mine_press
                : R.mipmap.icon_mine);
        txt_self.setTextColor(getResources().getColor(
                position == 3 ? R.color.theme_color : R.color.second_txt_color));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_page:
                this.CUR = 0;
                this.viewPager.setCurrentItem(0);
                break;
            case R.id.category_page:
                this.CUR = 1;
                this.viewPager.setCurrentItem(1);
                break;
            case R.id.shopcart_page:
//                if(UserInfos.getInstance().isExist()){
//                    this.CUR = 2;
//                    viewPager.setCurrentItem(2);
//                }else{
//                    Intent i = new Intent();
//                    i.setClass(this,LoginActivity.class);
//                    startActivity(i);
//                }
                    this.CUR = 2;
                    viewPager.setCurrentItem(2);
                break;
            case R.id.self_page:
                CUR = 3;
                viewPager.setCurrentItem(3);
                break;
            default:
                break;
        }
    }


    @Override
    public void onBackPressed() {
        long temp = System.currentTimeMillis();
        if (time == 0 || temp - time > 2000) {
            time = temp;
            Toast.makeText(this, getString(R.string.exit), Toast.LENGTH_LONG).show();
        }
    }
}

package com.fruit.baocms.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.fruit.baocms.BaseActivity;
import com.fruit.baocms.R;
import com.fruit.baocms.adapter.AreaAdapter;
import com.fruit.baocms.adapter.CityAdapter;
import com.fruit.baocms.adapter.RouteAdapter;
import com.fruit.baocms.widget.CycleViewPager;

/**
 * Created by Administrator on 2016/8/26.
 */
public class LocationActivity extends BaseActivity implements View.OnClickListener {

    private ImageView mBackIv;
    private TextView mTitleTv;
    private CycleViewPager cycleViewPager;
    private GridView mCityGv;
    private ListView mAreaLv,mRouteLv;

    CityAdapter cityAdapter;
    AreaAdapter areaAdapter;
    RouteAdapter routeAdapter;
   String[] infos = new String[]{"平顶山"};
    String[] area = new String[]{"平顶山","平顶山","平顶山","平顶山","平顶山","平顶山"};
    String[] route = new String[]{"线上00","线上00","线上00","线上00","线上00","线上00"};
    String[] route1 = new String[]{"线上01","线上01","线上01","线上01","线上01","线上01"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        initView();
    }

    private void initView() {

        mBackIv = (ImageView) findViewById(R.id.title_back);
        mTitleTv = (TextView) findViewById(R.id.title_name);
        cycleViewPager = (CycleViewPager) getFragmentManager()
                .findFragmentById(R.id.home_fragment_cycle_viewpager);
        mCityGv = (GridView) findViewById(R.id.city_gv);
        mAreaLv = (ListView) findViewById(R.id.area_lv);
        mRouteLv = (ListView) findViewById(R.id.route_lv);

        cityAdapter = new CityAdapter(this);
        cityAdapter.setInfos(infos);
        mCityGv.setAdapter(cityAdapter);

        areaAdapter = new AreaAdapter(this);
        areaAdapter.setInfos(area);
        mAreaLv.setAdapter(areaAdapter);


        routeAdapter = new RouteAdapter(this);
        routeAdapter.setInfos(route);
        mRouteLv.setAdapter(routeAdapter);


        mTitleTv.setText("选择城市");
        mBackIv.setOnClickListener(this);

        mAreaLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                areaAdapter.curPosition = i;
                areaAdapter.notifyDataSetChanged();
                routeAdapter.setInfos(route1);
                routeAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onClick(View view) {




    }
}

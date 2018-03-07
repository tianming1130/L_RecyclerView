package com.sun.l_recyclerview;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private RecyclerView recyclerView;
    private List<Map<String,Object>> mDataList;
    private SwipeRefreshLayout mRefreshLayout;
    private  MenuListAdapter mAdapter;
    private LinearLayoutManager mLinearLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView) findViewById(R.id.menu_list);
        mRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.layout_swipe_refresh);
        mLinearLayoutManager=new LinearLayoutManager(this);
        initData();

        recyclerView.setLayoutManager(mLinearLayoutManager);
        //recyclerView.setItemAnimator(new DefaultItemAnimator());
        //recyclerView.addItemDecoration(new MenuItemDecoration(this));
        //recyclerView.addItemDecoration(new MyItemDecoration(this, 3, 0xffFF0000));
        recyclerView.addItemDecoration(new MenuItemDecoration());
        //recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        mAdapter=new MenuListAdapter(this,mDataList);
        recyclerView.setAdapter(mAdapter);

        mRefreshLayout.setOnRefreshListener(this);

        recyclerView.addOnScrollListener(new MyOnScrollListener() {
            @Override
            public void loadMore() {
                Map<String, Object> map = new HashMap<>();
                map.put("menu_thumb", R.mipmap.ic_launcher);
                map.put("menu_title", "ssss");
                map.put("menu_info", "ssss");
                mDataList.add(map);
                mAdapter.notifyDataSetChanged();
            }
        });
    }

    private void simulateLoadMoreData() {
        Map<String, Object> map = new HashMap<>();
        map.put("menu_thumb", R.mipmap.ic_launcher);
        map.put("menu_title", "ssss");
        map.put("menu_info", "ssss");
        mDataList.add(map);
        //数据重新加载完成后，提示数据发生改变，并且设置现在不在刷新
        mAdapter.notifyDataSetChanged();
    }

    private void initData() {
        mDataList=new ArrayList<>();
        int[] image = {R.drawable.gongbaojiding, R.drawable.shuizhuroupian,
                R.drawable.xihucuyu, R.drawable.yuxiangrousi,
                R.drawable.suanlajidantang};
        String[] title = {"宫保鸡丁", "水煮肉片", "西湖醋鱼", "鱼香肉丝", "酸辣鸡蛋汤"};
        String[] content = {
                "宫保鸡丁，是一道闻名中外的特色传统名菜。鲁菜、川菜、贵州菜中都有收录，原料、做法有差别。该菜式的起源与鲁菜中的酱爆鸡丁，和贵州菜的胡辣子鸡丁有关，后被清朝山东巡抚、四川总督丁宝桢改良发扬，形成了一道新菜式——宫保鸡丁，并流传至今，此道菜也被归纳为北京宫廷菜。之后宫保鸡丁也流传到国外。",
                "水煮肉片是一道地方新创名菜，起源于自贡，发扬于西南，属于川菜中著名的家常菜。其起源于上世纪30年代， 自贡名厨范吉安(1887 -1982年)" +
                        "，创新出风味突出的水煮肉片。因肉片未经划油，以水煮熟故名水煮肉片。",
                "西湖醋鱼别名为叔嫂传珍，宋嫂鱼，是浙江杭州饭店的一道传统地方风味名菜。",
                "鱼香肉丝（英文名：Stir-fried Pork Strips in Fish " +
                        "Sauce）是一道特色传统名菜，以鱼香调味而得名，属川菜。相传灵感来自老菜泡椒肉丝，民国年间由四川籍厨师创制而成。",
                "酸辣鸡蛋汤是一款简单的汤类美食，主要原料有猪肉50克、胡萝卜、竹笋各50克等。逢年过节，或寒冬腊月，煮上一锅热腾腾的酸辣鸡蛋汤，暖身提神，回味无穷"};

        mDataList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("menu_thumb", image[i]);
            map.put("menu_title", title[i]);
            map.put("menu_info", content[i]);
            mDataList.add(map);
            mDataList.add(map);
        }
    }

    @Override
    public void onRefresh() {
        //在List最前面加入一条数据
        Map<String, Object> map = new HashMap<>();
        map.put("menu_thumb", R.mipmap.ic_launcher);
        map.put("menu_title", "aa");
        map.put("menu_info", "bb");
        mDataList.add(0,map);
        //数据重新加载完成后，提示数据发生改变，并且设置现在不在刷新
        mAdapter.notifyDataSetChanged();
        mRefreshLayout.setRefreshing(false);

    }
}

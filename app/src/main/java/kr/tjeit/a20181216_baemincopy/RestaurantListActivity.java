package kr.tjeit.a20181216_baemincopy;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import kr.tjeit.a20181216_baemincopy.adapters.RestaurantAdapter;
import kr.tjeit.a20181216_baemincopy.datas.Restaurant;

public class RestaurantListActivity extends BaseActivity {

    RestaurantAdapter mAdapter;
    List<Restaurant> restaurants = new ArrayList<Restaurant>();
    String foodKind;
    private android.widget.ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_list);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {
        foodKind = getIntent().getStringExtra("음식종류");

        setTitle(String.format("%s 배달 가능 식당 목록", foodKind));

        fillRestaurants();

        mAdapter = new RestaurantAdapter(mContext, restaurants);
        listView.setAdapter(mAdapter);
    }

    private void fillRestaurants() {
        restaurants.clear();

        restaurants.add(new Restaurant("도미노피자", "광진구", "09:00 ~ 22:00"));
        restaurants.add(new Restaurant("미스터피자", "관악구", "14:00 ~ 24:00"));
        restaurants.add(new Restaurant("피자헛", "강동구", "12:00 ~ 23:00"));
        restaurants.add(new Restaurant("파파존스", "성북구", "10:00 ~ 21:00"));
    }

    @Override
    public void bindViews() {
        this.listView = (ListView) findViewById(R.id.listView);
    }
}

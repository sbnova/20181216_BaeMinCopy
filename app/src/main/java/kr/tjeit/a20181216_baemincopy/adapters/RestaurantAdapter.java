package kr.tjeit.a20181216_baemincopy.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import kr.tjeit.a20181216_baemincopy.R;
import kr.tjeit.a20181216_baemincopy.datas.Restaurant;

public class RestaurantAdapter extends ArrayAdapter<Restaurant> {

    Context mContext;
    List<Restaurant> mList;
    LayoutInflater inf;

    public RestaurantAdapter(Context mContext, List<Restaurant> mList){
        super(mContext, R.layout.restaurant_list_item, mList);
        this.mContext = mContext;
        this.mList = mList;
        this.inf = LayoutInflater.from(mContext);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if(row == null){
            row = inf.inflate(R.layout.restaurant_list_item, null);
        }

        TextView nameTxt = row.findViewById(R.id.nameTxt);
        TextView addressTxt = row.findViewById(R.id.addressTxt);
        TextView openTimeTxt = row.findViewById(R.id.openTimeTxt);

        Restaurant data = mList.get(position);

        nameTxt.setText(data.getName());
        addressTxt.setText(data.getAddress());
        openTimeTxt.setText(data.getOpenTime());

        return row;
    }
}

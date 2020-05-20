package com.mervesahin.project1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xwray.groupie.GroupieViewHolder;
import com.xwray.groupie.Item;

import java.util.ArrayList;

public class CityAdapter extends Item<GroupieViewHolder> {
    public City city;
    public Context mContext;

    public CityAdapter(Context mContext, City city) {
        this.mContext = mContext;
        this.city = city;
    }

    @Override
    public void bind(@NonNull GroupieViewHolder viewHolder, int position) {
        View view = viewHolder.itemView;

        TextView txtSehirlerAd = view.findViewById(R.id.txtSehirlerAd);
        txtSehirlerAd.setText(city.getCity_name());
    }

    @Override
    public int getLayout() {
        return R.layout.sehirler_card_tasarim;
    }
}

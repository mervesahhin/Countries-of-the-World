package com.mervesahin.project1.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.mervesahin.project1.model.TurkeyCity;
import com.mervesahin.project1.R;
import com.xwray.groupie.GroupieViewHolder;
import com.xwray.groupie.Item;

public class TurkeyCityAdapter extends Item<GroupieViewHolder> {
    public TurkeyCity city;
    public Context mContext;

    public TurkeyCityAdapter(Context mContext, TurkeyCity city) {
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

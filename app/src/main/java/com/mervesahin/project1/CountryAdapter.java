package com.mervesahin.project1;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.xwray.groupie.GroupieViewHolder;
import com.xwray.groupie.Item;

public class CountryAdapter  extends Item<GroupieViewHolder> {
    public Country country;
    public Context mContext;

    public CountryAdapter(Context mContext, Country country) {
        this.mContext = mContext;
        this.country = country;
    }

    @Override
    public void bind(@NonNull GroupieViewHolder viewHolder, int position) {
        View view = viewHolder.itemView;

        TextView txtCountryName = view.findViewById(R.id.txtCountryName);
        txtCountryName.setText(country.getCountry_name());

        ImageView countryImage = view.findViewById(R.id.countryImage);
        Glide.with(mContext).load("http://goo.gl/gEgYUd").into(countryImage);


    }

    @Override
    public int getLayout() {
        return R.layout.country_card_design;
    }
}

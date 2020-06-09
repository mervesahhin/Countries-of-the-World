package com.mervesahin.project1.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.mervesahin.project1.model.Country;
import com.mervesahin.project1.R;
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
        Glide.with(mContext).load(country.getCountry_image()).into(countryImage);




    }

    @Override
    public int getLayout() {
        return R.layout.country_card_design;
    }
}

package com.mervesahin.project1.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.mervesahin.project1.model.CountryCities;
import com.mervesahin.project1.R;
import com.xwray.groupie.GroupieViewHolder;
import com.xwray.groupie.Item;

public class CountryCitiesDetailAdapter extends Item<GroupieViewHolder> {
    public CountryCities countryCities;
    public Context mContext;

    public CountryCitiesDetailAdapter(Context mContext, CountryCities countryCities) {
        this.mContext = mContext;
        this.countryCities = countryCities;
    }

    @Override
    public void bind(@NonNull GroupieViewHolder viewHolder, int position) {
        View view = viewHolder.itemView;

        TextView txtCountryCitiesName = view.findViewById(R.id.txtCountryCitiesName);
        txtCountryCitiesName.setText(countryCities.getCountrycities_name());

        TextView txtCountryCitiesInfo = view.findViewById(R.id.txtCountryCitiesInfo);
        txtCountryCitiesInfo.setText(countryCities.getCountrycities_info());

        ImageView countrycitiesImage = view.findViewById(R.id.countrycitiesImage);
        Glide.with(mContext).load(countryCities.getCountrycities_image()).into(countrycitiesImage);

    }

    @Override
    public int getLayout() {
        return R.layout.country_cities_card_design;
    }
}

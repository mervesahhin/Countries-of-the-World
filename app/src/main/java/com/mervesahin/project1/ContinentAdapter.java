package com.mervesahin.project1;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.xwray.groupie.GroupieViewHolder;
import com.xwray.groupie.Item;

public class ContinentAdapter extends Item<GroupieViewHolder> {
    public Continent continent;
    public Context mContext;

    public ContinentAdapter(Context mContext, Continent continent) {
        this.mContext = mContext;
        this.continent = continent;
    }

    @Override
    public void bind(@NonNull GroupieViewHolder viewHolder, int position) {
        View view = viewHolder.itemView;

        TextView txtcontinentnames = view.findViewById(R.id.txtcontinentnames);
        txtcontinentnames.setText(continent.getContinent_name());

        ImageView continentImage = view.findViewById(R.id.continentImage);
        Glide.with(mContext).load("http://goo.gl/gEgYUd").into(continentImage);


    }

    @Override
    public int getLayout() {
        return  R.layout.continent_card_design;
    }
}

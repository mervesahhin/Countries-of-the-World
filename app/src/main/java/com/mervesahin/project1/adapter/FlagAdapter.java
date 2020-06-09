package com.mervesahin.project1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mervesahin.project1.model.Flag;
import com.mervesahin.project1.ui.FlagsInfoActivity;
import com.mervesahin.project1.R;

import java.util.List;

public class FlagAdapter extends RecyclerView.Adapter<FlagAdapter.CardViewTasarımNesneleriniTutucu> {
    private FlagsInfoActivity mContext;
    private List<Flag> flagList;

    public FlagAdapter(FlagsInfoActivity mContext, List<Flag> flagList) {
        this.mContext = mContext;
        this.flagList = flagList;
    }

    @NonNull
    @Override
    public CardViewTasarımNesneleriniTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_bayrak_tasarim,parent,false);
        return new CardViewTasarımNesneleriniTutucu(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewTasarımNesneleriniTutucu holder, int position) {
        Flag bayrak= flagList.get(position);
        holder.txtUlkeAdi.setText(bayrak.getBayrak_adi());
        holder.imageBayrakResim.setImageResource(mContext.getResources()
                .getIdentifier(bayrak.getBayrak_resim(),"drawable",mContext.getPackageName()));

    }

    @Override
    public int getItemCount() {
        return flagList.size();
    }

    public class CardViewTasarımNesneleriniTutucu extends RecyclerView.ViewHolder{
        public ImageView imageBayrakResim;
        public TextView txtUlkeAdi;

        public CardViewTasarımNesneleriniTutucu(@NonNull View itemView) {
            super(itemView);
            imageBayrakResim=itemView.findViewById(R.id.imageBayrakResim);
            txtUlkeAdi=itemView.findViewById(R.id.txtUlkeAdi);
        }
    }
}
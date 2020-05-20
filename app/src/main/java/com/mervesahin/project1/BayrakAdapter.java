package com.mervesahin.project1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BayrakAdapter extends RecyclerView.Adapter<BayrakAdapter.CardViewTasarımNesneleriniTutucu> {
    private BayraklariTaniActivity mContext;
    private List<Bayraklar> bayraklarList;

    public BayrakAdapter(BayraklariTaniActivity mContext, List<Bayraklar> bayraklarList) {
        this.mContext = mContext;
        this.bayraklarList = bayraklarList;
    }

    @NonNull
    @Override
    public CardViewTasarımNesneleriniTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_bayrak_tasarim,parent,false);
        return new CardViewTasarımNesneleriniTutucu(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewTasarımNesneleriniTutucu holder, int position) {
        Bayraklar bayrak=bayraklarList.get(position);
        holder.txtUlkeAdi.setText(bayrak.getBayrak_adi());
        holder.imageBayrakResim.setImageResource(mContext.getResources()
                .getIdentifier(bayrak.getBayrak_resim(),"drawable",mContext.getPackageName()));

    }

    @Override
    public int getItemCount() {
        return bayraklarList.size();
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
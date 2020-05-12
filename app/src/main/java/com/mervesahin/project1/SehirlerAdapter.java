package com.mervesahin.project1;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SehirlerAdapter extends RecyclerView.Adapter<SehirlerAdapter.CardViewTasarimNesneleriniTutucu2> {
    private Context mContext2;
    private List<City> cityListe;
    private String logTAG = "SehirlerLog";

    public SehirlerAdapter(Context mContext2, List<City> cityListe) {
        Log.d(logTAG,"5");
        this.mContext2 = mContext2;
        this.cityListe = cityListe;
    }

    public class CardViewTasarimNesneleriniTutucu2 extends RecyclerView.ViewHolder {
        private TextView txtSehirlerAd;
        public CardView satirCardView;
        private ImageView imageOk;

        public CardViewTasarimNesneleriniTutucu2(View view) {
            super(view);
            txtSehirlerAd = view.findViewById(R.id.txtSehirlerAd);
            satirCardView = view.findViewById(R.id.satirCardView);
            imageOk = view.findViewById(R.id.imageOk);
        }
    }

    //Görsel Nesnelerin Tasarim Üzerinde Görünmesi
    @NonNull
    @Override
    public CardViewTasarimNesneleriniTutucu2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(logTAG,"1");
        View itemView2 = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sehirler_card_tasarim, parent, false);
        return new CardViewTasarimNesneleriniTutucu2(itemView2);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewTasarimNesneleriniTutucu2 holder, int position) {
        final City city = cityListe.get(position);

        Log.d(logTAG,"2");

        holder.txtSehirlerAd.setText(city.getCity_name());
        holder.imageOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext2, SehirlerDetay.class);
                //intent.putExtra("nesne", String.valueOf(sehirler));
                mContext2.startActivity(intent);
            }
        });
    }

    //burada belirtilen sayı kadar onBindViewHolder çalışır
    @Override
    public int getItemCount() {
        Log.d(logTAG, "Size : " + cityListe.size());
        return cityListe.size();
    }
}


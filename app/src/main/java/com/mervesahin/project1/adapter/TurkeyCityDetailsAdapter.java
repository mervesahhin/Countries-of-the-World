package com.mervesahin.project1.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.mervesahin.project1.model.TurkeyCitiesDetail;
import com.mervesahin.project1.R;
import com.xwray.groupie.GroupieViewHolder;
import com.xwray.groupie.Item;

public class TurkeyCityDetailsAdapter extends Item<GroupieViewHolder> {
    public TurkeyCitiesDetail details;
    public Context mContext;

    public TurkeyCityDetailsAdapter(Context mContext, TurkeyCitiesDetail details) {
        this.mContext = mContext;
        this.details = details;
    }

    @Override
    public void bind(@NonNull GroupieViewHolder viewHolder, int position) {
        View view = viewHolder.itemView;

        TextView txtsehirdetay = view.findViewById(R.id.txtsehirdetay);
        txtsehirdetay.setText(details.getDetails_name());

        TextView txtsehirdetaybilgi = view.findViewById(R.id.txtsehirdetaybilgi);
        txtsehirdetaybilgi.setText(details.getDetails_detail());

        ImageView imagesehirdetay = view.findViewById(R.id.imagesehirdetay);
        Glide.with(mContext).load(details.getDetails_image()).into(imagesehirdetay);



    }

    @Override
    public int getLayout() {
        return R.layout.sehirlerdetay_card_tasarim;
    }
}























/*
public class detaylarAdapter extends RecyclerView.Adapter<detaylarAdapter.CardViewTasarimNesneleriniTutucu2> {
    private Context mContext2;
    private List<Detaylar> detaylarList;

    public detaylarAdapter(Context mContext2, List<Detaylar> detaylarList) {
        this.mContext2 = mContext2;
        this.detaylarList = detaylarList;
    }

    public class CardViewTasarimNesneleriniTutucu2 extends RecyclerView.ViewHolder {
        private TextView txtsehirdetay;
        private TextView txtsehirdetaybilgi;
        private ImageView imagesehirdetay;
        private CardView sehirdetay;


        public CardViewTasarimNesneleriniTutucu2(View view) {
            super(view);
            txtsehirdetay = view.findViewById(R.id.txtsehirdetay);
            txtsehirdetaybilgi = view.findViewById(R.id.txtsehirdetaybilgi);
            imagesehirdetay = view.findViewById(R.id.imagesehirdetay);
            sehirdetay=view.findViewById(R.id.sehirdetay);
        }

    }

    //Görsel Nesnelerin Tasarim Üzerinde Görünmesi
    @NonNull
    @Override
    public CardViewTasarimNesneleriniTutucu2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView2 = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sehirlerdetay_card_tasarim, parent, false);
        return new CardViewTasarimNesneleriniTutucu2(itemView2);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewTasarimNesneleriniTutucu2 holder, int position) {
        final Detaylar detaylar=detaylarList.get(position);

        holder.txtsehirdetay.setText(detaylar.getDetay_adi());
        holder.txtsehirdetaybilgi.setText(detaylar.getDetay_bilgi());
        holder.imagesehirdetay.setImageResource(mContext2.getResources()
                .getIdentifier(detaylar.getDetay_resim(),"drawable",mContext2.getPackageName()));

    }

    //burada belirtilen sayı kadar onBindViewHolder çalışır
    @Override
    public int getItemCount() {
        return detaylarList.size();
    }
}*/





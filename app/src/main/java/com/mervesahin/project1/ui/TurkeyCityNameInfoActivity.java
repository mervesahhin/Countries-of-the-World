package com.mervesahin.project1.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.mervesahin.project1.model.TurkeyCity;
import com.mervesahin.project1.R;
import com.mervesahin.project1.adapter.TurkeyCityAdapter;
import com.xwray.groupie.GroupAdapter;
import com.xwray.groupie.GroupieViewHolder;
import com.xwray.groupie.Item;
import com.xwray.groupie.OnItemClickListener;

import java.util.ArrayList;

public class TurkeyCityNameInfoActivity extends AppCompatActivity {

    FirebaseFirestore db;
    private RecyclerView rv2;
    private ArrayList<TurkeyCity> cityArrayList = new ArrayList<TurkeyCity>();
    private Context mContext;

    GroupAdapter adapter = new GroupAdapter<GroupieViewHolder>();
    private String logTAG = "TurkiyeTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turkey_cityname);

        db = FirebaseFirestore.getInstance();
        mContext = getApplicationContext();

        rv2 = findViewById(R.id.rv2);
        rv2.setHasFixedSize(true);
        rv2.setAdapter(adapter);

        fetchCities();

        //Item Click Olayı
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull Item item, @NonNull View view) {
                //Burada kolayca diğer Activity'lere gönderme yapılabilir
                TurkeyCityAdapter cityAdapter = (TurkeyCityAdapter) item;

                 Intent intent=new Intent(TurkeyCityNameInfoActivity.this, TurkeyCityDetailsActivity.class);
                 intent.putExtra("cityName",cityAdapter.city.getCity_name());
                 intent.putExtra("cityID",cityAdapter.city.getCity_id());
                 startActivity(intent);
            }
        });
    }

    private void fetchCities() {
        db.collection("cities")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        for (DocumentSnapshot doc : task.getResult()) {
                            String city_id = doc.getString("city_id");
                            String city_name = doc.getString("city_name");

                            TurkeyCity city = new TurkeyCity(city_id, city_name);
                            adapter.add(new TurkeyCityAdapter(mContext, city));

                            Log.d(logTAG, city_id + " " + city_name);
                        }
                        adapter.notifyDataSetChanged();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d(logTAG, e.getMessage().toString());
                    }
                });
    }
}




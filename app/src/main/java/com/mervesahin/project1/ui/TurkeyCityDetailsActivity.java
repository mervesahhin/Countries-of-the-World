package com.mervesahin.project1.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.mervesahin.project1.R;
import com.mervesahin.project1.adapter.TurkeyCityDetailsAdapter;
import com.mervesahin.project1.model.TurkeyCity;
import com.mervesahin.project1.model.TurkeyCitiesDetail;
import com.xwray.groupie.GroupAdapter;
import com.xwray.groupie.GroupieViewHolder;

import java.util.ArrayList;

public class TurkeyCityDetailsActivity extends AppCompatActivity {
    FirebaseFirestore db;
    private RecyclerView sehirdetayRv;
    private Context mContext;
    private ArrayList<TurkeyCitiesDetail> detaylarArrayList= new ArrayList<>();

    GroupAdapter adapter = new GroupAdapter<GroupieViewHolder>();
    private TurkeyCity city;

    private String logTAG = "DetayTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turkey_citydetail);

        mContext = getApplicationContext();

        city=new TurkeyCity();

        Intent intent=getIntent();
        city.setCity_id(intent.getStringExtra("cityID"));
        city.setCity_name(intent.getStringExtra("cityName"));

        db = FirebaseFirestore.getInstance();
        mContext = getApplicationContext();
        sehirdetayRv=findViewById(R.id.sehirdetayRv);

        sehirdetayRv.setHasFixedSize(true);
        sehirdetayRv.setLayoutManager(new LinearLayoutManager(this));

        sehirdetayRv.setAdapter(adapter);

        fetchCities();
    }

    private void fetchCities() {
        String db_path="details/"+city.getCity_id()+"/"+city.getCity_id();
        db.collection(db_path)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        for (DocumentSnapshot doc : task.getResult()) {
                            String details_id = doc.getString("details_id");
                            String details_name = doc.getString("details_name");
                            String details_image = doc.getString("details_image");
                            String details_detail= doc.getString("details_detail");

                            TurkeyCitiesDetail detail = new TurkeyCitiesDetail(details_id, details_name,details_detail,details_image);
                            adapter.add(new TurkeyCityDetailsAdapter(mContext, detail));

                            Log.d(logTAG, details_id + " " + details_name);
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

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
import com.mervesahin.project1.model.Continent;
import com.mervesahin.project1.model.Country;
import com.mervesahin.project1.model.CountryCities;
import com.mervesahin.project1.R;
import com.mervesahin.project1.adapter.CountryCitiesDetailAdapter;
import com.xwray.groupie.GroupAdapter;
import com.xwray.groupie.GroupieViewHolder;

import java.util.ArrayList;

public class CountryCityDetailActivity extends AppCompatActivity {

    FirebaseFirestore db;
    private RecyclerView countrycitiesRV;
    private Context mContext;
    private ArrayList<CountryCities> countryCitiesArrayList = new ArrayList<>();

    GroupAdapter adapter = new GroupAdapter<GroupieViewHolder>();
    private Country country;


    private CountryCities countryCities;
    private Continent continent;



    private String logTAG = "CountryCitiesDetailsTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_cities2);

        mContext = getApplicationContext();
        countryCities=new CountryCities();
        continent=new Continent();


        country=new Country();
        Intent intent=getIntent();
        country.setCountry_id(intent.getStringExtra("countryID"));
        country.setCountry_name(intent.getStringExtra("countryName"));
        country.setCountry_image(intent.getStringExtra("countryImage"));
        continent.setContinent_id(intent.getStringExtra("continentID"));

        Log.d(logTAG,country.getCountry_id()+continent.getContinent_id());

        db = FirebaseFirestore.getInstance();
        mContext = getApplicationContext();
        countrycitiesRV=findViewById(R.id.countrycitiesRV);

        countrycitiesRV.setHasFixedSize(true);
        countrycitiesRV.setLayoutManager(new LinearLayoutManager(this));

        countrycitiesRV.setAdapter(adapter);
        fetchCountryCities();
    }

    private void fetchCountryCities() {
        Log.d(logTAG,"Fetching Started");

        String db_path="countrycities/"+continent.getContinent_id()+"/"+continent.getContinent_id()+"/"+country.getCountry_id()+"/"+country.getCountry_id();
        db.collection(db_path)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        Log.d(logTAG,"Fetch Info...");


                        for (DocumentSnapshot doc : task.getResult()) {
                            String countrycities_id = doc.getString("countrycities_id");
                            String countrycities_name = doc.getString("countrycities_name");
                            String countrycities_image = doc.getString("countrycities_image");
                            String countrycities_info = doc.getString("countrycities_info");

                            CountryCities countryCities = new CountryCities(countrycities_id, countrycities_name,countrycities_image,countrycities_info);
                            adapter.add(new CountryCitiesDetailAdapter(mContext, countryCities));

                            Log.d(logTAG, countrycities_id + " " + countrycities_name);
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

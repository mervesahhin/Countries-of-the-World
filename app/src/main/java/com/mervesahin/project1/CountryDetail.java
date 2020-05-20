package com.mervesahin.project1;

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
import com.xwray.groupie.GroupAdapter;
import com.xwray.groupie.GroupieViewHolder;

import java.util.ArrayList;

public class CountryDetail extends AppCompatActivity {

    FirebaseFirestore db;
    private RecyclerView countrydetailRv;
    private Context mContext;
    private ArrayList<Country> countryArrayList= new ArrayList<>();

    GroupAdapter adapter = new GroupAdapter<GroupieViewHolder>();
    private Continent continent;

    private String logTAG = "DetayTag";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_detail);

        mContext = getApplicationContext();

        continent=new Continent();

        Intent intent=getIntent();
        continent.setContinent_id(intent.getStringExtra("continentID"));
        continent.setContinent_name(intent.getStringExtra("continentName"));
        continent.setContinent_image(intent.getStringExtra("continentImage"));

        db = FirebaseFirestore.getInstance();
        mContext = getApplicationContext();
        countrydetailRv=findViewById(R.id.countrydetailRv);

        countrydetailRv.setHasFixedSize(true);
        countrydetailRv.setLayoutManager(new LinearLayoutManager(this));

        countrydetailRv.setAdapter(adapter);

        fetchContinent();
    }

    private void fetchContinent() {
        String db_path="country/"+continent.getContinent_id()+"/"+continent.getContinent_id();
        db.collection(db_path)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        for (DocumentSnapshot doc : task.getResult()) {
                            String country_id = doc.getString("country_id");
                            String country_name = doc.getString("country_name");
                            String country_image = doc.getString("country_image");

                            Country country = new Country(country_id, country_name,country_image);
                            adapter.add(new CountryAdapter(mContext, country));

                            Log.d(logTAG, country_id + " " + country_name);
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

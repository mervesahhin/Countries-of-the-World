package com.mervesahin.project1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.xwray.groupie.GroupAdapter;

import java.util.ArrayList;

public class TurkiyeyiTaniActivity extends AppCompatActivity {

    FirebaseFirestore db;
    private RecyclerView rv2;
    private SehirlerAdapter adapter;
    private ArrayList<City> cityArrayList=new ArrayList<City>();
    private Context mContext;


    private String logTAG="TurkiyeTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turkiyeyi_tani);

        db=FirebaseFirestore.getInstance();
        rv2=findViewById(R.id.rv2);
        rv2.setHasFixedSize(true);

        Log.d(logTAG,"Working");
        mContext=getApplicationContext();
        adapter= new SehirlerAdapter(mContext,cityArrayList);

        rv2.setAdapter(adapter);



        fetchCities();
    }

    private void fetchCities() {
        Log.d(logTAG,"Working");

        db.collection("cities")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        Log.d(logTAG,"3");

                        for(DocumentSnapshot doc:task.getResult()){
                            String city_id=doc.getString("city_id");
                            String city_name=doc.getString("city_name");

                            cityArrayList.add(new City(city_id,city_name));

                            Log.d(logTAG,city_id+" "+city_name);
                        }
                        adapter.notifyDataSetChanged();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d(logTAG,e.getMessage().toString());
                    }
                });
    }
}


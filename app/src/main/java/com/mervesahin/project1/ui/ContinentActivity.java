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
import com.mervesahin.project1.model.Continent;
import com.mervesahin.project1.R;
import com.mervesahin.project1.adapter.ContinentAdapter;
import com.xwray.groupie.GroupAdapter;
import com.xwray.groupie.GroupieViewHolder;
import com.xwray.groupie.Item;
import com.xwray.groupie.OnItemClickListener;

import java.util.ArrayList;

public class ContinentActivity extends AppCompatActivity {

    FirebaseFirestore db;
    private RecyclerView rv3;
    private ArrayList<Continent> continentArrayList = new ArrayList<Continent>();
    private Context mContext;

    GroupAdapter adapter = new GroupAdapter<GroupieViewHolder>();

    private String logTAG = "KıtalarTag";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ulkeleri_tani);

        db = FirebaseFirestore.getInstance();

        rv3 = findViewById(R.id.rv3);
        rv3.setHasFixedSize(true);

        mContext = getApplicationContext();

        rv3.setAdapter(adapter);

        fetchContinent();

        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull Item item, @NonNull View view) {
                //Burada kolayca diğer Activity'lere gönderme yapılabilir
                ContinentAdapter continentAdapter = (ContinentAdapter) item;

                Intent intent=new Intent(ContinentActivity.this, CountryNameActivity.class);
                intent.putExtra("continentID",continentAdapter.continent.getContinent_id());
                intent.putExtra("continentName",continentAdapter.continent.getContinent_name());
                intent.putExtra("continentImage",continentAdapter.continent.getContinent_image());
                startActivity(intent);
            }
        });
    }


    private void fetchContinent() {
        db.collection("continent")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        for (DocumentSnapshot doc : task.getResult()) {
                            String continent_id = doc.getString("continent_id");
                            String continent_name = doc.getString("continent_name");
                            String continent_image = doc.getString("continent_image");

                            Continent continent = new Continent(continent_id, continent_name,continent_image);
                            adapter.add(new ContinentAdapter(mContext, continent));

                            Log.d(logTAG, continent_id + " " + continent_name);
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

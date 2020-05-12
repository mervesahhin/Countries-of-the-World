package com.mervesahin.project1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class SehirlerDetay extends AppCompatActivity {
    private RecyclerView sehirdetayRv;
    private detaylarAdapter adapter;
    private ArrayList<Detaylar> detaylarArrayList;

    private City city;
    //private StorageReference mStorageRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sehirler_detay2);
/*
        mStorageRef = FirebaseStorage.getInstance().getReference();

        Uri file = Uri.fromFile(new File("path/to/images/rivers.jpg"));
        StorageReference riversRef = mStorageRef.child("images/rivers.jpg");

        riversRef.putFile(file)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        // Get a URL to the uploaded content
                        //Uri downloadUrl = taskSnapshot.getDownloadUrl();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle unsuccessful uploads
                        // ...
                    }
                });

*/

        sehirdetayRv=findViewById(R.id.sehirdetayRv);
        //detaylar=(Detaylar) getIntent().getSerializableExtra("nesne");
        city =(City) getIntent().getSerializableExtra("nesne");

        sehirdetayRv.setHasFixedSize(true);
        sehirdetayRv.setLayoutManager(new LinearLayoutManager(this));

        detaylarArrayList=new ArrayList<>();

        Detaylar s1=new Detaylar(1,"Adana Taş Köprü","fghj","adanataskopru");
        Detaylar s2=new Detaylar(2,"Adana Sabancı Merkez Camii","sdfg","adanasabancimerkezcamii");
        Detaylar s3=new Detaylar(3,"Adana Yılan Kalesi","dfghj","adanayilankalesi");
        Detaylar s4=new Detaylar(4,"Adana Arkeoloji Müzesi","dfghj","adanaarkeolojimuzesi");
        Detaylar s5=new Detaylar(5,"Adana Bebekli Kilisesi","dfghj","adanabebeklikilisesi");
        Detaylar s6=new Detaylar(6,"Adana Büyük Saat Kulesi","dfghj","adanabuyuksaatkulesi");
        Detaylar s7=new Detaylar(7,"Başka bir yer","dfghj","adanabuyuksaatkulesi");


        detaylarArrayList.add(s1);
        detaylarArrayList.add(s2);
        detaylarArrayList.add(s3);
        detaylarArrayList.add(s4);
        detaylarArrayList.add(s5);
        detaylarArrayList.add(s6);
        detaylarArrayList.add(s7);


        adapter=new detaylarAdapter(this,detaylarArrayList);
        sehirdetayRv.setAdapter(adapter);


    }
}

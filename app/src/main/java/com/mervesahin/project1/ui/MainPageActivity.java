package com.mervesahin.project1.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


import com.mervesahin.project1.HaritaActivity;
import com.mervesahin.project1.R;

import java.io.IOException;

public class MainPageActivity extends AppCompatActivity {

    private Button btnUlkeTanı;
    private Button btnTurkiyeTani;
    private Button btnResimliQuiz;
    private Button btnBayrakTani;
    private Button btnUlkeQuiz;
    private Button btnHarita;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btnUlkeTanı=findViewById(R.id.btnUlkeTanı);
        btnTurkiyeTani=findViewById(R.id.btnTurkiyeTani);
        btnResimliQuiz=findViewById(R.id.btnResimliQuiz);
        btnBayrakTani=findViewById(R.id.btnBayrakTani);
        btnUlkeQuiz=findViewById(R.id.btnUlkeQuiz);
        btnHarita=findViewById(R.id.btnHarita);

       //toolbar bağlama
        toolbar=findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorPrimary));
        setSupportActionBar(toolbar);


        btnUlkeTanı.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainPageActivity.this, ContinentActivity.class));
            }
        });

        btnTurkiyeTani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainPageActivity.this, TurkeyCityNameInfoActivity.class));
            }
        });

        btnResimliQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainPageActivity.this, QuizImageCategoryActivity.class));
            }
        });

        btnBayrakTani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainPageActivity.this, FlagsInfoActivity.class));
            }
        });

        btnUlkeQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainPageActivity.this, QuizTestCategoryActivity.class));

            }
        });
        btnHarita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainPageActivity.this, HaritaActivity.class));
            }
        });
    }

    //bu aktivitede hangi menuyu göstereceğiz
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.ayar,menu);
        return super.onCreateOptionsMenu(menu);
    }
    //kullanıcı item'ı seçince ne olacak
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==R.id.ayarlar){
            Intent intent=new Intent(MainPageActivity.this,SettingsActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}

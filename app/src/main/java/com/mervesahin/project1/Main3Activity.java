package com.mervesahin.project1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


import java.io.IOException;

public class Main3Activity extends AppCompatActivity {

    private Button btnUlkeTanı;
    private Button btnTurkiyeTani;
    private Button btnHarita;
    private Button btnBayrakTani;
    private Button btnUlkeQuiz;
    private Button btnBayrakQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btnUlkeTanı=findViewById(R.id.btnUlkeTanı);
        btnTurkiyeTani=findViewById(R.id.btnTurkiyeTani);
        btnHarita=findViewById(R.id.btnHarita);
        btnBayrakTani=findViewById(R.id.btnBayrakTani);
        btnUlkeQuiz=findViewById(R.id.btnUlkeQuiz);
        btnBayrakQuiz=findViewById(R.id.btnBayrakQuiz);

        veritabaniKopyala();

        btnUlkeTanı.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main3Activity.this,UlkeleriTaniActivity.class));
            }
        });

        btnTurkiyeTani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main3Activity.this,TurkiyeyiTaniActivity.class));
            }
        });

        btnHarita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main3Activity.this,HaritaActivity.class));
            }
        });

        btnBayrakTani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main3Activity.this,BayraklariTaniActivity.class));
            }
        });

        btnUlkeQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main3Activity.this,UlkelerSehirlerQuizActivity.class));
            }
        });

        btnBayrakQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main3Activity.this,BayrakQuizActivity.class));
            }
        });
    }



    public void veritabaniKopyala(){
        DatabaseCopyHelper helper=new DatabaseCopyHelper(this);

        try {
            helper.createDataBase();
        }catch (IOException e){
            e.printStackTrace();
        }

        helper.openDataBase();
    }

}

package com.mervesahin.project1.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.mervesahin.project1.R;

public class SplashActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button button;
    private Animation dunyadonmehareketi;
    private Animation downtoup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView=findViewById(R.id.imageView);
        button=findViewById(R.id.button);

        dunyadonmehareketi = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.dunya_donme_hareketi);
        imageView.startAnimation(dunyadonmehareketi);

        downtoup= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.downtoup);
        button.setAnimation(downtoup);


    }
    public void btnBasla(View view){
        Intent intent=new Intent(SplashActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}

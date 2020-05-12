package com.mervesahin.project1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;
    private Button button;
    private Animation dunyadonmehareketi;
    private Animation downtoup;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=findViewById(R.id.imageView);
        textView=findViewById(R.id.textView);
        button=findViewById(R.id.button);

        //toolbar bağlama
        toolbar=findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorPrimary));
        setSupportActionBar(toolbar);


        dunyadonmehareketi = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.dunya_donme_hareketi);
        imageView.startAnimation(dunyadonmehareketi);

        downtoup= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.downtoup);
        button.setAnimation(downtoup);


    }
    //bu aktivitede hangi menuyu göstereceğiz
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.kullanici_degis,menu);
        return super.onCreateOptionsMenu(menu);
    }
    //kullanıcı item'ı seçince ne olacak
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==R.id.kullanici_degis){
            Intent intent=new Intent(MainActivity.this,Main2Activity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public void btnBasla(View view){
        Intent intent=new Intent(MainActivity.this,Main2Activity.class);
        startActivity(intent);
    }




}

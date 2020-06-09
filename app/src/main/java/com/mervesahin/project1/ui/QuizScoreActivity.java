package com.mervesahin.project1.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mervesahin.project1.R;

public class QuizScoreActivity extends AppCompatActivity {
    private TextView score;
    private Button btnTekrarla;
    private Button btnOyundanAyril;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_score);

        btnOyundanAyril=findViewById(R.id.btnOyundanAyril);
        btnTekrarla=findViewById(R.id.btnTekrarla);
        score = findViewById(R.id.score);

        String puan_str = getIntent().getStringExtra("SCORE");
        score.setText(puan_str);

        btnTekrarla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizScoreActivity.this, QuizTestCategoryActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnOyundanAyril.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(QuizScoreActivity.this);
                alert.setTitle("Oyundan Ayrıl");
                alert.setMessage("Oyundan ayrılmak istediğinize emin misiniz?");
                alert.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(QuizScoreActivity.this, MainPageActivity.class);
                        startActivity(intent);
                    }
                });
                alert.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(QuizScoreActivity.this,"Oyuna devam edebilirsiniz",Toast.LENGTH_LONG).show();

                    }
                });
                alert.show();
            }
        });









    }
}

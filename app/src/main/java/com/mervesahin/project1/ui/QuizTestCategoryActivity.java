package com.mervesahin.project1.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mervesahin.project1.R;

public class QuizTestCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiztest_category);

    }

    public void categoryOnClick(View view) {
        Intent intent = new Intent(QuizTestCategoryActivity.this, QuestionTestActivity.class);
        switch(view.getId()){
            case R.id.txt_turk_kitchen:
                intent.putExtra("questionKey","turk_kitchen");
                break;

            case R.id.txt_world_kitchen:
                intent.putExtra("questionKey","world_kitchen");
                break;

            case R.id.txt_capital:
                intent.putExtra("questionKey","capital");
                break;


            case R.id.txt_plaka:
                intent.putExtra("questionKey","plaka_kodu");
                break;

            case R.id.txt_spor:
                intent.putExtra("questionKey","sport");
                break;

            case R.id.txt_history:
                intent.putExtra("questionKey","history");
                break;

            case R.id.txt_cografya:
                intent.putExtra("questionKey","cografya");
                break;

            case R.id.txt_believe:
                intent.putExtra("questionKey","inanıslar");
                break;

            default:
                Toast.makeText(this,"Lütfen kategorilerden birini seçiniz!",Toast.LENGTH_SHORT).show();
                break;
        }

        startActivity(intent);
    }
}

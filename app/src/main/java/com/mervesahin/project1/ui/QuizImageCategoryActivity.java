package com.mervesahin.project1.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mervesahin.project1.R;

public class QuizImageCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizimage_category);
    }



    public void imageCategoryOnClick(View view) {
        Intent intent = new Intent(QuizImageCategoryActivity.this, QuestionImageActivity.class);

        switch(view.getId()){

            case R.id.txt_traditional2:
                intent.putExtra("questionKey2","traditional2");
                break;

            case R.id.txt_flag2:
                intent.putExtra("questionKey2","flag2");
                break;

            default:
                Toast.makeText(this,"Lütfen kategorilerden birini seçiniz!",Toast.LENGTH_SHORT).show();
                break;
        }

        startActivity(intent);
    }
}

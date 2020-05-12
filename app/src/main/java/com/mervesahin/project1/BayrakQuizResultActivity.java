package com.mervesahin.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class BayrakQuizResultActivity extends AppCompatActivity {

    private TextView txtSonuc,txtYuzde;
    private Button btnTekrarDene;
    private int dogruSayac,yanlisSayac;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bayrak_quiz_result);

        txtSonuc=findViewById(R.id.txtSonuc);
        txtYuzde=findViewById(R.id.txtYuzde);
        btnTekrarDene=findViewById(R.id.btnTekrarDene);

        dogruSayac=getIntent().getIntExtra("dogruSayac",0);
        yanlisSayac=getIntent().getIntExtra("yanlisSayac",0);

        txtSonuc.setText(dogruSayac+" DOĞRU "+(5-dogruSayac)+" YANLIŞ");
        txtYuzde.setText("Puan:"+ (5-yanlisSayac));
        /*
        //puan hesapla
        if(dogruSayac > yanlisSayac){
            txtYuzde.setText("Puan:"+(5-yanlisSayac));
        }else{
            txtYuzde.setText("Puan: -"+(dogruSayac-yanlisSayac));
        }*/



        btnTekrarDene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BayrakQuizResultActivity.this,BayrakQuizActivity.class));
                finish();

            }
        });

    }
}

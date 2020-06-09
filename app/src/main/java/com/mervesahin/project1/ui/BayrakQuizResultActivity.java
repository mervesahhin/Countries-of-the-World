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

public class BayrakQuizResultActivity extends AppCompatActivity {

    private TextView txtSonuc,txtYuzde;
    private Button btnTekrarDene,btnOyundanCik;
    private int dogruSayac,yanlisSayac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bayrak_quiz_result);

        txtSonuc=findViewById(R.id.txtSonuc);
        txtYuzde=findViewById(R.id.txtYuzde);
        btnTekrarDene=findViewById(R.id.btnTekrarDene);
        btnOyundanCik=findViewById(R.id.btnOyundanCik);

        dogruSayac=getIntent().getIntExtra("dogruSayac",0);
        yanlisSayac=getIntent().getIntExtra("yanlisSayac",0);

        txtSonuc.setText(dogruSayac+" DOĞRU "+(5-dogruSayac)+" YANLIŞ");

        if(dogruSayac > yanlisSayac){
            Integer a=dogruSayac-yanlisSayac;
            txtYuzde.setText("Puan:"+a);
        }else{
            Integer b=yanlisSayac-dogruSayac;
            txtYuzde.setText("Puan: -"+b);
        }



        btnTekrarDene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BayrakQuizResultActivity.this,BayrakQuizActivity.class));
                finish();


            }
        });

        btnOyundanCik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(BayrakQuizResultActivity.this);
                alert.setTitle("Oyundan Ayrıl");
                alert.setMessage("Oyundan ayrılmak istediğinize emin misiniz?");
                alert.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(BayrakQuizResultActivity.this, MainPageActivity.class);
                        startActivity(intent);
                    }
                });
                alert.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(BayrakQuizResultActivity.this,"Oyuna devam edebilirsiniz",Toast.LENGTH_LONG).show();

                    }
                });
                alert.show();
            }
        });
    }
}

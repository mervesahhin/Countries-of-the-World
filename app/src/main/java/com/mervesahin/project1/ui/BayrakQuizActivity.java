
package com.mervesahin.project1.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mervesahin.project1.BayrakQuizVeritabani;
import com.mervesahin.project1.BayraklarDao;
import com.mervesahin.project1.model.Flag;
import com.mervesahin.project1.R;

import java.util.ArrayList;
import java.util.HashSet;

public class BayrakQuizActivity extends AppCompatActivity {

    private TextView txtDogruToplam;
    private ImageView imageBayrak;
    private Button BtnA, BtnB, BtnC, BtnD;
    private ArrayList<Flag> sorularListe;
    private ArrayList<Flag> yanlisSeceneklerListe;
    private Flag dogruSoru;
    private BayrakQuizVeritabani vt;

    private TextView countdown2;
    private CountDownTimer countDown2;

    //sayaç
    private int soruSayac = 0;
    private int dogruSayac = 0;
    //secenekler
    private HashSet<Flag> seceneklerKaristirmaListe = new HashSet<>();
    private ArrayList<Flag> seceneklerListe = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bayrak_quiz);

        txtDogruToplam= findViewById(R.id.txtDogruToplam);
        imageBayrak = findViewById(R.id.image);

        BtnA = findViewById(R.id.BtnA);
        BtnB = findViewById(R.id.BtnB);
        BtnC = findViewById(R.id.BtnC);
        BtnD = findViewById(R.id.BtnD);

        countdown2 = findViewById(R.id.countdown2);

        vt = new BayrakQuizVeritabani(this);
        sorularListe = new BayraklarDao().rastgele5Getir(vt);
        soruYukle();


        BtnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dogruKontrol(BtnA);
                sayacKontrol();

            }
        });

        BtnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dogruKontrol(BtnB);
                sayacKontrol();

            }
        });

        BtnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dogruKontrol(BtnC);
                sayacKontrol();

            }
        });

        BtnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dogruKontrol(BtnD);
                sayacKontrol();

            }
        });

        countdown2.setText(String.valueOf(10));
        //startTimer();

    }

   /* public void startTimer(){
        countDown2 = new CountDownTimer(12000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if(millisUntilFinished < 15000)
                    countdown2.setText(String.valueOf(millisUntilFinished/1000));

            }

            @Override
            public void onFinish(){
                //eksik
            }
        };
        countDown2.start();

    }*/

    public void soruYukle() {

        txtDogruToplam.setText(dogruSayac+"/"+5);
        dogruSoru = sorularListe.get(soruSayac);
        yanlisSeceneklerListe = new BayraklarDao().rastgele3YanlısSecenekGetir(vt, dogruSoru.getBayrak_id());
        imageBayrak.setImageResource(getResources().getIdentifier(dogruSoru.getBayrak_resim(), "drawable", getPackageName()));

        seceneklerKaristirmaListe.clear();
        seceneklerKaristirmaListe.add(dogruSoru);
        seceneklerKaristirmaListe.add(yanlisSeceneklerListe.get(0));
        seceneklerKaristirmaListe.add(yanlisSeceneklerListe.get(1));
        seceneklerKaristirmaListe.add(yanlisSeceneklerListe.get(2));

        seceneklerListe.clear();

        for (Flag b : seceneklerKaristirmaListe) {
            seceneklerListe.add(b);
        }

        BtnA.setText(seceneklerListe.get(0).getBayrak_adi());
        BtnB.setText(seceneklerListe.get(1).getBayrak_adi());
        BtnC.setText(seceneklerListe.get(2).getBayrak_adi());
        BtnD.setText(seceneklerListe.get(3).getBayrak_adi());

    }

    public void dogruKontrol(Button button) {
        String buttonYazi = button.getText().toString();
        String dogruCevap = dogruSoru.getBayrak_adi();

        if (buttonYazi.equals(dogruCevap)) {
            dogruSayac++;
        } else {

        }


    }

    public void sayacKontrol() {
        soruSayac++;
        if (soruSayac != 5) {
            soruYukle();
        } else {
            Intent intent = new Intent(BayrakQuizActivity.this, BayrakQuizResultActivity.class);
            intent.putExtra("dogruSayac", dogruSayac);
            startActivity(intent);
            finish();
        }

    }
}
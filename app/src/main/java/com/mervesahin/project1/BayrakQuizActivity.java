package com.mervesahin.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;

public class BayrakQuizActivity extends AppCompatActivity {

    private TextView txtSoruSayisi,txtDogruSayisi,txtYanlisSayisi;
    private ImageView imageBayrak;
    private Button BtnA,BtnB,BtnC,BtnD;
    private ArrayList<Bayraklar> sorularListe;
    private ArrayList<Bayraklar> yanlisSeceneklerListe;
    private Bayraklar dogruSoru;
    private BayrakQuizVeritabani vt;
    //sayaç
    private int soruSayac=0;
    private int yanlisSayac=0;
    private int dogruSayac=0;
    //secenekler
    private HashSet<Bayraklar>seceneklerKaristirmaListe=new HashSet<>();
    private ArrayList<Bayraklar> seceneklerListe=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bayrak_quiz);

        txtSoruSayisi=findViewById(R.id.txtSoruSayisi);
        txtDogruSayisi=findViewById(R.id.txtDogruSayisi);
        txtYanlisSayisi=findViewById(R.id.txtYanlisSayisi);
        imageBayrak=findViewById(R.id.imageBayrak);
        BtnA=findViewById(R.id.BtnA);
        BtnB=findViewById(R.id.BtnB);
        BtnC=findViewById(R.id.BtnC);
        BtnD=findViewById(R.id.BtnD);

        vt=new BayrakQuizVeritabani(this);
        sorularListe=new BayraklarDao().rastgele5Getir(vt);
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

    }

    public void soruYukle(){
        txtSoruSayisi.setText((soruSayac+1)+".SORU");
        txtDogruSayisi.setText("Doğru :"+dogruSayac);
        txtYanlisSayisi.setText("Yanlış :"+yanlisSayac);

        dogruSoru=sorularListe.get(soruSayac);
        yanlisSeceneklerListe=new BayraklarDao().rastgele3YanlısSecenekGetir(vt,dogruSoru.getBayrak_id());
        imageBayrak.setImageResource(getResources().getIdentifier(dogruSoru.getBayrak_resim(),"drawable",getPackageName()));

        seceneklerKaristirmaListe.clear();
        seceneklerKaristirmaListe.add(dogruSoru);
        seceneklerKaristirmaListe.add(yanlisSeceneklerListe.get(0));
        seceneklerKaristirmaListe.add(yanlisSeceneklerListe.get(1));
        seceneklerKaristirmaListe.add(yanlisSeceneklerListe.get(2));

        seceneklerListe.clear();

        for(Bayraklar b:seceneklerKaristirmaListe){
            seceneklerListe.add(b);
        }

        BtnA.setText(seceneklerListe.get(0).getBayrak_adi());
        BtnB.setText(seceneklerListe.get(1).getBayrak_adi());
        BtnC.setText(seceneklerListe.get(2).getBayrak_adi());
        BtnD.setText(seceneklerListe.get(3).getBayrak_adi());

    }

    public void dogruKontrol(Button button){
        String buttonYazi=button.getText().toString();
        String dogruCevap=dogruSoru.getBayrak_adi();

        if(buttonYazi.equals(dogruCevap)){
            dogruSayac++;
        }else{
            yanlisSayac++;
        }


    }
    public void sayacKontrol(){
        soruSayac++;
        if(soruSayac !=5){
            soruYukle();
        }else{
            Intent intent=new Intent(BayrakQuizActivity.this,BayrakQuizResultActivity.class);
            intent.putExtra("dogruSayac",dogruSayac);
            startActivity(intent);
            finish();
        }

    }




}

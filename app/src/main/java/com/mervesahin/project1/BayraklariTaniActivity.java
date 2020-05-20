package com.mervesahin.project1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;

public class BayraklariTaniActivity extends AppCompatActivity {

    private RecyclerView rv;
    private ArrayList<Bayraklar>bayraklarArrayList2;
    private BayrakAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bayraklari_tani);

        rv=findViewById(R.id.rv);
        rv.setHasFixedSize(true);

        //yanyana 2 satır şeklinde bir görünüm istersek
       // rv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        rv.setLayoutManager(new LinearLayoutManager(this));


        Bayraklar b1=new Bayraklar(1,"ABHAZYA","abhazya");
        Bayraklar b2=new Bayraklar(2,"AFGANİSTAN","afganistan");
        Bayraklar b3=new Bayraklar(3,"ALMANYA","almanya");
        Bayraklar b4=new Bayraklar(4,"AMERİKA BİRLEŞİK DEVLETLERİ","amerkabirlesikd");
        Bayraklar b5=new Bayraklar(5,"ANDORRA","andorra");
        Bayraklar b6=new Bayraklar(6,"ANGOLA","angola");
        Bayraklar b7=new Bayraklar(7,"ARJANTİN","arjantin");
        Bayraklar b8=new Bayraklar(8,"ARNAVUTLUK","arnavutluk");
        Bayraklar b9=new Bayraklar(9,"AVUSTRALYA","avustralya");
        Bayraklar b10=new Bayraklar(10,"AVUSTURYA","avusturya");
        Bayraklar b11=new Bayraklar(11,"AZERBAYCAN","azerbaycan");
        Bayraklar b12=new Bayraklar(12,"BAHAMALAR","bahamalar");
        Bayraklar b13=new Bayraklar(13,"BAHREYN","bahreyn");
        Bayraklar b14=new Bayraklar(14,"BANGLADEŞ","banglades");
        Bayraklar b15=new Bayraklar(15,"BARBADOS","barbados");
        Bayraklar b16=new Bayraklar(16,"BELÇİKA","belcika");
        Bayraklar b17=new Bayraklar(17,"BELİZE","belize");
        Bayraklar b18=new Bayraklar(18,"BENİN","benin");
        Bayraklar b19=new Bayraklar(19,"BEYAZ RUSYA","beyazrusya");
        Bayraklar b20=new Bayraklar(20,"BHUTAN","bhutan");
        Bayraklar b21=new Bayraklar(21,"BİRLEŞİK ARAP EMİRLİKLERİ","birlesikarape");
        Bayraklar b22=new Bayraklar(22,"BOLİVYA","bolivya");
        Bayraklar b23=new Bayraklar(23,"BOSNAHERSEK","bosnahersek");
        Bayraklar b24=new Bayraklar(24,"BOTSVANA","botsvana");
        Bayraklar b25=new Bayraklar(25,"BREZİLYA","brezilya");
        Bayraklar b26=new Bayraklar(26,"BRUNEİ","brunei");
        Bayraklar b27=new Bayraklar(27,"BULGARİSTAN","bulgaristan");
        Bayraklar b28=new Bayraklar(28,"BURUNDİ","burundi");
        Bayraklar b29=new Bayraklar(29,"ÇAD","cad");
        Bayraklar b30=new Bayraklar(30,"ÇEK CUMHURİYETİ","cekcumhuriyeti");
        Bayraklar b31=new Bayraklar(31,"CEZAYİR","cezayir");
        Bayraklar b32=new Bayraklar(32,"CİBUTİ","cibuti");
        Bayraklar b33=new Bayraklar(33,"ÇİN","cin");
        Bayraklar b34=new Bayraklar(34,"DANİMARKA","danimarka");
        Bayraklar b35=new Bayraklar(35,"DOĞU TİMOR","dogutimor");
        Bayraklar b36=new Bayraklar(36,"DOMİNİKA","dominika");
        Bayraklar b37=new Bayraklar(37,"DOMİNİK CUMHURİYETİ","dominikcumhuriyeti");
        Bayraklar b38=new Bayraklar(38,"EKVADOR","ekvador");
        Bayraklar b39=new Bayraklar(39,"EKVATOR GİNESİ","ekvatorginesi");
        Bayraklar b40=new Bayraklar(40,"EL SALVADOR","elsalvador");
        Bayraklar b41=new Bayraklar(41,"ENDONEZYA","endonezya");
        Bayraklar b42=new Bayraklar(42,"ERİTRE","eritre");
        Bayraklar b43=new Bayraklar(43,"ERMENİSTAN","ermenistan");
        Bayraklar b44=new Bayraklar(44,"ESTONYA","estonya");
        Bayraklar b45=new Bayraklar(45,"ETİYOPYA","etiyopya");
        Bayraklar b46=new Bayraklar(46,"FAS","fas");
        Bayraklar b47=new Bayraklar(47,"FİJİ","fiji");
        Bayraklar b48=new Bayraklar(48,"FİLDİŞİ SAHİLİ","fildisisahili");
        Bayraklar b49=new Bayraklar(49,"FİLİPİNLER","filipinler");
        Bayraklar b50=new Bayraklar(50,"FİLİSTİN","filistin");
        Bayraklar b51=new Bayraklar(51,"FİNLANDİYA","finlandiya");
        Bayraklar b52=new Bayraklar(52,"FRANSA","fransa");
        Bayraklar b53=new Bayraklar(53,"GABON","gabon");
        Bayraklar b54=new Bayraklar(54,"GAMBİYA","gambiya");
        Bayraklar b55=new Bayraklar(55,"GANA","gana");
        Bayraklar b56=new Bayraklar(56,"GİNE","gine");
        Bayraklar b57=new Bayraklar(57,"GRENADA","grenada");
        Bayraklar b58=new Bayraklar(58,"GUATEMALA","guatemala");
        Bayraklar b59=new Bayraklar(59,"GÜNEY AFRİKA CUMHURİYETİ","guneyafrikacumhuriyeti");
        Bayraklar b60=new Bayraklar(60,"GÜNEY KORE","guneykore");
        Bayraklar b61=new Bayraklar(61,"GÜRCİSTAN","gurcistan");
        Bayraklar b62=new Bayraklar(62,"GUYANA","guyana");
        Bayraklar b63=new Bayraklar(63,"HİNDİSTAN","hindistan");
        Bayraklar b64=new Bayraklar(64,"HOLLANDA","hollanda");
        Bayraklar b65=new Bayraklar(65,"IRAK","irak");
        Bayraklar b66=new Bayraklar(66,"İRAN","iran");
        Bayraklar b67=new Bayraklar(67,"İRLANDA","irlanda");
        Bayraklar b68=new Bayraklar(68,"İSPANYA","ispanya");
        Bayraklar b69=new Bayraklar(69,"İSRAİL","israil");
        Bayraklar b70=new Bayraklar(70,"İSVEÇ","isvec");
        Bayraklar b71=new Bayraklar(71,"İSVİÇRE","isvicre");
        Bayraklar b72=new Bayraklar(72,"İTALYA","italya");
        Bayraklar b73=new Bayraklar(73,"İZLANDA","izlanda");
        Bayraklar b74=new Bayraklar(74,"JAMAİKA","jamaika");
        Bayraklar b75=new Bayraklar(75,"JAPONYA","japonya");




        bayraklarArrayList2=new ArrayList<>();

        bayraklarArrayList2.add(b1);
        bayraklarArrayList2.add(b2);
        bayraklarArrayList2.add(b3);
        bayraklarArrayList2.add(b4);
        bayraklarArrayList2.add(b5);
        bayraklarArrayList2.add(b6);
        bayraklarArrayList2.add(b7);
        bayraklarArrayList2.add(b8);
        bayraklarArrayList2.add(b9);
        bayraklarArrayList2.add(b10);
        bayraklarArrayList2.add(b11);
        bayraklarArrayList2.add(b12);
        bayraklarArrayList2.add(b13);
        bayraklarArrayList2.add(b14);
        bayraklarArrayList2.add(b15);
        bayraklarArrayList2.add(b16);
        bayraklarArrayList2.add(b17);
        bayraklarArrayList2.add(b18);
        bayraklarArrayList2.add(b19);
        bayraklarArrayList2.add(b20);
        bayraklarArrayList2.add(b21);
        bayraklarArrayList2.add(b22);
        bayraklarArrayList2.add(b23);
        bayraklarArrayList2.add(b24);
        bayraklarArrayList2.add(b25);
        bayraklarArrayList2.add(b26);
        bayraklarArrayList2.add(b27);
        bayraklarArrayList2.add(b28);
        bayraklarArrayList2.add(b29);
        bayraklarArrayList2.add(b30);
        bayraklarArrayList2.add(b31);
        bayraklarArrayList2.add(b32);
        bayraklarArrayList2.add(b33);
        bayraklarArrayList2.add(b34);
        bayraklarArrayList2.add(b35);
        bayraklarArrayList2.add(b36);
        bayraklarArrayList2.add(b37);
        bayraklarArrayList2.add(b38);
        bayraklarArrayList2.add(b39);
        bayraklarArrayList2.add(b40);
        bayraklarArrayList2.add(b41);
        bayraklarArrayList2.add(b42);
        bayraklarArrayList2.add(b43);
        bayraklarArrayList2.add(b44);
        bayraklarArrayList2.add(b45);
        bayraklarArrayList2.add(b46);
        bayraklarArrayList2.add(b47);
        bayraklarArrayList2.add(b48);
        bayraklarArrayList2.add(b49);
        bayraklarArrayList2.add(b50);
        bayraklarArrayList2.add(b51);
        bayraklarArrayList2.add(b52);
        bayraklarArrayList2.add(b53);
        bayraklarArrayList2.add(b54);
        bayraklarArrayList2.add(b55);
        bayraklarArrayList2.add(b56);
        bayraklarArrayList2.add(b57);
        bayraklarArrayList2.add(b58);
        bayraklarArrayList2.add(b59);
        bayraklarArrayList2.add(b60);
        bayraklarArrayList2.add(b61);
        bayraklarArrayList2.add(b62);
        bayraklarArrayList2.add(b63);
        bayraklarArrayList2.add(b64);
        bayraklarArrayList2.add(b65);
        bayraklarArrayList2.add(b66);
        bayraklarArrayList2.add(b67);
        bayraklarArrayList2.add(b68);
        bayraklarArrayList2.add(b69);
        bayraklarArrayList2.add(b70);
        bayraklarArrayList2.add(b71);
        bayraklarArrayList2.add(b72);
        bayraklarArrayList2.add(b73);
        bayraklarArrayList2.add(b74);
        bayraklarArrayList2.add(b75);


        adapter=new BayrakAdapter(this,bayraklarArrayList2);
        rv.setAdapter(adapter);



    }
}

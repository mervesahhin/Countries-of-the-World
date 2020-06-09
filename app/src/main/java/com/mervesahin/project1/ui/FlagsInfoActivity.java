package com.mervesahin.project1.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.mervesahin.project1.model.Flag;
import com.mervesahin.project1.R;
import com.mervesahin.project1.adapter.FlagAdapter;

import java.util.ArrayList;

public class FlagsInfoActivity extends AppCompatActivity {

    private RecyclerView rv;
    private ArrayList<Flag> flagArrayList2;
    private FlagAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bayraklari_tani);

        rv=findViewById(R.id.rv);
        rv.setHasFixedSize(true);

        //yanyana 2 satır şeklinde bir görünüm istersek
       // rv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        rv.setLayoutManager(new LinearLayoutManager(this));


        Flag b1=new Flag(1,"ABHAZYA","abhazya");
        Flag b2=new Flag(2,"AFGANİSTAN","afganistan");
        Flag b3=new Flag(3,"ALMANYA","almanya");
        Flag b4=new Flag(4,"AMERİKA BİRLEŞİK DEVLETLERİ","amerkabirlesikd");
        Flag b5=new Flag(5,"ANDORRA","andorra");
        Flag b6=new Flag(6,"ANGOLA","angola");
        Flag b7=new Flag(7,"ARJANTİN","arjantin");
        Flag b8=new Flag(8,"ARNAVUTLUK","arnavutluk");
        Flag b9=new Flag(9,"AVUSTRALYA","avustralya");
        Flag b10=new Flag(10,"AVUSTURYA","avusturya");
        Flag b11=new Flag(11,"AZERBAYCAN","azerbaycan");
        Flag b12=new Flag(12,"BAHAMALAR","bahamalar");
        Flag b13=new Flag(13,"BAHREYN","bahreyn");
        Flag b14=new Flag(14,"BANGLADEŞ","banglades");
        Flag b15=new Flag(15,"BARBADOS","barbados");
        Flag b16=new Flag(16,"BELÇİKA","belcika");
        Flag b17=new Flag(17,"BELİZE","belize");
        Flag b18=new Flag(18,"BENİN","benin");
        Flag b19=new Flag(19,"BEYAZ RUSYA","beyazrusya");
        Flag b20=new Flag(20,"BHUTAN","bhutan");
        Flag b21=new Flag(21,"BİRLEŞİK ARAP EMİRLİKLERİ","birlesikarape");
        Flag b22=new Flag(22,"BOLİVYA","bolivya");
        Flag b23=new Flag(23,"BOSNAHERSEK","bosnahersek");
        Flag b24=new Flag(24,"BOTSVANA","botsvana");
        Flag b25=new Flag(25,"BREZİLYA","brezilya");
        Flag b26=new Flag(26,"BRUNEİ","brunei");
        Flag b27=new Flag(27,"BULGARİSTAN","bulgaristan");
        Flag b28=new Flag(28,"BURUNDİ","burundi");
        Flag b29=new Flag(29,"ÇAD","cad");
        Flag b30=new Flag(30,"ÇEK CUMHURİYETİ","cekcumhuriyeti");
        Flag b31=new Flag(31,"CEZAYİR","cezayir");
        Flag b32=new Flag(32,"CİBUTİ","cibuti");
        Flag b33=new Flag(33,"ÇİN","cin");
        Flag b34=new Flag(34,"DANİMARKA","danimarka");
        Flag b35=new Flag(35,"DOĞU TİMOR","dogutimor");
        Flag b36=new Flag(36,"DOMİNİKA","dominika");
        Flag b37=new Flag(37,"DOMİNİK CUMHURİYETİ","dominikcumhuriyeti");
        Flag b38=new Flag(38,"EKVADOR","ekvador");
        Flag b39=new Flag(39,"EKVATOR GİNESİ","ekvatorginesi");
        Flag b40=new Flag(40,"EL SALVADOR","elsalvador");
        Flag b41=new Flag(41,"ENDONEZYA","endonezya");
        Flag b42=new Flag(42,"ERİTRE","eritre");
        Flag b43=new Flag(43,"ERMENİSTAN","ermenistan");
        Flag b44=new Flag(44,"ESTONYA","estonya");
        Flag b45=new Flag(45,"ETİYOPYA","etiyopya");
        Flag b46=new Flag(46,"FAS","fas");
        Flag b47=new Flag(47,"FİJİ","fiji");
        Flag b48=new Flag(48,"FİLDİŞİ SAHİLİ","fildisisahili");
        Flag b49=new Flag(49,"FİLİPİNLER","filipinler");
        Flag b50=new Flag(50,"FİLİSTİN","filistin");
        Flag b51=new Flag(51,"FİNLANDİYA","finlandiya");
        Flag b52=new Flag(52,"FRANSA","fransa");
        Flag b53=new Flag(53,"GABON","gabon");
        Flag b54=new Flag(54,"GAMBİYA","gambiya");
        Flag b55=new Flag(55,"GANA","gana");
        Flag b56=new Flag(56,"GİNE","gine");
        Flag b57=new Flag(57,"GRENADA","grenada");
        Flag b58=new Flag(58,"GUATEMALA","guatemala");
        Flag b59=new Flag(59,"GÜNEY AFRİKA CUMHURİYETİ","guneyafrikacumhuriyeti");
        Flag b60=new Flag(60,"GÜNEY KORE","guneykore");
        Flag b61=new Flag(61,"GÜRCİSTAN","gurcistan");
        Flag b62=new Flag(62,"GUYANA","guyana");
        Flag b63=new Flag(63,"HİNDİSTAN","hindistan");
        Flag b64=new Flag(64,"HOLLANDA","hollanda");
        Flag b65=new Flag(65,"IRAK","irak");
        Flag b66=new Flag(66,"İRAN","iran");
        Flag b67=new Flag(67,"İRLANDA","irlanda");
        Flag b68=new Flag(68,"İSPANYA","ispanya");
        Flag b69=new Flag(69,"İSRAİL","israil");
        Flag b70=new Flag(70,"İSVEÇ","isvec");
        Flag b71=new Flag(71,"İSVİÇRE","isvicre");
        Flag b72=new Flag(72,"İTALYA","italya");
        Flag b73=new Flag(73,"İZLANDA","izlanda");
        Flag b74=new Flag(74,"JAMAİKA","jamaika");
        Flag b75=new Flag(75,"JAPONYA","japonya");




        flagArrayList2 =new ArrayList<>();

        flagArrayList2.add(b1);
        flagArrayList2.add(b2);
        flagArrayList2.add(b3);
        flagArrayList2.add(b4);
        flagArrayList2.add(b5);
        flagArrayList2.add(b6);
        flagArrayList2.add(b7);
        flagArrayList2.add(b8);
        flagArrayList2.add(b9);
        flagArrayList2.add(b10);
        flagArrayList2.add(b11);
        flagArrayList2.add(b12);
        flagArrayList2.add(b13);
        flagArrayList2.add(b14);
        flagArrayList2.add(b15);
        flagArrayList2.add(b16);
        flagArrayList2.add(b17);
        flagArrayList2.add(b18);
        flagArrayList2.add(b19);
        flagArrayList2.add(b20);
        flagArrayList2.add(b21);
        flagArrayList2.add(b22);
        flagArrayList2.add(b23);
        flagArrayList2.add(b24);
        flagArrayList2.add(b25);
        flagArrayList2.add(b26);
        flagArrayList2.add(b27);
        flagArrayList2.add(b28);
        flagArrayList2.add(b29);
        flagArrayList2.add(b30);
        flagArrayList2.add(b31);
        flagArrayList2.add(b32);
        flagArrayList2.add(b33);
        flagArrayList2.add(b34);
        flagArrayList2.add(b35);
        flagArrayList2.add(b36);
        flagArrayList2.add(b37);
        flagArrayList2.add(b38);
        flagArrayList2.add(b39);
        flagArrayList2.add(b40);
        flagArrayList2.add(b41);
        flagArrayList2.add(b42);
        flagArrayList2.add(b43);
        flagArrayList2.add(b44);
        flagArrayList2.add(b45);
        flagArrayList2.add(b46);
        flagArrayList2.add(b47);
        flagArrayList2.add(b48);
        flagArrayList2.add(b49);
        flagArrayList2.add(b50);
        flagArrayList2.add(b51);
        flagArrayList2.add(b52);
        flagArrayList2.add(b53);
        flagArrayList2.add(b54);
        flagArrayList2.add(b55);
        flagArrayList2.add(b56);
        flagArrayList2.add(b57);
        flagArrayList2.add(b58);
        flagArrayList2.add(b59);
        flagArrayList2.add(b60);
        flagArrayList2.add(b61);
        flagArrayList2.add(b62);
        flagArrayList2.add(b63);
        flagArrayList2.add(b64);
        flagArrayList2.add(b65);
        flagArrayList2.add(b66);
        flagArrayList2.add(b67);
        flagArrayList2.add(b68);
        flagArrayList2.add(b69);
        flagArrayList2.add(b70);
        flagArrayList2.add(b71);
        flagArrayList2.add(b72);
        flagArrayList2.add(b73);
        flagArrayList2.add(b74);
        flagArrayList2.add(b75);


        adapter=new FlagAdapter(this, flagArrayList2);
        rv.setAdapter(adapter);



    }
}

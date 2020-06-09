package com.mervesahin.project1;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.mervesahin.project1.model.Flag;

import java.util.ArrayList;

public class BayraklarDao  {
    public ArrayList<Flag> rastgele5Getir(BayrakQuizVeritabani vt){
        ArrayList<Flag> flagArrayList =new ArrayList<>();
        SQLiteDatabase db=vt.getWritableDatabase();
        Cursor c=db.rawQuery("SELECT * FROM bayraklar ORDER BY RANDOM() LIMIT 5",null);

        while (c.moveToNext()){
            Flag b=new Flag(c.getInt(c.getColumnIndex("bayrak_id")),
                    c.getString(c.getColumnIndex("bayrak_ad")),
                    c.getString(c.getColumnIndex("bayrak_resim")));
            flagArrayList.add(b);
        }
        return flagArrayList;
    }


    public ArrayList<Flag> rastgele3YanlısSecenekGetir(BayrakQuizVeritabani vt, int bayrak_id){
        ArrayList<Flag> flagArrayList =new ArrayList<>();
        SQLiteDatabase db=vt.getWritableDatabase();
        Cursor c=db.rawQuery("SELECT * FROM bayraklar WHERE bayrak_id !="+bayrak_id+" ORDER BY RANDOM() LIMIT 3",null);

        while (c.moveToNext()){
            Flag b=new Flag(c.getInt(c.getColumnIndex("bayrak_id")),
                    c.getString(c.getColumnIndex("bayrak_ad")),
                    c.getString(c.getColumnIndex("bayrak_resim")));
            flagArrayList.add(b);
        }
        return flagArrayList;
    }
}
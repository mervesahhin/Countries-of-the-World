package com.mervesahin.project1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BayrakQuizVeritabani extends SQLiteOpenHelper {
    public BayrakQuizVeritabani(@Nullable Context context) {
        super(context, "bayrakquiz.sqlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS 'bayraklar' (\n" +
                "\t'bayrak_id'\t INTEGER PRIMARY KEY AUTOINCREMENT,\n"+
                "\t'bayrak_ad'\t TEXT,\n"+
                "\t'bayrak_resim'\tTEXT\n"+
                ");");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS bayraklar");
        onCreate(db);

    }
}

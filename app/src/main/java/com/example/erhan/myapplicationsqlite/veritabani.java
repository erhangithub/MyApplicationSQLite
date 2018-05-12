package com.example.erhan.myapplicationsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ListView;

import java.sql.SQLData;
import java.util.ArrayList;
import java.util.List;

public class veritabani extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "veritabani";
    private static final String DATABASE_TABLE = "kisiler" ;
    private static final int DATABASE_VERSION = 1 ;
    public static final String ROW_ID = "id" ;
    public static final String ROW_NAME = "isim" ;
    public static final String ROW_PHONE = "telefon" ;


    public veritabani(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sorgu = "create table " + DATABASE_TABLE + " ("+ROW_ID+" integer primary key, "
                +ROW_NAME+ " text not null, " +ROW_PHONE+" text not null) ";
        db.execSQL(sorgu);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sorgu = " drop table if exists "+DATABASE_TABLE;
        db.execSQL(sorgu);
        onCreate(db);
    }

    public void veriEkle(String ad, String telefon)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(ROW_NAME,ad.trim());
        cv.put(ROW_PHONE,telefon.trim());
        db.insert(DATABASE_TABLE,null,cv);
        db.close();
    }

    public List<String> veriListele()
    {
        List<String> veriler = new ArrayList<String>();
        SQLiteDatabase db = this.getWritableDatabase();
        String[] sutunlar = {ROW_ID,ROW_NAME,ROW_PHONE};
        Cursor cursor = db.query(DATABASE_TABLE,sutunlar,null,null,null,null,null);
        while (cursor.moveToNext())
        {
            veriler.add(cursor.getInt(0)+" - "+ cursor.getString(1)+" - "+
                cursor.getString(2));
        }
        return veriler;
    }
}


















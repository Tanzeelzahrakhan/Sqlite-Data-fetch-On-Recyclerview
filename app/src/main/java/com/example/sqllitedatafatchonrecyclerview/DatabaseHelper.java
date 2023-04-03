package com.example.sqllitedatafatchonrecyclerview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context) {
        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase Db) {
        Db.execSQL("create Table UserDetails(name TEXT primary key,dept TEXT ,city TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase Db, int i, int i1) {
        Db.execSQL("drop Table if exists UserDetails");

    }

    // insert Data Method
    public boolean insertData(String name, String dept, String city) {

        SQLiteDatabase Db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("dept", dept);
        contentValues.put("city", city);
        long success = Db.insert("UserDetails", null, contentValues);
        if (success == -1) {
            return false;
        } else {
            return true;
        }
    }
    //Fetch Data Method


    public Cursor getAllData()
    {
        SQLiteDatabase Db = this.getWritableDatabase();

        Cursor cur  = Db.rawQuery("select * from UserDetails",null);
        return cur;

    }
}
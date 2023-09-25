package com.example.databaseproject;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context) {
        super(context, "studentdb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("Create table if not exists student(id integer primary key autoincrement,name varchar,address varchar,phone varchar)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists student");
        onCreate(sqLiteDatabase);

    }

    public void insertdata(DataModel d) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", d.name);
        values.put("address", d.address);
        values.put("phone", d.phone);
        db.insert("Student", null, values);
    }

    public ArrayList<DataModel> readdata() {
        ArrayList<DataModel> data=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery("Select * from student",null);
        if(c.moveToFirst()){
         do{
            DataModel d=new DataModel();
            d.id=c.getInt(0);
            d.name=c.getString(1);
            d.address=c.getString(2);
            d.phone=c.getString(3);
            data.add(d);
         }while (c.moveToNext());
        }
        return data;
    }

    public void deletaData(int id) {
        SQLiteDatabase remove=this.getWritableDatabase();
        remove.execSQL("delete from student where id="+id);

    }

    public void updatedata(DataModel d) {
        SQLiteDatabase fill=this.getWritableDatabase();
        ContentValues content=new ContentValues();
        content.put("Name",d.name);
        content.put("Address",d.address);
        content.put("Phone",d.phone);
        fill.update("student",content,"id="+d.id,null);


    }
}

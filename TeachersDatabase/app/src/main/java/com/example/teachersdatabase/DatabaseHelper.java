package com.example.teachersdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(@Nullable Context context) {
        super(context, "TeachersDB",null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table if not exists teacher(id integer primary key autoincrement,name varchar,subject varchar,semester varchar)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists teacher");
        onCreate(sqLiteDatabase);
    }

    public void insertData(DataModel d) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("name",d.name);
        values.put("subject",d.subject);
        values.put("semester",d.semester);
        db.insert("teacher",null,values);

    }

    public ArrayList<DataModel> readData() {
        ArrayList<DataModel> data=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cr=db.rawQuery("Select * from teacher",null);
        if (cr.moveToFirst())
        {
            do {
                DataModel d=new DataModel();
                d.id=cr.getInt(0);
                d.name=cr.getString(1);
                d.subject=cr.getString(2);
                d.semester=cr.getString(3);
                data.add(d);
            }while (cr.moveToNext());
        }

        return data;

    }

    public void deletaData(int id) {
        SQLiteDatabase remove=this.getWritableDatabase();
        remove.execSQL("delete from teacher where id="+id);

    }

    public void updatedata(DataModel d) {
        SQLiteDatabase fill=this.getWritableDatabase();
        ContentValues content=new ContentValues();
        content.put("Name",d.name);
        content.put("subject",d.subject);
        content.put("semester",d.semester);
        fill.update("teacher",content,"id="+d.id,null);


    }
}

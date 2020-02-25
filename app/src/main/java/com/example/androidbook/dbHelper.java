package com.example.androidbook;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class dbHelper   extends SQLiteOpenHelper {
     public   static final String dbname="storeStory.db";
    public   static final int version=1;
    public  static final String tableName="storyList";

    public dbHelper( Context context) {
        super(context, dbname, null,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

            db.execSQL("CREATE TABLE "+tableName+"(ID INTEGER PRIMARY KEY AUTOINCREMENT, TITLE TEXT, DESCRIPTION TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+tableName);
        onCreate(db);
    }

    public  boolean AddStory(String title, String description){
        SQLiteDatabase mydb = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("TITLE",title);
        cv.put("DESCRIPTION",description);
        long rs = mydb.insert(tableName,null,cv);
        if(rs==-1){
            return  false;
        }else{
            return true;
        }

    }

}

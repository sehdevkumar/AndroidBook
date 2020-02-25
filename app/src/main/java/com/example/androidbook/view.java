package com.example.androidbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class view extends AppCompatActivity {
    dbHelper dbHelpers;
    TextView tittleviews, desviews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        tittleviews = findViewById(R.id.titleview);
        desviews  = findViewById(R.id.desview);

        dbHelpers = new dbHelper(this);
        Intent it  = getIntent();
        SQLiteDatabase mydbs =  dbHelpers.getReadableDatabase();
        Cursor cs = mydbs.rawQuery("SELECT * FROM storyList where ID ="+it.getStringExtra("id_item"),new String[]{});
        while(cs.moveToNext()){
            Toast.makeText(view.this, ""+cs.getString(2), Toast.LENGTH_SHORT).show();
        }

    }
}

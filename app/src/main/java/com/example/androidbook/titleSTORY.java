package com.example.androidbook;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class titleSTORY extends AppCompatActivity {
    ListView lv;
    dbHelper dph;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_story);
        final ArrayList<String> listitem1=new ArrayList<>();

        lv = findViewById(R.id.titleshow);
        dph = new dbHelper(this);

        SQLiteDatabase mydb = dph.getReadableDatabase();
        Cursor cs = mydb.rawQuery("select * from "+dbHelper.tableName,new String[]{});

        if(cs.getCount()==0){
            Toast.makeText(this, "No data Found!", Toast.LENGTH_SHORT).show();
        }else {


            while (cs.moveToNext()) {

                String title = cs.getString(0);
                listitem1.add(title);



            }

            ArrayAdapter arrayAdapter = new ArrayAdapter(com.example.androidbook.titleSTORY.this, android.R.layout.simple_list_item_1,listitem1);
            lv.setAdapter(arrayAdapter);

        }

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              ArrayList list2 = new ArrayList();
              list2.add(parent.getItemAtPosition(position));

              String itms = list2.get(0).toString();
              Intent it = new Intent(titleSTORY.this, com.example.androidbook.view.class);
              it.putExtra("id_item",itms);

                startActivity(it);

            }
        });

      Button add;
        add = findViewById(R.id.addStory);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  mainactivity = new Intent(titleSTORY.this,MainActivity.class);
                startActivity(mainactivity);
            }
        });

    }
}

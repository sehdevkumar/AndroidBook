package com.example.androidbook;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    dbHelper dph;
    Button add,update,clear;
    EditText story,title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button addback;
        addback = findViewById(R.id.showItem);
        addback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  mainactivity = new Intent(MainActivity.this,titleSTORY.class);
                startActivity(mainactivity);
            }
        });

        dph = new dbHelper(this);
        add = findViewById(R.id.add);
        update  =findViewById(R.id.update);
        clear = findViewById(R.id.clear);
        story = findViewById(R.id.story);
        title = findViewById(R.id.title);
        final AlertDialog.Builder ADB = new AlertDialog.Builder(this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean check = dph.AddStory(title.getText().toString(),story.getText().toString());
                if(check==true){
                    ADB.setCancelable(true);
                    ADB.setTitle("SUCCESSFUL");
                    ADB.setMessage("Story Has been Successfully Added.");
                    ADB.show();
                }else{
                    ADB.setCancelable(true);
                    ADB.setTitle("Warning");
                    ADB.setMessage("Story Not Added ,Due to some Technical Issue.");
                    ADB.show();
                }
            }
        });

    }
}

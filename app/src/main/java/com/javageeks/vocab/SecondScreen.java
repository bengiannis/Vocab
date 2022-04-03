package com.javageeks.vocab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class SecondScreen extends AppCompatActivity {
    ImageButton imageButton;
    ImageButton imageButton2;
    ImageButton imageButton3;
    ImageButton imageButton4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);
        imageButton=(ImageButton)findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j =  new Intent(SecondScreen.this,SearchActivity.class);
                j.putExtra("category", "Sports");
                startActivity(j);
            }
        });
        this.setTitle("Category List");
        imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k =  new Intent(SecondScreen.this,SearchActivity.class);
                k.putExtra("category", "Transportation");
                startActivity(k);
            }
        });
        imageButton3 =(ImageButton) findViewById(R.id.imageButton3);
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent l = new Intent(SecondScreen.this, SearchActivity.class);
                l.putExtra("category", "Summer");
                startActivity(l);
            }
        });
        imageButton4 = (ImageButton)findViewById(R.id.imageButton4);
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent h = new Intent(SecondScreen.this,SearchActivity.class);
                h.putExtra("category", "School Supplies");
                startActivity(h);
            }
        });
    }
}
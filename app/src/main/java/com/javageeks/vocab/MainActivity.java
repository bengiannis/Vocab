package com.javageeks.vocab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button StartButton;
    private WordOfTheDay wordOfTheDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StartButton=(Button)findViewById(R.id.StartButton);
        StartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(MainActivity.this,SecondScreen.class);
                startActivity(i);
            }
        });

        this.wordOfTheDay = new WordOfTheDay();
        ((TextView)findViewById(R.id.word)).setText(this.wordOfTheDay.getWord());
        ((TextView)findViewById(R.id.definition)).setText(this.wordOfTheDay.getDefinition());
    }
}
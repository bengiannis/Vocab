package com.javageeks.vocab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.Serializable;

public class SearchActivity extends AppCompatActivity implements Serializable {
    private Dictionary dictionary;
    private Autocorrect autocorrect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        String category = getIntent().getStringExtra("category");
        this.dictionary = new Dictionary(category);
        this.autocorrect = new Autocorrect(this.dictionary.getWords());


        ((Button)findViewById(R.id.searchButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText wordSearchBox = ((EditText)findViewById(R.id.wordSearchBox));
                if (autocorrect.contains(wordSearchBox.getText().toString())) {
                    ((TextView)findViewById(R.id.definitionTextView)).setText(dictionary.definitionOf(wordSearchBox.getText().toString()));
                }
                else {
                    String[] autocorrectResults = autocorrect.autocorrectWords(wordSearchBox.getText().toString());
                    if (autocorrectResults.length > 0) {
                        ((TextView)findViewById(R.id.didYouMean)).setText("Did you mean: ".concat(autocorrectResults[0]));
                        ((TextView)findViewById(R.id.definitionTextView)).setText("");
                    }
                }
            }
        });
    }
}
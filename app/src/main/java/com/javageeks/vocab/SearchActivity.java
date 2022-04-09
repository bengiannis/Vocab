package com.javageeks.vocab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.Collections;

public class SearchActivity extends AppCompatActivity implements Serializable {
    private Dictionary dictionary;
    private Autocorrect autocorrect;

    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        String category = getIntent().getStringExtra("category");
        this.setTitle(category);
        this.dictionary = new Dictionary(category);
        this.autocorrect = new Autocorrect(this.dictionary.getWords());

        ((EditText)findViewById(R.id.wordSearchBox)).setHint("Word");
        ((TextView)findViewById(R.id.didYouMean)).setText("");

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

        ((Button)findViewById(R.id.didYouMean)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText wordSearchBox = ((EditText)findViewById(R.id.wordSearchBox));
                String[] autocorrectResults = autocorrect.autocorrectWords(wordSearchBox.getText().toString());
                if (autocorrectResults.length > 0) {
                    wordSearchBox.setText(autocorrectResults[0]);
                    ((Button)findViewById(R.id.searchButton)).performClick();
                    ((TextView)findViewById(R.id.didYouMean)).setText("");
                }
            }
        });

        listView = (ListView)findViewById(R.id.listView);
        Dictionary list = new Dictionary(category);

        ArrayAdapter<String> adapt = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,(list.words));
        listView.setAdapter(adapt);

    }
}
package com.example.ourapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    //https://www.youtube.com/watch?v=KsprqXfugGQ
    String[] item = {"Brunch", "Coffeshop", "Club", "Bar", "Restaurant"};
    String[] item2 = {"Chill", "Casual", "High Class"};
    String[] item3 = {"Athens", "Thessaloniki", "Patra", "Ioannina", "Heraklion", "Volos"};
    String[] item4 = {"House", "Pop", "Hip-hop", "Lounge"};
    String[] item5 = {"18+", "25+", "40+", "Family friendly"};


    AutoCompleteTextView autoCompleteTextView;

    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        autoCompleteTextView = findViewById(R.id.autoComplete);
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_item, item);
        autoCompleteTextView.setAdapter(arrayAdapter);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(ThirdActivity.this, "item " + item, Toast.LENGTH_SHORT).show();
            }
        });

        autoCompleteTextView = findViewById(R.id.autoComplete2);
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_item, item2);
        autoCompleteTextView.setAdapter(arrayAdapter);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item2 = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(ThirdActivity.this, "item " + item2, Toast.LENGTH_SHORT).show();
            }
        });

        autoCompleteTextView = findViewById(R.id.autoComplete3);
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_item, item3);
        autoCompleteTextView.setAdapter(arrayAdapter);

        autoCompleteTextView = findViewById(R.id.autoComplete4);
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_item, item4);
        autoCompleteTextView.setAdapter(arrayAdapter);

        autoCompleteTextView = findViewById(R.id.autoComplete5);
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_item, item5);
        autoCompleteTextView.setAdapter(arrayAdapter);
    }
}
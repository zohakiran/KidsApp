package com.example.android.kidsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);


        TextView numbers = (TextView) findViewById(R.id.numbers);



        numbers.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(MainActivity.this, NumbersActivity.class);
                startActivity (numbersIntent);
            }

        });



        TextView family = (TextView) findViewById(R.id.family);



        family.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent familyIntent = new Intent(MainActivity.this, FamilyMembers.class);
                startActivity (familyIntent);
            }

        });
        TextView colors = (TextView) findViewById(R.id.colors);



        colors.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent colorsIntent = new Intent(MainActivity.this, ColorsActivity.class);
                startActivity (colorsIntent);
            }

        });
        TextView phrases = (TextView) findViewById(R.id.phrases);



        phrases.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent phrasesIntent = new Intent(MainActivity.this, PhrasesActivity.class);
                startActivity (phrasesIntent);
            }

        });
        TextView veges = (TextView) findViewById(R.id.veges);



        veges.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent vegesIntent = new Intent(MainActivity.this, VegetableActivity.class);
                startActivity (vegesIntent);
            }

        });
        TextView fruits = (TextView) findViewById(R.id.fruits);



        fruits.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent fruitsIntent = new Intent(MainActivity.this, FruitsActivity.class);
                startActivity (fruitsIntent);
            }

        });


    }
}


package com.example.android.kidsapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FruitsActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruits);

        // Create a list of words
        //here ArrayList<Word> words = new ArrayList<Word>(); ===Word is the custom class
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word( "Apple","سیب",R.drawable.m,R.raw.apple));
        words.add(new Word( "Banana","کیلا",R.drawable.banana,R.raw.kela));
        words.add(new Word( "Coconut","ناریل",R.drawable.coconut,R.raw.coconut));
        words.add(new Word("Grapes","انگور", R.drawable.grapes,R.raw.angoor));
        words.add(new Word( "Lime","نیبو",R.drawable.lime,R.raw.nibu));
        words.add(new Word( "Orange","مالٹا",R.drawable.orange,R.raw.malta));
        words.add(new Word( "Peach","آڑو" ,R.drawable.peach,R.raw.adu));
        words.add(new Word( "Pear","ناشپاتی",R.drawable.pear,R.raw.nashpati));
        words.add(new Word( "PineApple","انناس",R.drawable.pineapple,R.raw.pineapple));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, words,R.color.category_fruits);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_numbers.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Word} object at the given position the user clicked on
                Word word = words.get(position);
                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                mediaPlayer = MediaPlayer.create(FruitsActivity.this, word.getAudioResourceId());
                // Start the audio file
                mediaPlayer.start();
            }
        });

    }}

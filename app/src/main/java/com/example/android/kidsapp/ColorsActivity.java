package com.example.android.kidsapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        // Create a list of words
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word( "Black","سیاہ",R.drawable.color_black,R.raw.black));
        words.add(new Word( "Brown","براؤن",R.drawable.color_brown,R.raw.brown));
        words.add(new Word( "Blue","نیلا",R.drawable.bluee,R.raw.blue));
        words.add(new Word( "Gray","سرمئی",R.drawable.color_gray,R.raw.gray));
        words.add(new Word( "Green","سبز",R.drawable.color_green,R.raw.green));
        words.add(new Word("Yellow","پیلا", R.drawable.color_mustard_yellow,R.raw.yellow));
        words.add(new Word( "Red","سرخ",R.drawable.color_red,R.raw.red));
        words.add(new Word( "White","سفید",R.drawable.color_white,R.raw.white));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, words,R.color.category_colors);

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
                mediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getAudioResourceId());
                // Start the audio file
                mediaPlayer.start();
            }
        });
    }
}
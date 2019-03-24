package com.example.android.kidsapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        // Create a list of words
        //here ArrayList<Word> words = new ArrayList<Word>(); ===Word is the custom class
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("One.", "ایک",R.drawable.number_one,R.raw.one));
        words.add(new Word("Two", "دو",R.drawable.number_two,R.raw.two));
        words.add(new Word("Three", "تین",R.drawable.number_three,R.raw.three));
        words.add(new Word("Four", "چار",R.drawable.number_four,R.raw.four));
        words.add(new Word("Five", "پانچ",R.drawable.number_five,R.raw.five));
        words.add(new Word("Six", "چھ",R.drawable.number_six,R.raw.six));
        words.add(new Word("Seven", "سات",R.drawable.number_seven,R.raw.seven));
        words.add(new Word("Eight", "آٹھ",R.drawable.number_eight,R.raw.eight));
        words.add(new Word("Nine", "نو",R.drawable.number_nine,R.raw.nine));
        words.add(new Word("Ten", "دس" ,R.drawable.number_ten,R.raw.ten));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, words,R.color.category_numbers);

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
                mediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getAudioResourceId());
                // Start the audio file
                mediaPlayer.start();
            }
        });

    }}
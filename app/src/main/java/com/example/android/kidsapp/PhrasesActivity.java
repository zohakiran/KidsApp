package com.example.android.kidsapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

        // Create a list of words
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Where are you going?", "آپ کہاں جا رہے ہیں",R.raw.where_going));
        words.add(new Word("What is your name?", "آپ کا کیا نام ہے؟",R.raw.what_name));
        words.add(new Word("My name is...", "میرا نام ہے",R.raw.mra_naam));
        words.add(new Word("How are you feeling?", "آپ کیسا محسوس کر رہے ہیں؟",R.raw.mehsoos));
        words.add(new Word("I’m feeling good.", "میں اچھا محسوس کر رہا ہوں",R.raw.acha_mehsoos));
        words.add(new Word("Are you coming?", "کیا آپ آ رہے ہو؟",R.raw.are_i_coming));
        words.add(new Word("Yes, I’m coming.", "جی ہاں، میں آ رہا ہوں",R.raw.yes_imcoming));
        words.add(new Word("I’m coming." , "میں آرہا ہوں",R.raw.im_coming));
        words.add(new Word("Let’s go." ,  "چلو",R.raw.chalo));
        words.add(new Word("Come here" , "ادھر آو",R.raw.idhar_ao));
        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, words,R.color.category_phrases);

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
                mediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getAudioResourceId());
                // Start the audio file
                mediaPlayer.start();
            }
        });
    }
}
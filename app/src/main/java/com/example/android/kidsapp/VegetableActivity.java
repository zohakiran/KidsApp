package com.example.android.kidsapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class VegetableActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetable);

        // Create a list of words
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word( "Ginger","ادرک",R.drawable.ginger,R.raw.adrak));
        words.add(new Word( "Carrot","گاجر",R.drawable.ca,R.raw.gajar));
        words.add(new Word( "Corn","مکئ",R.drawable.co,R.raw.makai));
        words.add(new Word( "Cauliflower","گوبھی",R.drawable.cauli,R.raw.gobi));
        words.add(new Word("Cucumber","کھیرا ", R.drawable.cucum,R.raw.khera));
        words.add(new Word( "Cabbage","بند گوبھی",R.drawable.cab,R.raw.bandgobi));
        words.add(new Word( "Capsicum","شملہ مرچ" ,R.drawable.g,R.raw.shimla));
        words.add(new Word( "Mushroom", "مشروم",R.drawable.mush,R.raw.mushroom));
        words.add(new Word( "Onion","پیاز",R.drawable.on,R.raw.piyaz));
        words.add(new Word( "Tomato","ٹماٹر",R.drawable.tom,R.raw.tamatar));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, words,R.color.category_veges);

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
                mediaPlayer = MediaPlayer.create(VegetableActivity.this, word.getAudioResourceId());
                // Start the audio file
                mediaPlayer.start();
            }
        });
    }
}
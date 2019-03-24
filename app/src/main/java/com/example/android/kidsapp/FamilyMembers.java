package com.example.android.kidsapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyMembers extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_members);

        // Create a list of words
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Father", "ابا",R.drawable.family_father,R.raw.abba));
        words.add(new Word("Son", "بیٹا",R.drawable.family_son,R.raw.beta));
        words.add(new Word("Daughter", "بیٹی",R.drawable.family_daughter,R.raw.beti));
        words.add(new Word("Older Brother", "بڑا بھائی",R.drawable.family_older_brother,R.raw.bara_bhai));
        words.add(new Word("Younger Brother","چھوٹا بھائی",R.drawable.family_younger_brother,R.raw.chota_bhai));
        words.add(new Word("Older sister", "بڑی بہن",R.drawable.family_older_sister,R.raw.bari_bhn));
        words.add(new Word("Younger sister" , "چھوٹی بہن",R.drawable.family_younger_sister,R.raw.choti_bhn));
        words.add(new Word("GrandMother" , "دادی",R.drawable.family_grandmother,R.raw.dadi));
        words.add(new Word("GrandFather" , "دادا",R.drawable.family_grandfather,R.raw.dada));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, words,R.color.category_family);

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
                mediaPlayer = MediaPlayer.create(FamilyMembers.this, word.getAudioResourceId());
                // Start the audio file
                mediaPlayer.start();
            }
        });
    }

}


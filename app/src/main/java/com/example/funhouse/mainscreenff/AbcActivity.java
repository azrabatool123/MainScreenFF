package com.example.funhouse.mainscreenff;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AbcActivity extends AppCompatActivity {
MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abc);

        ImageView  learnAlphabets,learnWords,quizAbc,backbutton,abcExercise;
        learnAlphabets=(ImageView)findViewById(R.id.learnAlphabets);
        learnWords=(ImageView)findViewById(R.id.wordslearn);
        quizAbc=(ImageView)findViewById(R.id.abcHaveaQuiz);
        backbutton=(ImageView)findViewById(R.id.backbutton);
        abcExercise=(ImageView)findViewById(R.id.abc_exercise);



        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(AbcActivity.this,LetsLearn.class);
//                startActivity(intent);
                AbcActivity.super.onBackPressed();

                cleanup();
                mp=MediaPlayer.create(AbcActivity.this,R.raw.backnextbuttonsound);
                mp.start();

            }
        });
        abcExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dawingIntent = new Intent(AbcActivity.this, DrawingActivity.class);
                dawingIntent.putExtra("type", ResourcePool.DRAWING_ALPHABET);
                startActivity(dawingIntent);
                cleanup();
                mp=MediaPlayer.create(AbcActivity.this,R.raw.buttonclicksound);
                mp.start();
            }
        });

        learnAlphabets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(AbcActivity.this,LearnAlphabets.class);
                startActivity(intent);
                cleanup();
                mp=MediaPlayer.create(AbcActivity.this,R.raw.buttonclicksound);
                mp.start();
            }
        });
        learnWords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AbcActivity.this,LearnWords.class);
                startActivity(intent);
                cleanup();
                mp=MediaPlayer.create(AbcActivity.this,R.raw.buttonclicksound);
                mp.start();

            }
        });
        quizAbc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AbcActivity.this,QuizEnglish.class);
                startActivity(intent);
                cleanup();
                mp=MediaPlayer.create(AbcActivity.this,R.raw.buttonclicksound);
                mp.start();
            }
        });


    }


    @Override
    protected void onStop() {
        super.onStop();

        if (mp != null) {
            mp.stop();
            mp=null;
            cleanup();
        }
    }

    public void cleanup() {
        if (mp!= null && mp.isPlaying()) {
            mp.stop();
            mp.release();
            mp = null;
        }
    }
}

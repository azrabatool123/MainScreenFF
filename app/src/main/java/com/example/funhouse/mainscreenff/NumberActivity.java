package com.example.funhouse.mainscreenff;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class NumberActivity extends AppCompatActivity {
MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);

        ImageView learnNumbers,learnCounting,quizMath,backmain,numerExercise;
        learnNumbers =(ImageView)findViewById(R.id.LearnNumbers);
        learnCounting=(ImageView)findViewById(R.id.LearnCounting);
        quizMath=(ImageView)findViewById(R.id.QuizNumber);
        backmain   =(ImageView)findViewById(R.id.back);
        numerExercise=(ImageView)findViewById(R.id.number_exercise);


        numerExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dawingNumberIntent = new Intent(NumberActivity.this, DrawingActivity.class);
                dawingNumberIntent.putExtra("type", ResourcePool.NUMBER);
                startActivity(dawingNumberIntent);
                finish();
                cleanup();
                mp= MediaPlayer.create(NumberActivity.this,R.raw.buttonclicksound);
                mp.start();

            }
        });
backmain.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
//        Intent intent = new Intent(NumberActivity.this,LetsLearn.class);
//        startActivity(intent);
        NumberActivity.super.onBackPressed();
        finish();
        cleanup();
        mp= MediaPlayer.create(NumberActivity.this,R.raw.backnextbuttonsound);
        mp.start();
    }
});
        learnNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NumberActivity.this,LearnNumbers.class);
                startActivity(intent);
                cleanup();
                mp= MediaPlayer.create(NumberActivity.this,R.raw.buttonclicksound);
                mp.start();

            }
        });
        learnCounting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NumberActivity.this,LearnCounting.class);
                startActivity(intent);
                cleanup();
                mp= MediaPlayer.create(NumberActivity.this,R.raw.buttonclicksound);
                mp.start();
            }
        });
        quizMath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NumberActivity.this,MathQuiz.class);
                startActivity(intent);
                cleanup();
                mp= MediaPlayer.create(NumberActivity.this,R.raw.buttonclicksound);
                mp.start();
            }
        });




    }
    @Override
    protected void onStop() {
        super.onStop();

        if (mp != null) {
            mp.stop();
        }
    }
    public void cleanup() {
        if (mp != null && mp.isPlaying()) {
            mp.stop();
            mp.release();
            mp = null;
        }
    }

}

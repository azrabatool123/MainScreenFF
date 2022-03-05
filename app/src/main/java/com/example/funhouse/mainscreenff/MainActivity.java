package com.example.funhouse.mainscreenff;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView back, VegIntent,FruIntent,LearnDoodle
                ,learnShapes,LearnColors,AniIntent;

//        setting=(ImageView)findViewById(R.id.imageViewsSetting);
//        feedback=(ImageView)findViewById(R.id.imageViewfeedback);
//        share=(ImageView)findViewById(R.id.imageViewShare);
        VegIntent =(ImageView)findViewById(R.id.Vegetables_btn);
        FruIntent =(ImageView)findViewById(R.id.Fruits_btn);
        AniIntent =(ImageView)findViewById(R.id.Animals_btn);
        back=(ImageView)findViewById(R.id.backmain);
        learnShapes=(ImageView)findViewById(R.id.LearnShapes);
        LearnColors=(ImageView)findViewById(R.id.LearnColors);
        LearnDoodle=(ImageView)findViewById(R.id.learnDoodle);

        back.setOnClickListener(new View.OnClickListener() {




            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this,MainTwoSection.class);
//                startActivity(intent);
                finish();
               MainActivity.super.onBackPressed();
                cleanup();
                mp=MediaPlayer.create(MainActivity.this,R.raw.backnextbuttonsound);
                mp.start();

            }
        });
        LearnDoodle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,LearnDoodle.class);
                startActivity(intent);
                cleanup();
                mp=MediaPlayer.create(MainActivity.this,R.raw.buttonclicksound);
                mp.start();
            }
        });
        learnShapes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,LearnShape.class);
                startActivity(intent);
                cleanup();
                mp=MediaPlayer.create(MainActivity.this,R.raw.buttonclicksound);
                mp.start();
            }
        });
        LearnColors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,LearnColors.class);
                startActivity(intent);
                cleanup();
                mp=MediaPlayer.create(MainActivity.this,R.raw.buttonclicksound);
                mp.start();
            }
        });


        VegIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,LearnVegetables.class));
                cleanup();
                mp= MediaPlayer.create(MainActivity.this,R.raw.buttonclicksound);
                mp.start();
            }
        });
        FruIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,LearnFruits.class));
                cleanup();
                mp= MediaPlayer.create(MainActivity.this,R.raw.buttonclicksound);
                mp.start();
            }
        });
        AniIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Learn_Animals.class));
                cleanup();
                mp= MediaPlayer.create(MainActivity.this,R.raw.buttonclicksound);
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
        if (mp!= null && mp.isPlaying()) {
            mp.stop();
            mp.release();
            mp = null;
        }
    }

}

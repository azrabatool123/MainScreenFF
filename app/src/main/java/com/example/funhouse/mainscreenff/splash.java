package com.example.funhouse.mainscreenff;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class splash extends AppCompatActivity {
ImageView two,three,four;
    private static int SPLASH_TIME_OUT = 3000;
MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        two=(ImageView)findViewById(R.id.twos);
        three=(ImageView)findViewById(R.id.threes);
        four=(ImageView)findViewById(R.id.fours);
        test();
            new Handler().postDelayed(new Runnable() {


                @Override
                public void run() {
                    // This method will be executed once the timer is over
                    // Start your app main activity
                    Intent i = new Intent(splash.this, MainTwoSection.class);
                    startActivity(i);

                    // close this activity
                    finish();
                }
            }, SPLASH_TIME_OUT);


        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                two.setImageResource(R.drawable.baloon_blast);
                mediaPlayer = MediaPlayer.create(splash.this, R.raw.baloon_blast);
                mediaPlayer.start();
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                three.setImageResource(R.drawable.baloon_blast);
                mediaPlayer = MediaPlayer.create(splash.this, R.raw.baloon_blast);
                mediaPlayer.start();
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                four.setImageResource(R.drawable.baloon_blast);
                mediaPlayer = MediaPlayer.create(splash.this, R.raw.baloon_blast);
                mediaPlayer.start();
            }
        });


    }

    public void test(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                two.performClick();


            }
        }, 1000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                three.performClick();
                two.setVisibility(View.INVISIBLE);

            }
        }, 1500);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                four.performClick();
                three.setVisibility(View.INVISIBLE);

            }
        }, 2000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                four.setVisibility(View.INVISIBLE);

            }
        }, 2500);
    }
    protected void onStart() {
        super.onStart();

       mediaPlayer = MediaPlayer.create(splash.this,
                R.raw.welcome);
       mediaPlayer.start();
    }
}

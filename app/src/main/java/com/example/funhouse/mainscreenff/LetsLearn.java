package com.example.funhouse.mainscreenff;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class LetsLearn extends AppCompatActivity {
    ImageView abc,number,back;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lets_learn);
        abc=(ImageView)findViewById(R.id.ImageViewabc);
        back=(ImageView)findViewById(R.id.backletslearn);
        number=(ImageView)findViewById(R.id.imageViewNumbers);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(LetsLearn.this,MainTwoSection.class);
//                startActivity(intent);
                finish();
                LetsLearn.super.onBackPressed();
                cleanup();
                mp= MediaPlayer.create(LetsLearn.this,R.raw.backnextbuttonsound);
                mp.start();

            }


        });
        abc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LetsLearn.this,AbcActivity.class);
                startActivity(intent);
                cleanup();
                mp= MediaPlayer.create(LetsLearn.this,R.raw.buttonclicksound);
                mp.start();

            }


        });
        number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LetsLearn.this,NumberActivity.class);
                startActivity(intent);
                cleanup();
                mp= MediaPlayer.create(LetsLearn.this,R.raw.buttonclicksound);
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

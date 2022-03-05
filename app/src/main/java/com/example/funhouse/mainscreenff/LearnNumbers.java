package com.example.funhouse.mainscreenff;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class LearnNumbers extends AppCompatActivity {

    Handler gameThread = new Handler();
    Button one,two,three,four,five,six,seven,eight,nine,ten;
    private Animation shake;
    MediaPlayer mp;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        shake = AnimationUtils.loadAnimation(LearnNumbers.this,R.anim.shake_anim2);
        setContentView(R.layout.activity_learn_numbers);
        back =(ImageView)findViewById(R.id.bacllearnnumbers);
        typeCasting();
        setListener();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(LearnNumbers.this,NumberActivity.class);
//                startActivity(intent);
                LearnNumbers.super.onBackPressed();
                cleanup();
                finish();
                mp=MediaPlayer.create(LearnNumbers.this,R.raw.backnextbuttonsound);
                mp.start();
            }
        });

    }
    private void typeCasting()
    {

        one=(Button)findViewById(R.id.one);two=(Button)findViewById(R.id.two);
        three=(Button)findViewById(R.id.three);four=(Button)findViewById(R.id.four);
        five=(Button)findViewById(R.id.five);six=(Button)findViewById(R.id.six);
        seven=(Button)findViewById(R.id.seven);eight=(Button)findViewById(R.id.eight);
        nine=(Button)findViewById(R.id.nine);ten=(Button)findViewById(R.id.ten);
    }

    private void setListener()
    {


        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleanup();
                mp = MediaPlayer.create(LearnNumbers.this,R.raw.one);
                mp.start();
                one.startAnimation(shake);


            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleanup();
                mp = MediaPlayer.create(LearnNumbers.this,R.raw.two);
                mp.start();
                two.startAnimation(shake);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleanup();
                mp = MediaPlayer.create(LearnNumbers.this,R.raw.three);
                mp.start();
                three.startAnimation(shake);


            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleanup();
                mp = MediaPlayer.create(LearnNumbers.this,R.raw.four);
                mp.start();
                four.startAnimation(shake);

            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleanup();
                mp = MediaPlayer.create(LearnNumbers.this,R.raw.five);
                mp.start();
                five.startAnimation(shake);

            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleanup();
                mp = MediaPlayer.create(LearnNumbers.this,R.raw.six);
                mp.start();
                six.startAnimation(shake);

            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleanup();
                mp = MediaPlayer.create(LearnNumbers.this,R.raw.seven);
                mp.start();

                seven.startAnimation(shake);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleanup();
                mp = MediaPlayer.create(LearnNumbers.this,R.raw.eight);
                mp.start();
                eight.startAnimation(shake);

            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleanup();
                mp = MediaPlayer.create(LearnNumbers.this,R.raw.nine);
                mp.start();
                nine.startAnimation(shake);

            }
        });
        ten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleanup();
                mp = MediaPlayer.create(LearnNumbers.this,R.raw.ten);
                mp.start();
                ten.startAnimation(shake);

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

package com.example.funhouse.mainscreenff;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class LearnColors extends AppCompatActivity {
    ImageView blueImage,back, redImage, purpleImage,blackImage, yellowImage, brownImage, orangeImage,gryImage,pinkImage,greenImage,viewImage;
    TextView textView;
    MediaPlayer md;
    Animation scale,rotation;
    public   int audiocount=0;
    int[] audios = { R.raw.bluesound, R.raw.redsound, R.raw.purplesound,
            R.raw.blacksound, R.raw.yellowsound,R.raw.brownsound,R.raw.orangesound,R.raw.graysound,R.raw.pinksound,R.raw.greensound};


    int[] images = {R.drawable.bluestar, R.drawable.redstar, R.drawable.purplestar, R.drawable.blackstar, R.drawable.yellowstar, R.drawable.brownstar, R.drawable.orangestar, R.drawable.graystar, R.drawable.pinkstar, R.drawable.greenstar};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_colors);
        back = (ImageView) findViewById(R.id.back);
        blueImage = (ImageView) findViewById(R.id.blueImage);
        redImage = (ImageView) findViewById(R.id.redImage);
        purpleImage = (ImageView) findViewById(R.id.purpleImage);
        blackImage = (ImageView) findViewById(R.id.blackImage);
        yellowImage = (ImageView) findViewById(R.id.yellowImage);
        brownImage = (ImageView) findViewById(R.id.brownImage);
        orangeImage = (ImageView) findViewById(R.id.orangeImage);
        gryImage = (ImageView) findViewById(R.id.grayImage);
        pinkImage = (ImageView) findViewById(R.id.pinkImage);
        greenImage = (ImageView) findViewById(R.id.greenImage);
        viewImage = (ImageView) findViewById(R.id.viewImage);
        textView = (TextView) findViewById(R.id.textView);
        scale= AnimationUtils.loadAnimation(LearnColors.this,R.anim.scaling);
        rotation=AnimationUtils.loadAnimation(LearnColors.this,R.anim.rotate);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//Intent intent=new Intent(LearnColors.this,MainActivity.class);
//startActivity(intent);
                LearnColors.super.onBackPressed();
                finish();
                md=MediaPlayer.create(LearnColors.this,R.raw.backnextbuttonsound);
                md.start();
            }
        });
        viewImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewImage.setVisibility(View.VISIBLE);
                viewImage.startAnimation(rotation);
                md=MediaPlayer.create(LearnColors.this,R.raw.imageviewsound);
                md.start();
            }
        });

        blueImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                blueImage.setVisibility(View.VISIBLE);
                blueImage.startAnimation(scale);
                Picasso.with(LearnColors.this).load(images[0]).into(viewImage);
             //   viewImage.setImageResource(images[0]);
                textView.setText("Hi, I am a Blue");

                cleanup();
                md=MediaPlayer.create(LearnColors.this,R.raw.bluesound);
                md.start();
                if(audiocount>1){
                    audiocount=0;
                }
            }
        });


        redImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                redImage.setVisibility(View.VISIBLE);
                redImage.startAnimation(scale);
                Picasso.with(LearnColors.this).load(images[1]).into(viewImage);
              //  viewImage.setImageResource(images[1]);
                textView.setText("Hi, I am a Red");

                cleanup();
                md=MediaPlayer.create(LearnColors.this,R.raw.redsound);
                md.start();
            }
        });

        purpleImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                purpleImage.setVisibility(View.VISIBLE);
                purpleImage.startAnimation(scale);
                Picasso.with(LearnColors.this).load(images[2]).into(viewImage);
             //   viewImage.setImageResource(images[2]);
                textView.setText("Hi, I am a Purple");
                cleanup();
                md=MediaPlayer.create(LearnColors.this,R.raw.purplesound);
                md.start();
            }
        });

        blackImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                blackImage.setVisibility(View.VISIBLE);
                blackImage.startAnimation(scale);
                Picasso.with(LearnColors.this).load(images[3]).into(viewImage);
            //    viewImage.setImageResource(images[3]);
                textView.setText("Hi, I am a Black");
                cleanup();
                md=MediaPlayer.create(LearnColors.this,R.raw.blacksound);
                md.start();
            }
        });
        yellowImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                yellowImage.setVisibility(View.VISIBLE);
                yellowImage.startAnimation(scale);
                Picasso.with(LearnColors.this).load(images[4]).into(viewImage);
             //   viewImage.setImageResource(images[4]);
                textView.setText("Hi, I am a Yellow");
                cleanup();
                md=MediaPlayer.create(LearnColors.this,R.raw.yellowsound);
                md.start();
            }
        });

        brownImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                brownImage.setVisibility(View.VISIBLE);
                brownImage.startAnimation(scale);
                Picasso.with(LearnColors.this).load(images[5]).into(viewImage);
            //    viewImage.setImageResource(images[5]);
                textView.setText("Hi, I am a Brown");
                cleanup();
                md=MediaPlayer.create(LearnColors.this,R.raw.brownsound);
                md.start();
            }
        });

        orangeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                orangeImage.setVisibility(View.VISIBLE);
                orangeImage.startAnimation(scale);
                Picasso.with(LearnColors.this).load(images[6]).into(viewImage);
             //   viewImage.setImageResource(images[6]);
                textView.setText("Hi, I am a Orange");
                cleanup();
                md=MediaPlayer.create(LearnColors.this,R.raw.orangesound);
                md.start();
            }
        });
        gryImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                gryImage.setVisibility(View.VISIBLE);
                gryImage.startAnimation(scale);
                Picasso.with(LearnColors.this).load(images[7]).into(viewImage);
              //  viewImage.setImageResource(images[7]);
                textView.setText("Hi, I am a Gray");
                cleanup();
                md=MediaPlayer.create(LearnColors.this,R.raw.graysound);
                md.start();
            }
        });
        pinkImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pinkImage.setVisibility(View.VISIBLE);
                pinkImage.startAnimation(scale);
                Picasso.with(LearnColors.this).load(images[8]).into(viewImage);
              //  viewImage.setImageResource(images[8]);
                textView.setText("Hi, I am a Pink");
                cleanup();
                md=MediaPlayer.create(LearnColors.this,R.raw.pinksound);
                md.start();
            }
        });
        greenImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                greenImage.setVisibility(View.VISIBLE);
                greenImage.startAnimation(scale);
                Picasso.with(LearnColors.this).load(images[9]).into(viewImage);
              //  viewImage.setImageResource(images[9]);
                textView.setText("Hi, I am a Green");
                cleanup();
                md=MediaPlayer.create(LearnColors.this,R.raw.greensound);
                md.start();
            }
        });

    }
    public void cleanup() {
        if (md!= null && md.isPlaying()) {
            md.stop();
            md.release();
            md = null;
        }}
    @Override
    protected void onStop() {
        super.onStop();

        if (md != null) {
            md.stop();
        }
    }

//    @Override
//    protected void onRestart() {
//        super.onRestart();
//
//        if (!md.isPlaying()) {
//            if (md != null) {
//                md.start();
//            }
//        }
//    }

}

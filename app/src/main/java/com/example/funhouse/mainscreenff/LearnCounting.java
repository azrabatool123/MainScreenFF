package com.example.funhouse.mainscreenff;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

public class LearnCounting extends AppCompatActivity {

    int i = 1;
    private ImageView iv,back;
    ImageButton next;
    ImageButton previous;
    MediaPlayer ourSong,mp;
    private int currentImage = 0;
    public int currentAudio = 0;
    private int txtcount = 0;
    Animation rotatedata, scale;
    private ImageView ivtxt;
    private  int countfirst=0;
    int[] txtimage = {R.drawable.onetxt, R.drawable.twotxt, R.drawable.threetxt,
            R.drawable.fourtxt, R.drawable.fivetxt, R.drawable.sixtxt, R.drawable.seventxt, R.drawable.eighttxt, R.drawable.ninetxt, R.drawable.tentxt};
    int[] images = {R.drawable.lcone, R.drawable.lctwo, R.drawable.lcthree,
            R.drawable.lcfour, R.drawable.lcfive, R.drawable.lcsix, R.drawable.lcseven,
            R.drawable.lceight, R.drawable.lcnine, R.drawable.lcten};
    int[] audios = {R.raw.one ,R.raw.two, R.raw.three,
            R.raw.four, R.raw.five, R.raw.six, R.raw.seven, R.raw.eight, R.raw.nine, R.raw.ten};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_counting);
        ivtxt = (ImageView) findViewById(R.id.ivntxt);
        back=(ImageView)findViewById(R.id.backlearncounting);
        iv = (ImageView) findViewById(R.id.ivn);
        next = (ImageButton) findViewById(R.id.buttonn);
        previous = (ImageButton) findViewById(R.id.buttonp);
        next.setOnClickListener(iButtonChangeImageListener);
        previous.setOnClickListener(gButtonChangeImageListener);
        rotatedata = AnimationUtils.loadAnimation(LearnCounting.this, R.anim.rotate);
        scale = AnimationUtils.loadAnimation(LearnCounting.this, R.anim.scaling);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(LearnCounting.this,NumberActivity.class);
//                startActivity(intent);
                LearnCounting.super.onBackPressed();
                finish();
                cleanup();
                mp=MediaPlayer.create(LearnCounting.this,R.raw.backnextbuttonsound);
                mp.start();
            }
        });
        ivtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivtxt.setVisibility(View.VISIBLE);
                ivtxt.startAnimation(rotatedata);
                ourSong = MediaPlayer.create(LearnCounting.this, audios[currentAudio]);
                ourSong.start();
            }
        });


        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv.setVisibility(View.VISIBLE);
                iv.startAnimation(rotatedata);
                ourSong = MediaPlayer.create(LearnCounting.this, audios[currentAudio]);
                ourSong.start();
            }
        });
    }


    View.OnClickListener iButtonChangeImageListener = new View.OnClickListener() {

        public void onClick(View v) {
            try {
                // Increase Counter to move to next Image
                iv.setVisibility(View.VISIBLE);
                iv.startAnimation(scale);
                ivtxt.setVisibility(View.VISIBLE);
                ivtxt.startAnimation(scale);

                if (currentImage < images.length - 1) {
                    currentImage++;
                    iv.setImageResource(images[currentImage]);
                    txtcount++;
                    ivtxt.setImageResource(txtimage[txtcount]);
                    cleanup();
                    currentAudio++;
                    ourSong = MediaPlayer.create(LearnCounting.this, audios[currentAudio]);
                    ourSong.start();
                    if (currentImage == images.length - 1) {
                        next.setEnabled(false);
                    }
                    if (currentImage > 0) {
                        previous.setEnabled(true);
                    }
                }

            } catch (Exception e) {

            }

        }
    };


    View.OnClickListener gButtonChangeImageListener = new View.OnClickListener() {

        public void onClick(View v) {
            try {
                // Increase Counter to move to next Image
                iv.setVisibility(View.VISIBLE);
                iv.startAnimation(scale);
                ivtxt.setVisibility(View.VISIBLE);
                ivtxt.startAnimation(scale);

                if (currentImage > 0) {
                    currentImage--;
                    iv.setImageResource(images[currentImage]);
                    txtcount--;
                    ivtxt.setImageResource(txtimage[txtcount]);
                    cleanup();
                    currentAudio--;
                    ourSong = MediaPlayer.create(LearnCounting.this, audios[currentAudio]);
                    ourSong.start();
                    if (currentImage < images.length - 1) {
                        next.setEnabled(true);
                    }
                    if (currentImage == 0) {
                        previous.setEnabled(false);
                    }
                }

            } catch (Exception e) {

            }
        }
    };


    @Override
    protected void onStart() {
        super.onStart();
        if(countfirst==0){
            currentImage = (currentImage + images.length) % images.length;
            iv.setImageResource(images[currentImage]);
            txtcount = txtcount % txtimage.length;
            ivtxt.setImageResource(txtimage[txtcount]);

            ourSong = MediaPlayer.create(LearnCounting.this,audios[currentAudio]);
            ourSong.start();
        }

        else{
            ourSong = MediaPlayer.create(LearnCounting.this, audios[currentAudio]);
            ourSong.start();
        }
    }

    public void cleanup() {
        if (ourSong != null && ourSong.isPlaying()) {
            ourSong.stop();
            ourSong.release();
            ourSong = null;
        }
    }
    @Override
    protected void onStop() {
        super.onStop();

        if (ourSong != null) {
            ourSong.stop();
        }
    }



}

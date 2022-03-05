package com.example.funhouse.mainscreenff;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class LearnVegetables extends AppCompatActivity {
    int i = 1;
    private ImageView iv,back;
    ImageButton next;
    ImageButton previous;
    MediaPlayer ourSong;
    private int currentImage = 0;
    public int currentAudio = 0;
    int countfirstsound=0;
    private  int  txtcount=0;
    Animation rotatedata,scale;
    private ImageView ivtxt;
    int[] txtimage={R.drawable.oniontxt,R.drawable.tomatotxt,R.drawable.potatotxt,
            R.drawable.cauliflowertxt,R.drawable.beettxt,R.drawable.carrottxt,R.drawable.gingertxt,R.drawable.broccolitxt,R.drawable.peastxt,R.drawable.garlictxt,R.drawable.pumpkintxt,R.drawable.mushroomtxt,R.drawable.lattucetxt,R.drawable.okratxt,R.drawable.corntxt,R.drawable.cucumbertxt,R.drawable.chillipapertxt};
    int[] images = { R.drawable.onion, R.drawable.tomato, R.drawable.potato,
            R.drawable.kauliflower, R.drawable.beet,R.drawable.carrot,R.drawable.gingerrrot,
            R.drawable.broccoli,R.drawable.peas,R.drawable.garlic,R.drawable.pumpkin,
            R.drawable.mushroom,R.drawable.lattuce,R.drawable.ladyfinger,R.drawable.corn,R.drawable.cocumber,R.drawable.chilli};
    int[] audios = { R.raw.onion, R.raw.tomato, R.raw.potato,
            R.raw.cauliflower, R.raw.beet,R.raw.carrot,R.raw.gingerroot,R.raw.broccoli,R.raw.peas,R.raw.garlic,
            R.raw.pupmkin,R.raw.mushrooms,R.raw.lattuce,R.raw.okra,R.raw.corn,R.raw.cucumber,R.raw.chillipaperred};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_vegetables);
      back=(ImageView)findViewById(R.id.backlearnvegitable);
        ivtxt=(ImageView) findViewById(R.id.ivntxt);
        iv = (ImageView) findViewById(R.id.ivn);
        next = (ImageButton) findViewById(R.id.buttonn);
        previous = (ImageButton) findViewById(R.id.buttonp);
        next.setOnClickListener(iButtonChangeImageListener);
        previous.setOnClickListener(gButtonChangeImageListener);
        rotatedata= AnimationUtils.loadAnimation(LearnVegetables.this,R.anim.rotate);
        scale= AnimationUtils.loadAnimation(LearnVegetables.this,R.anim.scaling);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(LearnVegetables.this,MainActivity.class);
//                startActivity(intent);
                LearnVegetables.super.onBackPressed();
                finish();
                cleanup();
                ourSong=MediaPlayer.create(LearnVegetables.this,R.raw.backnextbuttonsound);
                ourSong.start();
            }
        });


        ivtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivtxt.setVisibility(View.VISIBLE);
                ivtxt.startAnimation(rotatedata);
                cleanup();
                ourSong = MediaPlayer.create(LearnVegetables.this, audios[currentAudio]);
                ourSong.start();
            }
        });



        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv.setVisibility(View.VISIBLE);
                iv.startAnimation(rotatedata);
                cleanup();
                ourSong = MediaPlayer.create(LearnVegetables.this, audios[currentAudio]);
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

                if(currentImage < images.length - 1) {
                    currentImage++;
                    Picasso.with(LearnVegetables.this).load(images[currentImage]).into(iv);
                 //   iv.setImageResource(images[currentImage]);
                    txtcount++;
                    ivtxt.setImageResource(txtimage[txtcount]);
                    cleanup();
                    currentAudio++;
                    ourSong = MediaPlayer.create(LearnVegetables.this, audios[currentAudio]);
                    ourSong.start();
                    if(currentImage == images.length - 1){
                        next.setEnabled(false);
                    }
                    if(currentImage > 0){
                        previous.setEnabled(true);
                    }
                }

            } catch (Exception e) {

            }

        }
    };


    View.OnClickListener gButtonChangeImageListener = new View.OnClickListener()    {

        public void onClick(View v) {
            try {
                // Increase Counter to move to next Image
                iv.setVisibility(View.VISIBLE);
                iv.startAnimation(scale);
                ivtxt.setVisibility(View.VISIBLE);
                ivtxt.startAnimation(scale);

                if(currentImage > 0) {
                    currentImage--;
                    Picasso.with(LearnVegetables.this).load(images[currentImage]).into(iv);
                   // iv.setImageResource(images[currentImage]);
                    txtcount--;
                    ivtxt.setImageResource(txtimage[txtcount]);
                    cleanup();
                    currentAudio--;
                    ourSong = MediaPlayer.create(LearnVegetables.this, audios[currentAudio]);
                    ourSong.start();
                    if(currentImage < images.length - 1){
                        next.setEnabled(true);
                    }
                    if(currentImage == 0){
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
        if(countfirstsound==0) {
            countfirstsound++;

            currentImage = (currentImage + images.length) % images.length;
            iv.setImageResource(images[currentImage]);
            txtcount = txtcount % txtimage.length;
            ivtxt.setImageResource(txtimage[txtcount]);

            ourSong = MediaPlayer.create(LearnVegetables.this,
                    audios[0]);
            ourSong.start();
        }
        else{
            cleanup();
            ourSong = MediaPlayer.create(LearnVegetables.this, audios[currentAudio]);
            ourSong.start();
        }
    }
    public void cleanup() {
        if (ourSong!= null && ourSong.isPlaying()) {
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

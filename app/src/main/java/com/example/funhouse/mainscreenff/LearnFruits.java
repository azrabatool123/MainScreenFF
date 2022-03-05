package com.example.funhouse.mainscreenff;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class LearnFruits extends AppCompatActivity {
    int i = 1;
    private ImageView iv;
    ImageView back;
    ImageView next;
    ImageView previous;
    MediaPlayer ourSong,mp;
    private int currentImage = 0;
    public int currentAudio = 0;
    private int countsounddata=0;
    private  int  txtcount=0;
    Animation rotatedata,scale;
    private ImageView ivtxt;
    int[] txtimage={R.drawable.lftxt1,R.drawable.lftxt2,R.drawable.lftxt3,R.drawable.lftxt4,R.drawable.lftxt5,
            R.drawable.lftxt6,R.drawable.lftxt7,R.drawable.lftxt8,R.drawable.lftxt9,R.drawable.lftxt10,
            R.drawable.lftxt11,R.drawable.lftxt12,R.drawable.lfblackberrytxt15,R.drawable.lfblueberrytxt16,
            R.drawable.lftxt13,R.drawable.lftxt14,R.drawable.lftxt19,R.drawable.lftxt16,R.drawable.lftxt15,
            R.drawable.lftxt17,R.drawable.lftxt18,R.drawable.lffig20};
    int[] images = { R.drawable.fruit1, R.drawable.fruit2, R.drawable.fruit3,
            R.drawable.fruit4, R.drawable.fruit6,R.drawable.fruit8,R.drawable.fruit9,
            R.drawable.fruit10,R.drawable.fruit11,R.drawable.fruit12,R.drawable.fruit13,
            R.drawable.fruit14,R.drawable.blackberry15,R.drawable.blueberry16,
            R.drawable.fruit17,R.drawable.fruit18,R.drawable.plum20,R.drawable.kiwi21,
            R.drawable.fruit22,R.drawable.melon,R.drawable.passionfruit,R.drawable.fig};
    int[] audios = { R.raw.apple, R.raw.strawberry, R.raw.orange,
            R.raw.guava, R.raw.lemon,R.raw.mango,R.raw.pear,R.raw.banana,R.raw.grapes,R.raw.watermelon,R.raw.cherry,R.raw.apricot,R.raw.blackberry,R.raw.blueberry,R.raw.pomegranate,R.raw.lime,R.raw.plum,R.raw.kiwi,R.raw.pomelo,R.raw.melon,R.raw.passionfruit,R.raw.fig};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_learn_fruits);
        ivtxt=(ImageView) findViewById(R.id.ivntxt);
        iv = (ImageView) findViewById(R.id.ivn);
        back=(ImageView)  findViewById(R.id.back);
        next = (ImageView) findViewById(R.id.buttonn);
        previous = (ImageView) findViewById(R.id.buttonp);
        next.setOnClickListener(iButtonChangeImageListener);
        previous.setOnClickListener(gButtonChangeImageListener);
        rotatedata= AnimationUtils.loadAnimation(LearnFruits.this,R.anim.rotate);
        scale= AnimationUtils.loadAnimation(LearnFruits.this,R.anim.scaling);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent=new Intent(LearnFruits.this,MainActivity.class);
//                startActivity(intent);
                LearnFruits.super.onBackPressed();
                finish();
             mp=MediaPlayer.create(LearnFruits.this,R.raw.backnextbuttonsound);
                mp.start();
            }
        });


        ivtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivtxt.setVisibility(View.VISIBLE);
                ivtxt.startAnimation(rotatedata);
                cleanup();//extra
                ourSong = MediaPlayer.create(LearnFruits.this, audios[currentAudio]);
                ourSong.start();
            }
        });



        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv.setVisibility(View.VISIBLE);
                iv.startAnimation(rotatedata);
                cleanup();//extra
                ourSong = MediaPlayer.create(LearnFruits.this, audios[currentAudio]);
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
                    iv.setImageResource(images[currentImage]);
                    txtcount++;
                    ivtxt.setImageResource(txtimage[txtcount]);
                    cleanup();
                    currentAudio++;
                    ourSong = MediaPlayer.create(LearnFruits.this, audios[currentAudio]);
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
                    Picasso.with(LearnFruits.this).load(images[currentImage]).into(iv);
                  //  iv.setImageResource(images[currentImage]);
                    txtcount--;
                    ivtxt.setImageResource(txtimage[txtcount]);
                    cleanup();
                    currentAudio--;
                    ourSong = MediaPlayer.create(LearnFruits.this, audios[currentAudio]);
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
        if(countsounddata==0) {
            countsounddata++;
            currentImage = (currentImage + images.length) % images.length;
            Picasso.with(LearnFruits.this).load(images[currentImage]).into(iv);
            // iv.setImageResource(images[currentImage]);
            txtcount = txtcount % txtimage.length;
            ivtxt.setImageResource(txtimage[txtcount]);

            ourSong = MediaPlayer.create(LearnFruits.this,
                    audios[0]);
            ourSong.start();
        }
        else {
            cleanup();

            ourSong = MediaPlayer.create(LearnFruits.this, audios[currentAudio]);
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

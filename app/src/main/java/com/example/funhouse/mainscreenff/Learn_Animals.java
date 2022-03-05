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

public class Learn_Animals extends AppCompatActivity {

    int i = 1;
    private ImageView iv;
    ImageButton next;
    ImageButton previous;
    MediaPlayer ourSong;
    private int currentImage = 0;
    public int currentAudio = 0;
    private int  txtcount=0;
    int countfirstsound=0;
    Animation rotatedata,scale;
    private ImageView ivtxt;
    int[] txtimage={R.drawable.txt1,R.drawable.txt5,R.drawable.txt41,R.drawable.txt6,R.drawable.txt7,R.drawable.txt12,R.drawable.txt13,R.drawable.txt14,R.drawable.txt17,R.drawable.txt19,R.drawable.txt21,R.drawable.txt22,R.drawable.txt23,R.drawable.txt24,R.drawable.txt26,R.drawable.txt27,R.drawable.txt31,R.drawable.txt33,R.drawable.txt35,R.drawable.txt37,R.drawable.txt38,R.drawable.txt39,R.drawable.txt40};
    int[] images = { R.drawable.animal1,
            R.drawable.animal5,R.drawable.animal6,R.drawable.animal7,R.drawable.animal8,R.drawable.animal12,R.drawable.animal13,R.drawable.animal14,R.drawable.animal17,R.drawable.animal19,R.drawable.animal21,R.drawable.animal22,R.drawable.animal23,R.drawable.animal24,R.drawable.animal26,R.drawable.animal27,R.drawable.animal31,R.drawable.animal33,R.drawable.animal35,R.drawable.animal37,R.drawable.animal36,R.drawable.animal9,R.drawable.animal15};
    int[] audios = { R.raw.elephant,  R.raw.camel,R.raw.cat,
            R.raw.gorilla,R.raw.cow,R.raw.donkey,R.raw.goat,R.raw.horse,R.raw.lion,R.raw.fox,R.raw.rhinoceros,R.raw.tiger,R.raw.dog,R.raw.zebra,R.raw.giraffe,R.raw.polarbeer,R.raw.rabbit,R.raw.monkey,R.raw.buffalo,R.raw.snake,R.raw.ostrich,R.raw.crocodile,R.raw.mouse};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn__animals);
        ivtxt=(ImageView) findViewById(R.id.ivntxt);
        iv = (ImageView) findViewById(R.id.ivn);
        next = (ImageButton) findViewById(R.id.buttonn);
        previous = (ImageButton) findViewById(R.id.buttonp);
        next.setOnClickListener(iButtonChangeImageListener);
        previous.setOnClickListener(gButtonChangeImageListener);
        rotatedata= AnimationUtils.loadAnimation(Learn_Animals.this,R.anim.rotate);
        scale=AnimationUtils.loadAnimation(Learn_Animals.this,R.anim.scaling);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv.setVisibility(View.VISIBLE);
                iv.startAnimation(rotatedata);
                ourSong = MediaPlayer.create(Learn_Animals.this, audios[currentAudio]);
                ourSong.start();

            }
        });
        ivtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivtxt.setVisibility(View.VISIBLE);
                ivtxt.startAnimation(rotatedata);
                ourSong = MediaPlayer.create(Learn_Animals.this, audios[currentAudio]);
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
                ivtxt.startAnimation(scale);
                if(currentImage < images.length - 1) {
                    currentImage++;
                    Picasso.with(Learn_Animals.this).load(images[currentImage]).into(iv);

               //     iv.setImageResource(images[currentImage]);
                    txtcount++;
                    ivtxt.setImageResource(txtimage[txtcount]);
                    cleanup();
                    currentAudio++;
                    ourSong = MediaPlayer.create(Learn_Animals.this, audios[currentAudio]);
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


    View.OnClickListener gButtonChangeImageListener = new View.OnClickListener() {

        public void onClick(View v) {
            try {
                // Increase Counter to move to next Image
                iv.setVisibility(View.VISIBLE);
                iv.startAnimation(scale);
                ivtxt.setVisibility(View.VISIBLE);
                ivtxt.startAnimation(scale);

                if(currentImage > 0) {
                    currentImage--;
                 //   iv.setImageResource(images[currentImage]);
                    Picasso.with(Learn_Animals.this).load(images[currentImage]).into(iv);
                    txtcount--;
                    ivtxt.setImageResource(txtimage[txtcount]);
                    cleanup();
                    currentAudio--;
                    ourSong = MediaPlayer.create(Learn_Animals.this, audios[currentAudio]);
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
        if(countfirstsound==0){
            countfirstsound++;
        currentImage = (currentImage + images.length) % images.length;
     //   iv.setImageResource(images[currentImage]);
            Picasso.with(Learn_Animals.this).load(images[currentImage]).into(iv);
        txtcount=txtcount%txtimage.length;
        ivtxt.setImageResource(txtimage[txtcount]);
            cleanup();//extra
        ourSong = MediaPlayer.create(Learn_Animals.this,
                audios[currentAudio]);
        ourSong.start();
    }
    else {
            cleanup();//extra
            ourSong = MediaPlayer.create(Learn_Animals.this,
                    audios[currentAudio]);

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
public void tryagainanimal(View view){
//    Intent intent= new Intent(Learn_Animals.this,MainActivity.class);
//    startActivity(intent);
   Learn_Animals.super.onBackPressed();
    finish();
    cleanup();
    ourSong=MediaPlayer.create(Learn_Animals.this,R.raw.backnextbuttonsound);
    ourSong.start();


}
}
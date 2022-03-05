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


public class LearnShape extends AppCompatActivity implements View.OnClickListener {
    MediaPlayer mp;
    ImageView circleImage, rectImage, triImage, squareImage, setImage, pentaImage, starimage, heartimage, ovalImage,back;
    TextView textView;
    Animation fadeindata1,fadeindata2,fadeindata3,fadeindata4,fadeindata5,fadeindata6,fadeindata7,fadeindata8;
    Animation fadeoutdata,bouncedata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_shape);
        circleImage = (ImageView) findViewById(R.id.circleImage);
        squareImage = (ImageView) findViewById(R.id.squreImage);
        triImage = (ImageView) findViewById(R.id.triImage);
        rectImage = (ImageView) findViewById(R.id.rectImage);
        setImage = (ImageView) findViewById(R.id.setImage);
        pentaImage = (ImageView) findViewById(R.id.pentaImage);
        starimage = (ImageView) findViewById(R.id.starimage);
        ovalImage = (ImageView) findViewById(R.id.ovalImage);
        heartimage  = (ImageView) findViewById(R.id.heartimage);
        back=(ImageView)findViewById(R.id.backbuttonshapes);
        textView = (TextView) findViewById(R.id.textView);
        fadeindata1= AnimationUtils.loadAnimation(LearnShape.this,R.anim.fadein);
        fadeindata2= AnimationUtils.loadAnimation(LearnShape.this,R.anim.fadein);
        fadeindata3= AnimationUtils.loadAnimation(LearnShape.this,R.anim.fadein);
        fadeindata4= AnimationUtils.loadAnimation(LearnShape.this,R.anim.fadein);
        fadeindata5= AnimationUtils.loadAnimation(LearnShape.this,R.anim.fadein);
        fadeindata6= AnimationUtils.loadAnimation(LearnShape.this,R.anim.fadein);
        fadeindata7= AnimationUtils.loadAnimation(LearnShape.this,R.anim.fadein);
        fadeindata8= AnimationUtils.loadAnimation(LearnShape.this,R.anim.fadein);
       bouncedata = AnimationUtils.loadAnimation(LearnShape.this,R.anim.bounce);

        fadeoutdata=AnimationUtils.loadAnimation(LearnShape.this,R.anim.fadeoutdata);
        circleImage.setOnClickListener(this);
        squareImage.setOnClickListener(this);
        triImage.setOnClickListener(this);
        rectImage.setOnClickListener(this);
        pentaImage.setOnClickListener(this);
        ovalImage.setOnClickListener(this);
        starimage.setOnClickListener(this);
        heartimage.setOnClickListener(this);
        textView.setOnClickListener(this);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent= new Intent(LearnShape.this,MainActivity.class);
//                startActivity(intent);
                LearnShape.super.onBackPressed();
                finish();
                cleanup();
                mp=MediaPlayer.create(LearnShape.this,R.raw.backnextbuttonsound);
                mp.start();

            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setVisibility(View.VISIBLE);
                textView.startAnimation(bouncedata);
                cleanup();
                mp = MediaPlayer.create(LearnShape.this, R.raw.random_comical);
                mp.start();
            }
        });
        setImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setImage.setVisibility(View.VISIBLE);
                setImage.startAnimation(bouncedata);
                cleanup();
                mp = MediaPlayer.create(LearnShape.this, R.raw.random_comical);
                mp.start();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.circleImage:
                circleImage.setVisibility(view.VISIBLE);
                circleImage.startAnimation(fadeindata1);
                cleanup();
                mp=MediaPlayer.create(LearnShape.this,R.raw.circle1);
                mp.start();
                Picasso.with(LearnShape.this).load(R.drawable.circle).into(setImage);
               // setImage.setImageResource(R.drawable.circle);
                textView.setText("Hi, I am a circle");
                textView.setVisibility(view.VISIBLE);
                textView.startAnimation(fadeoutdata);
                break;

            case R.id.squreImage:
                squareImage.setVisibility(view.VISIBLE);
                squareImage.startAnimation(fadeindata2);
                cleanup();
                mp=MediaPlayer.create(LearnShape.this,R.raw.sequare3);
                mp.start();
                Picasso.with(LearnShape.this).load(R.drawable.square).into(setImage);
               // setImage.setImageResource(R.drawable.square);
                textView.setText("Hi, I am a Square");
                break;

            case R.id.triImage:
                triImage.setVisibility(view.VISIBLE);
                triImage.startAnimation(fadeindata3);
                cleanup();
                mp=MediaPlayer.create(LearnShape.this,R.raw.triangle5);
                mp.start();
                Picasso.with(LearnShape.this).load(R.drawable.tri).into(setImage);
               // setImage.setImageResource(R.drawable.tri);
                textView.setText("Hi, I am a Triangle");
                break;

            case R.id.rectImage:
                rectImage.setVisibility(view.VISIBLE);
                rectImage.startAnimation(fadeindata4);
                cleanup();
                mp=MediaPlayer.create(LearnShape.this,R.raw.rectangle2);
                mp.start();
                Picasso.with(LearnShape.this).load(R.drawable.rec).into(setImage);
               // setImage.setImageResource(R.drawable.rec);
                textView.setText("Hi, I am a Rectangle");
                break;


            case R.id.ovalImage:
                ovalImage.setVisibility(view.VISIBLE);
                ovalImage.startAnimation(fadeindata5);
                cleanup();
                mp=MediaPlayer.create(LearnShape.this,R.raw.ovel1);
                mp.start();
                Picasso.with(LearnShape.this).load(R.drawable.oval).into(setImage);
              //  setImage.setImageResource(R.drawable.oval);
                textView.setText("Hi, I am a Oval");
                break;

            case R.id.starimage:
                starimage.setVisibility(view.VISIBLE);
                starimage.startAnimation(fadeindata6);
                cleanup();
                mp=MediaPlayer.create(LearnShape.this,R.raw.star4);
                mp.start();
                Picasso.with(LearnShape.this).load(R.drawable.star1).into(setImage);
              //  setImage.setImageResource(R.drawable.star1);
                textView.setText("Hi, I am a Star");
                break;

            case R.id.heartimage:
                heartimage.setVisibility(view.VISIBLE);
                heartimage.startAnimation(fadeindata7);
                cleanup();
                mp=MediaPlayer.create(LearnShape.this,R.raw.heart1);
                mp.start();
                Picasso.with(LearnShape.this).load(R.drawable.heartshape).into(setImage);
             //   setImage.setImageResource(R.drawable.heartshape);
                textView.setText("Hi, I am a Heart");
                break;

            case R.id.pentaImage:
                pentaImage.setVisibility(view.VISIBLE);
                pentaImage.startAnimation(fadeindata8);
                cleanup();
                mp=MediaPlayer.create(LearnShape.this,R.raw.pentagon);
                mp.start();
                Picasso.with(LearnShape.this).load(R.drawable.penta).into(setImage);
               // setImage.setImageResource(R.drawable.penta);
                textView.setText("Hi, I am a Pentagon");
                break;
        }

    }

    public void cleanup() {
        if (mp!= null && mp.isPlaying()) {
            mp.stop();
            mp.release();
            mp = null;
        }
    }
    @Override
    protected void onStop() {
        super.onStop();

        if (mp != null) {
            mp.stop();
        }
    }





}

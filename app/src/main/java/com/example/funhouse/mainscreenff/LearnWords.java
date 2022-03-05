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


public class LearnWords extends AppCompatActivity {
//    Handler gameThread = new Handler();
 MediaPlayer mp;
//    private Animation shake;

    int[] images = {R.drawable.aforapple,R.drawable.bforball,R.drawable.cforcar,R.drawable.dfordog,R.drawable.eforelephant,
            R.drawable.fforfox,R.drawable.gforgoat,R.drawable.hforhat,R.drawable.iforigloo,R.drawable.jforjoker,
            R.drawable.kforkangroo,R.drawable.lforlion,R.drawable.mformouse,R.drawable.nfor,R.drawable.oforowl,
            R.drawable.pforpig,R.drawable.qforqueen,R.drawable.rforrabbit,R.drawable.sforsun,R.drawable.tfortrain,
            R.drawable.uforumbrella,R.drawable.vforviolin,R.drawable.wforwhale,R.drawable.xforxylo,R.drawable.yforyak,
            R.drawable.zforzebra

    };
ImageView imageView1, imageView2, imageView3, imageView4, imageView5, imageView6,
        imageView7, imageView8, imageView9, imageView10, imageView11, imageView12,
        imageView13, imageView14, imageView15, imageView16, imageView17, imageView18,
        imageView19, imageView20, imageView21, imageView22, imageView23, imageView24,
        imageView25, imageView26, imageView27,back;
    TextView textView;

    int goNext;
    MediaPlayer md;
    Animation bouncedata,scaling;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_words);

back=(ImageView)findViewById(R.id.backbuttonlearnwords);
        goNext = R.drawable.a;
        //   textView =(TextView) findViewById(R.id.textView);
        imageView1 = (ImageView) findViewById(R.id.imageView1);
        final ImageView imageView2 = (ImageView) findViewById(R.id.imageView2);
        final ImageView imageView3 = (ImageView) findViewById(R.id.imageView3);
        final ImageView imageView4 = (ImageView) findViewById(R.id.imageView4);
        final ImageView imageView5 = (ImageView) findViewById(R.id.imageView5);
        final ImageView imageView6 = (ImageView) findViewById(R.id.imageView6);
        final ImageView imageView7 = (ImageView) findViewById(R.id.imageView7);
        final ImageView imageView8 = (ImageView) findViewById(R.id.imageView8);
        final ImageView imageView9 = (ImageView) findViewById(R.id.imageView9);
        final ImageView imageView10 = (ImageView) findViewById(R.id.imageView10);
        final ImageView imageView11 = (ImageView) findViewById(R.id.imageView11);
        final ImageView imageView12 = (ImageView) findViewById(R.id.imageView12);
        final ImageView imageView13 = (ImageView) findViewById(R.id.imageView13);
        final ImageView imageView14 = (ImageView) findViewById(R.id.imageView14);
        final ImageView imageView15 = (ImageView) findViewById(R.id.imageView15);
        final ImageView imageView16 = (ImageView) findViewById(R.id.imageView16);
        final ImageView imageView17 = (ImageView) findViewById(R.id.imageView17);
        final ImageView imageView18 = (ImageView) findViewById(R.id.imageView18);
        final ImageView imageView19 = (ImageView) findViewById(R.id.imageView19);
        final ImageView imageView20 = (ImageView) findViewById(R.id.imageView20);
        final ImageView imageView21 = (ImageView) findViewById(R.id.imageView21);
        final ImageView imageView22 = (ImageView) findViewById(R.id.imageView22);
        final ImageView imageView23 = (ImageView) findViewById(R.id.imageView23);
        final ImageView imageView24 = (ImageView) findViewById(R.id.imageView24);
        final ImageView imageView25 = (ImageView) findViewById(R.id.imageView25);
        final ImageView imageView26 = (ImageView) findViewById(R.id.imageView26);
        final ImageView imageView27 = (ImageView) findViewById(R.id.imageView27);
        bouncedata = AnimationUtils.loadAnimation(LearnWords.this, R.anim.bounce);

        scaling = AnimationUtils.loadAnimation(LearnWords.this, R.anim.scale);

back.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
//        Intent intent = new Intent(LearnWords.this,AbcActivity.class);
//        startActivity(intent);
        LearnWords.super.onBackPressed();
        finish();
        cleanup();
        mp=MediaPlayer.create(LearnWords.this,R.raw.backnextbuttonsound);
        mp.start();
    }
});
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView1.setVisibility(View.VISIBLE);
                imageView1.startAnimation(bouncedata);
                cleanup();
                md = MediaPlayer.create(LearnWords.this, R.raw.random_comical);
                md.start();
            }
        });


        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView2.startAnimation(scaling);
                Picasso.with(LearnWords.this).load(images[0]).into(imageView1);
                //imageView1.setImageResource(R.drawable.aforapple);
                goNext = R.drawable.b;
                cleanup();
                md = MediaPlayer.create(LearnWords.this, R.raw.a_for_apple);
                md.start();

            }
        });


        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imageView3.startAnimation(scaling);
                Picasso.with(LearnWords.this).load(images[1]).into(imageView1);
               // imageView1.setImageResource(R.drawable.bforball);
                goNext = R.drawable.c;
                cleanup();
                md = MediaPlayer.create(LearnWords.this, R.raw.b_for_ball);
                md.start();

            }
        });


        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView4.setVisibility(View.VISIBLE);
                imageView4.startAnimation(scaling);
                Picasso.with(LearnWords.this).load(images[2]).into(imageView1);
                //imageView1.setImageResource(R.drawable.cforcar);
                goNext = R.drawable.d;
                cleanup();
                md = MediaPlayer.create(LearnWords.this, R.raw.c_for_car);
                md.start();

            }
        });


        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView5.setVisibility(View.VISIBLE);
                imageView5.startAnimation(scaling);
                Picasso.with(LearnWords.this).load(images[3]).into(imageView1);
               // imageView1.setImageResource(R.drawable.dfordog);
                goNext = R.drawable.e;
                cleanup();
                md = MediaPlayer.create(LearnWords.this, R.raw.d_for_dog);
                md.start();
            }
        });

        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView6.setVisibility(View.VISIBLE);
                imageView6.startAnimation(scaling);
                Picasso.with(LearnWords.this).load(images[4]).into(imageView1);
              //  imageView1.setImageResource(R.drawable.eforelephant);
                goNext = R.drawable.f;
                cleanup();
                md = MediaPlayer.create(LearnWords.this, R.raw.e_for_elephant);
                md.start();


            }
        });
        imageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView7.setVisibility(View.VISIBLE);
                imageView7.startAnimation(scaling);
                Picasso.with(LearnWords.this).load(images[5]).into(imageView1);
               // imageView1.setImageResource(R.drawable.fforfox);
                goNext = R.drawable.g;
                cleanup();
                md = MediaPlayer.create(LearnWords.this, R.raw.f_for_fox);
                md.start();

            }
        });
        imageView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView8.setVisibility(View.VISIBLE);
                imageView8.startAnimation(scaling);
                Picasso.with(LearnWords.this).load(images[6]).into(imageView1);
                //imageView1.setImageResource(R.drawable.gforgoat);
                goNext = R.drawable.h;
                cleanup();
                md = MediaPlayer.create(LearnWords.this, R.raw.g_for_goat);
                md.start();

            }
        });
        imageView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView9.setVisibility(View.VISIBLE);
                imageView9.startAnimation(scaling);
                Picasso.with(LearnWords.this).load(images[7]).into(imageView1);
               // imageView1.setImageResource(R.drawable.hforhat);
                goNext = R.drawable.i;
                cleanup();
                md = MediaPlayer.create(LearnWords.this, R.raw.h_for_hat);
                md.start();
            }
        });

        imageView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView10.setVisibility(View.VISIBLE);
                imageView10.startAnimation(scaling);
                Picasso.with(LearnWords.this).load(images[8]).into(imageView1);
               // imageView1.setImageResource(R.drawable.iforigloo);
                goNext = R.drawable.j;
                cleanup();
                md = MediaPlayer.create(LearnWords.this, R.raw.i_for_igloo);
                md.start();
            }
        });

        imageView11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView11.setVisibility(View.VISIBLE);
                imageView11.startAnimation(scaling);
               // imageView1.setImageResource(R.drawable.jforjoker);
                Picasso.with(LearnWords.this).load(images[9]).into(imageView1);
                goNext = R.drawable.k;
                cleanup();
                md = MediaPlayer.create(LearnWords.this, R.raw.j_for_joker);
                md.start();
            }
        });

        imageView12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView12.setVisibility(View.VISIBLE);
                imageView12.startAnimation(scaling);
              //  imageView1.setImageResource(R.drawable.kforkangroo);
                Picasso.with(LearnWords.this).load(images[10]).into(imageView1);
                goNext = R.drawable.l;
                cleanup();
                md = MediaPlayer.create(LearnWords.this, R.raw.k_for_kangaroo);
                md.start();
            }
        });

        imageView13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView13.setVisibility(View.VISIBLE);
                imageView13.startAnimation(scaling);
              //  imageView1.setImageResource(R.drawable.lforlion);
                Picasso.with(LearnWords.this).load(images[11]).into(imageView1);
                goNext = R.drawable.m;
                cleanup();
                md = MediaPlayer.create(LearnWords.this, R.raw.l_for_lion);
                md.start();
            }
        });

        imageView14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView14.setVisibility(View.VISIBLE);
                imageView14.startAnimation(scaling);
              //  imageView1.setImageResource(R.drawable.mformouse);
                Picasso.with(LearnWords.this).load(images[12]).into(imageView1);
                goNext = R.drawable.n;
                cleanup();
                md = MediaPlayer.create(LearnWords.this, R.raw.m_for_mouse);
                md.start();
            }
        });

        imageView15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView15.setVisibility(View.VISIBLE);
                imageView15.startAnimation(scaling);
              //  imageView1.setImageResource(R.drawable.nfor);
                Picasso.with(LearnWords.this).load(images[13]).into(imageView1);
                goNext = R.drawable.o;
                cleanup();
                md = MediaPlayer.create(LearnWords.this, R.raw.n_for_nest);
                md.start();
            }
        });
        imageView16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView16.setVisibility(View.VISIBLE);
                imageView16.startAnimation(scaling);
              //  imageView1.setImageResource(R.drawable.oforowl);
                Picasso.with(LearnWords.this).load(images[14]).into(imageView1);
                goNext = R.drawable.p;
                cleanup();
                md = MediaPlayer.create(LearnWords.this, R.raw.o_for_owl);
                md.start();
            }
        });

        imageView17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView17.setVisibility(View.VISIBLE);
                imageView17.startAnimation(scaling);
            //    imageView1.setImageResource(R.drawable.pforpig);
                Picasso.with(LearnWords.this).load(images[15]).into(imageView1);
                goNext = R.drawable.q;
                cleanup();
                md = MediaPlayer.create(LearnWords.this, R.raw.p_for_pig);
                md.start();
            }
        });

        imageView18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView18.setVisibility(View.VISIBLE);
                imageView18.startAnimation(scaling);
            //    imageView1.setImageResource(R.drawable.qforqueen);
                Picasso.with(LearnWords.this).load(images[16]).into(imageView1);
                goNext = R.drawable.r;
                cleanup();
                md = MediaPlayer.create(LearnWords.this, R.raw.q_for_queen);
                md.start();
            }
        });

        imageView19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView19.setVisibility(View.VISIBLE);
                imageView19.startAnimation(scaling);
             //   imageView1.setImageResource(R.drawable.rforrabbit);
                Picasso.with(LearnWords.this).load(images[17]).into(imageView1);
                goNext = R.drawable.s;
                cleanup();
                md = MediaPlayer.create(LearnWords.this, R.raw.r_for_rabbit);
                md.start();
            }
        });

        imageView20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView20.setVisibility(View.VISIBLE);
                imageView20.startAnimation(scaling);
              //  imageView1.setImageResource(R.drawable.sforsun);
                Picasso.with(LearnWords.this).load(images[18]).into(imageView1);
                goNext = R.drawable.t;
                cleanup();
                md = MediaPlayer.create(LearnWords.this, R.raw.s_for_sun);
                md.start();
            }
        });

        imageView21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView21.setVisibility(View.VISIBLE);
                imageView21.startAnimation(scaling);
             //   imageView1.setImageResource(R.drawable.tfortrain);
                Picasso.with(LearnWords.this).load(images[19]).into(imageView1);
                goNext = R.drawable.u;
                cleanup();
                md = MediaPlayer.create(LearnWords.this, R.raw.t_for_train);

                md.start();
            }
        });


        imageView22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView22.setVisibility(View.VISIBLE);
                imageView22.startAnimation(scaling);
            //    imageView1.setImageResource(R.drawable.uforumbrella);
                Picasso.with(LearnWords.this).load(images[20]).into(imageView1);
                goNext = R.drawable.v;
                cleanup();
                md = MediaPlayer.create(LearnWords.this, R.raw.u_for_umbrella);
                md.start();
            }
        });
        imageView23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView23.setVisibility(View.VISIBLE);
                imageView23.startAnimation(scaling);
              //  imageView1.setImageResource(R.drawable.vforviolin);
                Picasso.with(LearnWords.this).load(images[21]).into(imageView1);
                goNext = R.drawable.w;
                cleanup();
                md = MediaPlayer.create(LearnWords.this, R.raw.v_for_violin);

                md.start();
            }
        });


        imageView24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView24.setVisibility(View.VISIBLE);
                imageView24.startAnimation(scaling);
           //     imageView1.setImageResource(R.drawable.wforwhale);
                Picasso.with(LearnWords.this).load(images[22]).into(imageView1);
                goNext = R.drawable.x;
                cleanup();
                md = MediaPlayer.create(LearnWords.this, R.raw.w_for_whale);

                md.start();
            }
        });

        imageView25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView25.setVisibility(View.VISIBLE);
                imageView25.startAnimation(scaling);
           //     imageView1.setImageResource(R.drawable.xforxylo);
                Picasso.with(LearnWords.this).load(images[23]).into(imageView1);
                goNext = R.drawable.y;
                cleanup();
                md = MediaPlayer.create(LearnWords.this, R.raw.x_for_xlyophone);

                md.start();
            }
        });

        imageView26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView26.setVisibility(View.VISIBLE);
                imageView26.startAnimation(scaling);
               // imageView1.setImageResource(R.drawable.yforyak);
                Picasso.with(LearnWords.this).load(images[24]).into(imageView1);
                goNext = R.drawable.z;
                cleanup();
                md = MediaPlayer.create(LearnWords.this, R.raw.y_for_yak);

                md.start();
            }
        });

        imageView27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView27.setVisibility(View.VISIBLE);
                imageView27.startAnimation(scaling);
             //   imageView1.setImageResource(R.drawable.zforzebra);
                Picasso.with(LearnWords.this).load(images[25]).into(imageView1);
                goNext = R.drawable.a;
                cleanup();
                md = MediaPlayer.create(LearnWords.this, R.raw.z_for_zebra);

                md.start();
            }
        });



    }
    public void cleanup() {
        if (md!= null && md.isPlaying()) {
            md.stop();
            md.release();
            md = null;
        }
    }
    @Override
    protected void onStop() {
        super.onStop();

        if (md != null) {
            md.stop();
        }
    }




}



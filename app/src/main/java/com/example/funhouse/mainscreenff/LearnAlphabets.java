package com.example.funhouse.mainscreenff;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class LearnAlphabets extends AppCompatActivity {


    Handler gameThread = new Handler();
    Button a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z;
    private Animation shake;
    private Animation scale;
    MediaPlayer mp;
    ImageView backk;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_alphabets);
    backk=(ImageView)findViewById(R.id.backbuttonalpha) ;
        shake = AnimationUtils.loadAnimation(LearnAlphabets.this, R.anim.shake_anim2);
        scale = AnimationUtils.loadAnimation(LearnAlphabets.this, R.anim.scaling);
        Log.d("testing", "I am fine too");

        typeCasting();
        setListener();
        backk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(LearnAlphabets.this,AbcActivity.class);
//                startActivity(intent);
                LearnAlphabets.super.onBackPressed();
                finish();
                cleanup();
                mp=MediaPlayer.create(LearnAlphabets.this,R.raw.backnextbuttonsound);
                mp.start();
            }
        });




    }

    private void typeCasting() {
        Log.d("test", "I am fine ");
        a = (Button) findViewById(R.id.a);
        b = (Button) findViewById(R.id.b);
        c = (Button) findViewById(R.id.c);
        d = (Button) findViewById(R.id.d);
        e = (Button) findViewById(R.id.e);
        f = (Button) findViewById(R.id.f);
        g = (Button) findViewById(R.id.g);
        h = (Button) findViewById(R.id.h);
        a = (Button) findViewById(R.id.a);
        a = (Button) findViewById(R.id.a);
        i = (Button) findViewById(R.id.i);
        j = (Button) findViewById(R.id.j);
        k = (Button) findViewById(R.id.k);
        l = (Button) findViewById(R.id.l);
        m = (Button) findViewById(R.id.m);
        n = (Button) findViewById(R.id.n);
        o = (Button) findViewById(R.id.o);
        p = (Button) findViewById(R.id.p);
        q = (Button) findViewById(R.id.q);
        r = (Button) findViewById(R.id.r);
        s = (Button) findViewById(R.id.s);
        t = (Button) findViewById(R.id.t);
        u = (Button) findViewById(R.id.u);
        v = (Button) findViewById(R.id.v);
        w = (Button) findViewById(R.id.w);
        x = (Button) findViewById(R.id.x);
        y = (Button) findViewById(R.id.y);
        z = (Button) findViewById(R.id.z);
    }

    private void setListener() {

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleanup();
                mp = MediaPlayer.create(LearnAlphabets.this,R.raw.aa);
                mp.start();
                a.startAnimation(shake);
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleanup();
                mp = MediaPlayer.create(LearnAlphabets.this,R.raw.bb);
                mp.start();
                b.startAnimation(shake);
                }



        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cleanup();
                mp = MediaPlayer.create(LearnAlphabets.this,R.raw.cc);
                mp.start();
                c.startAnimation(shake);
            }
        });
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleanup();
                mp = MediaPlayer.create(LearnAlphabets.this,R.raw.dd);
                mp.start();
                d.startAnimation(shake);
            }
        });
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleanup();
                mp = MediaPlayer.create(LearnAlphabets.this,R.raw.ee);
                mp.start();
                e.startAnimation(shake);

            }
        });
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleanup();
                mp = MediaPlayer.create(LearnAlphabets.this,R.raw.ff);
                mp.start();
                f.startAnimation(shake);


            }
        });
        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleanup();
                mp = MediaPlayer.create(LearnAlphabets.this,R.raw.gg);
                mp.start();
                g.startAnimation(shake);

            }
        });
        h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleanup();
                mp = MediaPlayer.create(LearnAlphabets.this,R.raw.hh);
                mp.start();
                h.startAnimation(shake);

            }
        });
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleanup();
                mp = MediaPlayer.create(LearnAlphabets.this,R.raw.ii);
                mp.start();
                i.startAnimation(shake);


            }
        });
        j.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleanup();
                mp = MediaPlayer.create(LearnAlphabets.this,R.raw.jj);
                mp.start();
                j.startAnimation(shake);

            }
        });
        k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleanup();
                mp = MediaPlayer.create(LearnAlphabets.this,R.raw.kk);
                mp.start();
                k.startAnimation(shake);
            }
        });
        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleanup();
                mp = MediaPlayer.create(LearnAlphabets.this,R.raw.ll);
                mp.start();
                l.startAnimation(shake);
            }
        });
        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleanup();
                mp = MediaPlayer.create(LearnAlphabets.this,R.raw.mm);
                mp.start();
                m.startAnimation(shake);


            }
        });
        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleanup();
                mp = MediaPlayer.create(LearnAlphabets.this,R.raw.nn);
                mp.start();
                n.startAnimation(shake);
            }
        });
        o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleanup();
                mp = MediaPlayer.create(LearnAlphabets.this,R.raw.oo);
                mp.start();
                o.startAnimation(shake);


            }
        });
        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleanup();
                mp = MediaPlayer.create(LearnAlphabets.this,R.raw.pp);
                mp.start();
                p.startAnimation(shake);

            }
        });
        q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleanup();
                mp = MediaPlayer.create(LearnAlphabets.this,R.raw.qq);
                mp.start();
                q.startAnimation(shake);
            }
        });
        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleanup();
                mp = MediaPlayer.create(LearnAlphabets.this,R.raw.rr);
                mp.start();
                r.startAnimation(shake);

            }
        });
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleanup();
                mp = MediaPlayer.create(LearnAlphabets.this,R.raw.ss);
                mp.start();
                s.startAnimation(shake);
            }
        });
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleanup();
                mp = MediaPlayer.create(LearnAlphabets.this,R.raw.tt);
                mp.start();
                t.startAnimation(shake);


            }
        });
        u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleanup();
                mp = MediaPlayer.create(LearnAlphabets.this,R.raw.uu);
                mp.start();
                u.startAnimation(shake);
            }
        });
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleanup();
                mp = MediaPlayer.create(LearnAlphabets.this,R.raw.vv);
                mp.start();
                v.startAnimation(shake);
            }
        });
        w.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleanup();
                mp = MediaPlayer.create(LearnAlphabets.this,R.raw.ww);
                mp.start();
                w.startAnimation(shake);
            }
        });
        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleanup();
                mp = MediaPlayer.create(LearnAlphabets.this,R.raw.xx);
                mp.start();
                x.startAnimation(shake);
            }
        });
        y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleanup();
                mp = MediaPlayer.create(LearnAlphabets.this,R.raw.yy);
                mp.start();
                y.startAnimation(shake);
            }
        });
        z.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleanup();
                mp = MediaPlayer.create(LearnAlphabets.this,R.raw.zz);
                mp.start();
                z.startAnimation(shake);
            }
        });
    }

    //----------------------------- Activity Life Cycle-----------------------//


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

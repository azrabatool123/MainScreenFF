package com.example.funhouse.mainscreenff;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class QuizResultEng extends AppCompatActivity {
ImageView back;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result_eng);
        TextView tv_result = (TextView)findViewById(R.id.tv_resulteng);
        int score = getIntent().getIntExtra("rightAnswers",0);
        tv_result.setText(score + "/26");





       back=(ImageView)findViewById(R.id.backquizresulteng);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(QuizResultEng.this,AbcActivity.class);
//                startActivity(intent);
                QuizResultEng.super.onBackPressed();
                finish();
                cleanup();
                mp= MediaPlayer.create(QuizResultEng.this,R.raw.backnextbuttonsound);
                mp.start();
            }
        });
        }

    public void tryAgain( View view){
Intent intent = new Intent(QuizResultEng.this,QuizEnglish.class);
        startActivity(intent);
        cleanup();
        mp= MediaPlayer.create(QuizResultEng.this,R.raw.buttonclicksound);
        mp.start();


    }
    @Override
    protected void onStop() {
        super.onStop();

        if (mp != null) {
            mp.stop();
        }
    }
    public void cleanup() {
        if (mp != null && mp.isPlaying()) {
            mp.stop();
            mp.release();
            mp = null;
        }
    }


}

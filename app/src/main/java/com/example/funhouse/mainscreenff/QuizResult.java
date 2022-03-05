package com.example.funhouse.mainscreenff;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class QuizResult extends AppCompatActivity {
ImageView back;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);
        TextView tv_result = (TextView)findViewById(R.id.tv_result);
        int score = getIntent().getIntExtra("rightAnswers",0);
            tv_result.setText(score + "/10");
        back=(ImageView)findViewById(R.id.quizresultmath);
       back.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
//               Intent intent = new Intent(QuizResult.this,NumberActivity.class);
//               startActivity(intent);
               QuizResult.super.onBackPressed();
               cleanup();
               finish();
               mp= MediaPlayer.create(QuizResult.this,R.raw.backnextbuttonsound);
               mp.start();
           }
       });


        }
    public void tryAgainm(View view){
        Intent intent = new Intent(QuizResult.this,MathQuiz.class);
        startActivity(intent);
        cleanup();
        mp= MediaPlayer.create(QuizResult.this,R.raw.buttonclicksound);
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

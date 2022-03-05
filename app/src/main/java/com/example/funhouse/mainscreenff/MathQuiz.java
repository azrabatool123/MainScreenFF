package com.example.funhouse.mainscreenff;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MathQuiz extends AppCompatActivity {
ImageView back;
    Button b_answer1,b_answer2,b_answer3,b_answer4;
    MediaPlayer mp;

    ImageView iv_flag;
    List<QuestionModel> list;

    Random random;

    int turn=1;

    int right_answer=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_quiz);

        random = new Random();
back=(ImageView)findViewById(R.id.baclmathquiz);
        iv_flag = (ImageView)findViewById(R.id.iv_flags);

        b_answer1 = (Button) findViewById(R.id.b_answer1);
        b_answer2 = (Button) findViewById(R.id.b_answer2);
        b_answer3 = (Button) findViewById(R.id.b_answer3);
        b_answer4 = (Button) findViewById(R.id.b_answer4);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(MathQuiz.this,NumberActivity.class);
//                startActivity(intent);
                finish();
                MathQuiz.super.onBackPressed();
                cleanup();
                mp=MediaPlayer.create(MathQuiz.this,R.raw.backnextbuttonsound);
                mp.start();
            }
        });

        list = new ArrayList<>();

        for (int i =0 ; i<new Database().answers.length; i++)
        {
            list.add(new QuestionModel(new Database().answers[i], new Database().questions[i]));
        }

        Collections.shuffle(list);
        newQuestions(turn);

        b_answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                b_answer1.setVisibility(View.VISIBLE);

                if(b_answer1.getText().toString().equalsIgnoreCase(list.get(turn -1).getName()))
                {
                    right_answer = right_answer+1;
                    cleanup();

                    mp=MediaPlayer.create(MathQuiz.this,R.raw.quizright);
                    mp.start();
                    if(turn<list.size())
                    {
                        turn++;
                        newQuestions(turn);
                    }

                    else
                    {

                        getResults();

                    }
                }

                else
                {
                    mp=MediaPlayer.create(MathQuiz.this,R.raw.quizwrong);
                    mp.start();

                    cleanup();
                    mp=MediaPlayer.create(MathQuiz.this,R.raw.quizwrong);
                    mp.start();
                    if(turn<list.size())
                    {
                        turn++;
                        newQuestions(turn);
                    }

                    else
                    {

                        getResults();
                    }

                }

            }
        });

        b_answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                b_answer2.setVisibility(View.VISIBLE);

                if(b_answer2.getText().toString().equalsIgnoreCase(list.get(turn -1).getName()))
                {
                    right_answer = right_answer+1;

                    cleanup();
                    mp=MediaPlayer.create(MathQuiz.this,R.raw.quizright);
                    mp.start();
                    if(turn<list.size())
                    {
                        turn++;
                        newQuestions(turn);
                    }

                    else
                    {

                        getResults();
                    }
                }

                else
                {

                    cleanup();
                    mp=MediaPlayer.create(MathQuiz.this,R.raw.quizwrong);
                    mp.start();
                    if(turn<list.size())
                    {
                        turn++;
                        newQuestions(turn);
                    }

                    else
                    {

                        getResults();
                    }

                }

            }
        });

        b_answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                b_answer3.setVisibility(View.VISIBLE);

                if(b_answer3.getText().toString().equalsIgnoreCase(list.get(turn -1).getName()))
                {
                    right_answer = right_answer+1;

                    cleanup();
                    mp=MediaPlayer.create(MathQuiz.this,R.raw.quizright);
                    mp.start();
                    if(turn<list.size())
                    {
                        turn++;
                        newQuestions(turn);
                    }

                    else
                    {

                        getResults();
                    }
                }

                else
                {

                    cleanup();
                    mp=MediaPlayer.create(MathQuiz.this,R.raw.quizwrong);
                    mp.start();
                    if(turn<list.size())
                    {
                        turn++;
                        newQuestions(turn);
                    }

                    else
                    {

                        getResults();
                    }

                }

            }
        });

        b_answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                b_answer4.setVisibility(View.VISIBLE);

                if(b_answer4.getText().toString().equalsIgnoreCase(list.get(turn -1).getName()))
                {
                    right_answer = right_answer+1;

                    cleanup();
                    mp=MediaPlayer.create(MathQuiz.this,R.raw.quizright);
                    mp.start();
                    if(turn<list.size())
                    {
                        turn++;
                        newQuestions(turn);
                    }

                    else
                    {

                        getResults();
                    }
                }

                else
                {

                    cleanup();
                    mp=MediaPlayer.create(MathQuiz.this,R.raw.quizwrong);
                    mp.start();
                    if(turn<list.size())
                    {
                        turn++;
                        newQuestions(turn);
                    }

                    else
                    {

                        getResults();
                    }

                }

            }
        });
    }

    private void getResults()
    {
        Intent intent = new Intent(getApplicationContext(),QuizResult.class);
        intent.putExtra("rightAnswers",right_answer);
        startActivity(intent);
        finish();

            cleanup();
            mp=MediaPlayer.create(MathQuiz.this,R.raw.quizclap);
            mp.start();

    }
    public  void cleanup(){
        if (mp!= null && mp.isPlaying()) {
            mp.stop();
            mp.release();
            mp = null;
        }
    }

    private void newQuestions(int number)
    {
        Picasso.with(MathQuiz.this).load(list.get(number - 1 ).getImage()).into(iv_flag);
//        iv_flag.setImageResource(list.get(number - 1 ).getImage());

        int correct_answer = random.nextInt(4)+1;

        int first_button= number-1;
        int second_button;
        int third_button;
        int fourth_button;

        switch (correct_answer)
        {
            case 1:
                b_answer3.setText(list.get(first_button).getName());

                do
                {
                    second_button= random.nextInt(list.size());
                }
                while(second_button==first_button);

                do
                {
                    third_button= random.nextInt(list.size());
                }
                while(third_button==first_button || third_button==second_button);


                do
                {
                    fourth_button= random.nextInt(list.size());
                }
                while(fourth_button==first_button || fourth_button==second_button ||fourth_button==third_button);

                b_answer2.setText(list.get(second_button).getName());
                b_answer1.setText(list.get(third_button).getName());
                b_answer4.setText(list.get(fourth_button).getName());

                break;

            case 2:
                b_answer1.setText(list.get(first_button).getName());

                do
                {
                    second_button= random.nextInt(list.size());
                }
                while(second_button==first_button);

                do
                {
                    third_button= random.nextInt(list.size());
                }
                while(third_button==first_button || third_button==second_button);


                do
                {
                    fourth_button= random.nextInt(list.size());
                }
                while(fourth_button==first_button || fourth_button==second_button ||fourth_button==third_button);

                b_answer2.setText(list.get(second_button).getName());
                b_answer3.setText(list.get(third_button).getName());
                b_answer4.setText(list.get(fourth_button).getName());
                break;

            case 3:
                b_answer4.setText(list.get(first_button).getName());

                do
                {
                    second_button= random.nextInt(list.size());
                }
                while(second_button==first_button);

                do
                {
                    third_button= random.nextInt(list.size());
                }
                while(third_button==first_button || third_button==second_button);


                do
                {
                    fourth_button= random.nextInt(list.size());
                }
                while(fourth_button==first_button || fourth_button==second_button ||fourth_button==third_button);

                b_answer2.setText(list.get(second_button).getName());
                b_answer1.setText(list.get(fourth_button).getName());
                b_answer3.setText(list.get(third_button).getName());
                break;

            case 4:
                b_answer2.setText(list.get(first_button).getName());

                do
                {
                    second_button= random.nextInt(list.size());
                }
                while(second_button==first_button);

                do
                {
                    third_button= random.nextInt(list.size());
                }
                while(third_button==first_button || third_button==second_button);


                do
                {
                    fourth_button= random.nextInt(list.size());
                }
                while(fourth_button==first_button || fourth_button==second_button ||fourth_button==third_button);

                b_answer4.setText(list.get(fourth_button).getName());
                b_answer3.setText(list.get(third_button).getName());
                b_answer1.setText(list.get(second_button).getName());
                break;
        }
    }
}

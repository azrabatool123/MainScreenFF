package com.example.funhouse.mainscreenff;

import static com.example.funhouse.mainscreenff.Model.Constants.MY_PREFS_NAME;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.funhouse.mainscreenff.Model.Constants;

public class AgeSelectionScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_selection_screen);


        findViewById(R.id.iv_age_15_to_25).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                editor.putString(Constants.AGE_SAVE, "1.5_to_2.5");
                editor.apply();
                Intent i = new Intent(AgeSelectionScreen.this, MainTwoSection.class);
                startActivity(i);
                finish();
            }
        });

        findViewById(R.id.iv_age_25_to_35).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                editor.putString(Constants.AGE_SAVE, "1.5_to_2.5");
                editor.apply();
                Intent i = new Intent(AgeSelectionScreen.this, MainTwoSection.class);
                startActivity(i);
                finish();
            }
        });
    }
}
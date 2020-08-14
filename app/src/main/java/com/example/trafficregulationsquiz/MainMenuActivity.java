package com.example.trafficregulationsquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.view.View;


public class MainMenuActivity extends AppCompatActivity implements View.OnClickListener {

    private MediaPlayer btn_clicked;
    private Handler handler = new Handler();
    private Button musicBtn;

    public Boolean isMusicPlaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity_main);
        btn_clicked = MediaPlayer.create(this, R.raw.button_clicked);
        Button signsQuiz = findViewById(R.id.signs_quiz);
        Button trafficRegQuiz = findViewById(R.id.traffic_reg_quiz);
        Button firstAidQuiz = findViewById(R.id.first_aid);
        signsQuiz.setOnClickListener(this);
        trafficRegQuiz.setOnClickListener(this);
        firstAidQuiz.setOnClickListener(this);

        musicBtn = findViewById(R.id.music);
        startService(new Intent(this, MyService.class));

        isMusicPlaying = true;
        musicBtn.setOnClickListener(this);
    }
    
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.music:

                if (isMusicPlaying) {
                    musicBtn.setBackgroundResource(R.drawable.music_off);
                    stopService(new Intent(getBaseContext(), MyService.class));
                } else {
                    musicBtn.setBackgroundResource(R.drawable.music_on);
                    startService(new Intent(getBaseContext(), MyService.class));
                }
                isMusicPlaying = !isMusicPlaying;
                break;

            case R.id.signs_quiz:
                btn_clicked.start();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        signsQuizAct();
                    }
                }, 100);
                break;
            case R.id.traffic_reg_quiz:
                btn_clicked.start();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        trafficRegQuizAct();
                    }
                }, 100);
                break;
            case R.id.first_aid:
                btn_clicked.start();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        firstAidAct();
                    }
                }, 100);
                break;
        }
    }

    public void signsQuizAct() {
        Intent intent = new Intent(this, QuizActivity.class);
        startActivity(intent);
    }

    public void trafficRegQuizAct() {
        Intent intent = new Intent(this, SecondQuizActivity.class);
        startActivity(intent);
    }

    public void firstAidAct() {
        Intent intent = new Intent(this, ThirdQuizActivity.class);
        startActivity(intent);
    }
}
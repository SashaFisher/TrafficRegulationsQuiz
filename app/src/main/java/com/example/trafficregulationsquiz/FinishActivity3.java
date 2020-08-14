package com.example.trafficregulationsquiz;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FinishActivity3 extends AppCompatActivity {

    private MediaPlayer btn_clicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        Intent intent3 = getIntent();

        TextView mCongratsView3 = (TextView) findViewById(R.id.congrats);
        TextView mScoreView3 = (TextView) findViewById(R.id.score_view);
        Button mTryAgain3 = findViewById(R.id.try_again);
        Button mNext3 = findViewById(R.id.next);
        String stringScore3 = intent3.getStringExtra("mScore3");
        int mScore3 = Integer.parseInt(stringScore3);
        btn_clicked = MediaPlayer.create(this, R.raw.button_clicked);

        if (mScore3 == 15)
            mCongratsView3.setText("Превосходно!");
        if (mScore3 == 13 || mScore3 == 14)
            mCongratsView3.setText("Отлично!");
        if (mScore3 == 10 || mScore3 == 11 || mScore3 == 12)
            mCongratsView3.setText("Хорошо, но можно лучше.");
        if (mScore3 == 8 || mScore3 == 9)
            mCongratsView3.setText("Нормально.");
        if (mScore3 < 8)
            mCongratsView3.setText("Плохо, попробуйте ещё раз.");

        mScoreView3.setText(mScore3 + "/15");

        mTryAgain3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_clicked.start();
                quizActivity3();
            }
        });

        mNext3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_clicked.start();
                mainMenuActivity3();
            }
        });
    }

    private void quizActivity3(){
        Intent intent = new Intent(this, ThirdQuizActivity.class);
        startActivity(intent);
        finish();
    }

    private void mainMenuActivity3(){
       finish();
    }
}

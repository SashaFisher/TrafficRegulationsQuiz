package com.example.trafficregulationsquiz;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FinishActivity extends AppCompatActivity {

    private MediaPlayer btn_clicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        Intent intent2 = getIntent();

        TextView mCongratsView2 = (TextView) findViewById(R.id.congrats);
        TextView mScoreView2 = (TextView) findViewById(R.id.score_view);
        Button mTryAgain2 = findViewById(R.id.try_again);
        Button mNext2 = findViewById(R.id.next);
        String stringScore2 = intent2.getStringExtra("mScore");
        int mScore2 = Integer.parseInt(stringScore2);
        btn_clicked = MediaPlayer.create(this, R.raw.button_clicked);

        if (mScore2 == 21)
            mCongratsView2.setText("Превосходно!");
        if (mScore2 == 18 || mScore2 == 19 || mScore2 == 20)
            mCongratsView2.setText("Отлично!");
        if (mScore2 == 15 || mScore2 == 16 || mScore2 == 17)
            mCongratsView2.setText("Хорошо, но можно лучше.");
        if (mScore2 < 15 && mScore2 > 10)
            mCongratsView2.setText("Нормально.");
        if (mScore2 < 11)
            mCongratsView2.setText("Плохо, попробуйте ещё раз.");

        mScoreView2.setText(mScore2 + "/21");

        mTryAgain2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_clicked.start();
                quizActivity2();
            }
        });

        mNext2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_clicked.start();
                mainMenuActivity2();
            }
        });
    }

    private void quizActivity2(){
        Intent intent = new Intent(this, QuizActivity.class);
        startActivity(intent);
        finish();
    }

    private void mainMenuActivity2(){
        finish();
    }
}

package com.example.trafficregulationsquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mScoreView;
    private TextView mWrongAnswersView;
    private Button mButtonChoice1, mButtonChoice2, mButtonChoice3, mButtonChoice4;
    private ImageView mImgQuestionView;
    private GradientDrawable mGradientDrawable1, mGradientDrawable2, mGradientDrawable3, mGradientDrawable4;

    private Handler handler = new Handler();
    private String mAnswer;
    private int mScore = 0;
    private int mWrongAnswers = 0;
    private int mQuestionNumber = 0;
    public ArrayList<Integer> questions;
    public ArrayList <Integer> variants;

    private MediaPlayer correctAudio, wrongAudio, btn_clicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1image_4answers);

        mImgQuestionView = (ImageView) findViewById(R.id.img_question);
        mScoreView = (TextView) findViewById(R.id.score);
        mWrongAnswersView = (TextView) findViewById(R.id.wrong_answers);
        TextView mQuestionView = (TextView) findViewById(R.id.txt_question);
        mButtonChoice1 = (Button) findViewById(R.id.choice1);
        mButtonChoice2 = (Button) findViewById(R.id.choice2);
        mButtonChoice3 = (Button) findViewById(R.id.choice3);
        mButtonChoice4 = (Button) findViewById(R.id.choice4);
        ImageButton home = (ImageButton) findViewById(R.id.home);
        mGradientDrawable1 = (GradientDrawable) mButtonChoice1.getBackground().mutate();
        mGradientDrawable2 = (GradientDrawable) mButtonChoice2.getBackground().mutate();
        mGradientDrawable3 = (GradientDrawable) mButtonChoice3.getBackground().mutate();
        mGradientDrawable4 = (GradientDrawable) mButtonChoice4.getBackground().mutate();

        questions = new ArrayList<>();
        variants = new ArrayList<>();

        for (int i = 0; i < 21; i++) {
            questions.add(i);
        }

        Collections.shuffle(questions);


        for (int i = 0; i < 4; i++) {
            variants.add(i);
        }

        Collections.shuffle(variants);

        mQuestionView.setText("Что изображено на знаке?");
        correctAudio = MediaPlayer.create(this, R.raw.correct);
        wrongAudio = MediaPlayer.create(this, R.raw.wrong);
        btn_clicked = MediaPlayer.create(this, R.raw.button_clicked);

        updateQuestion();

        mButtonChoice1.setOnClickListener(this);
        mButtonChoice2.setOnClickListener(this);
        mButtonChoice3.setOnClickListener(this);
        mButtonChoice4.setOnClickListener(this);
        home.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.home:
                btn_clicked.start();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        home();
                    }
                }, 100);
                break;

            case R.id.choice1:

                if (mButtonChoice1.getText() == mAnswer){
                    mGradientDrawable1.setColor(Color.GREEN);
                    correctChoice();
                } else {
                    mGradientDrawable1.setColor(Color.RED);
                    wrongChoice();
                }
                break;

            case R.id.choice2:

                if (mButtonChoice2.getText() == mAnswer){
                    mGradientDrawable2.setColor(Color.GREEN);
                    correctChoice();
                } else {
                    mGradientDrawable2.setColor(Color.RED);
                    wrongChoice();
                }
                break;

            case R.id.choice3:

                if (mButtonChoice3.getText() == mAnswer){
                    mGradientDrawable3.setColor(Color.GREEN);
                    correctChoice();
                } else {
                    mGradientDrawable3.setColor(Color.RED);
                    wrongChoice();
                }
                break;

            case R.id.choice4:

                if (mButtonChoice4.getText() == mAnswer){
                    mGradientDrawable4.setColor(Color.GREEN);
                    correctChoice();
                } else {
                    mGradientDrawable4.setColor(Color.RED);
                    wrongChoice();
                }
                break;
        }
    }


    private void updateQuestion() {
        mButtonChoice1.setText(getChoice1(mQuestionNumber));
        mButtonChoice2.setText(getChoice2(mQuestionNumber));
        mButtonChoice3.setText(getChoice3(mQuestionNumber));
        mButtonChoice4.setText(getChoice4(mQuestionNumber));

        mAnswer = getCorrectAnswer(mQuestionNumber);
        mQuestionNumber++;

        switch (mAnswer){
            case  "Двустороннее движение":
                mImgQuestionView.setImageResource(R.drawable.two_way_traffic);
                break;
            case        "Дети":
                mImgQuestionView.setImageResource(R.drawable.children);
                break;
            case        "Дикие животные":
                mImgQuestionView.setImageResource(R.drawable.wild_animals);
                break;
            case        "Дорожные работы":
                mImgQuestionView.setImageResource(R.drawable.road_works);
                break;
            case        "Ж/Д переезд со шлагбаумом":
                mImgQuestionView.setImageResource(R.drawable.railroad_crossing_with_a_barrier);
                break;
            case        "Ж/Д переезд без шлагбаума":
                mImgQuestionView.setImageResource(R.drawable.railroad_crossing_without_a_barrier);
                break;
            case        "Искуственная неровность":
                mImgQuestionView.setImageResource(R.drawable.artificial_roughness);
                break;
            case        "Пересечение с велосипедной дорожкой":
                mImgQuestionView.setImageResource(R.drawable.intersection_with_a_bike_path);
                break;
            case        "Пересечение с круговым движением":
                mImgQuestionView.setImageResource(R.drawable.roundabout);
                break;
            case        "Скользкая дорога":
                mImgQuestionView.setImageResource(R.drawable.slippy_road);
                break;
            case        "Въезд запрещён":
                mImgQuestionView.setImageResource(R.drawable.no_entry);
                break;
            case        "Конец зоны всех ограничений":
                mImgQuestionView.setImageResource(R.drawable.all_restrictions_end);
                break;
            case        "Обгон запрещён":
                mImgQuestionView.setImageResource(R.drawable.no_overtaking);
                break;
            case        "Остановка запрещена":
                mImgQuestionView.setImageResource(R.drawable.no_stopping);
                break;
            case        "Движение всех механических транспортных средств запрещено":
                mImgQuestionView.setImageResource(R.drawable.no_motor_vehicles);
                break;
            case        "Пешеходный переход":
                mImgQuestionView.setImageResource(R.drawable.crosswalk);
                break;
            case        "Движение запрещено":
                mImgQuestionView.setImageResource(R.drawable.road_closed);
                break;
            case        "Разворот запрещён":
                mImgQuestionView.setImageResource(R.drawable.no_turn);
                break;
            case        "Ограничение максимальной скорости":
                mImgQuestionView.setImageResource(R.drawable.speed_limit);
                break;
            case        "Стоянка запрещена":
                mImgQuestionView.setImageResource(R.drawable.no_parking);
                break;
            case        "Стоянка запрещена по чётным числам месяца":
                mImgQuestionView.setImageResource(R.drawable.no_parking_on_even_days);
                break;
        }

    }

    public void correctChoice() {
        mButtonChoice1.setEnabled(false);
        mButtonChoice2.setEnabled(false);
        mButtonChoice3.setEnabled(false);
        mButtonChoice4.setEnabled(false);
        mScore++;
        updateScore();
        correctAudio.start();
        if (mQuestionNumber==21) {

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mGradientDrawable1.setColor(Color.rgb(49, 90, 115));
                    mGradientDrawable2.setColor(Color.rgb(49, 90, 115));
                    mGradientDrawable3.setColor(Color.rgb(49, 90, 115));
                    mGradientDrawable4.setColor(Color.rgb(49, 90, 115));
                    mButtonChoice1.setEnabled(true);
                    mButtonChoice2.setEnabled(true);
                    mButtonChoice3.setEnabled(true);
                    mButtonChoice4.setEnabled(true);
                    finishAct();
                }
            }, 1000);
        } else {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mGradientDrawable1.setColor(Color.rgb(49, 90, 115));
                    mGradientDrawable2.setColor(Color.rgb(49, 90, 115));
                    mGradientDrawable3.setColor(Color.rgb(49, 90, 115));
                    mGradientDrawable4.setColor(Color.rgb(49, 90, 115));
                    mButtonChoice1.setEnabled(true);
                    mButtonChoice2.setEnabled(true);
                    mButtonChoice3.setEnabled(true);
                    mButtonChoice4.setEnabled(true);
                    updateQuestion();
                }
            }, 1000);
        }
    }

    public void wrongChoice() {
        mButtonChoice1.setEnabled(false);
        mButtonChoice2.setEnabled(false);
        mButtonChoice3.setEnabled(false);
        mButtonChoice4.setEnabled(false);
        mWrongAnswers++;
        updateWrongAnswers();
        wrongAudio.start();

        if (mButtonChoice1.getText() == mAnswer)
            mGradientDrawable1.setColor(Color.GREEN);
        else if (mButtonChoice2.getText() == mAnswer)
            mGradientDrawable2.setColor(Color.GREEN);
        else if(mButtonChoice3.getText() == mAnswer)
            mGradientDrawable3.setColor(Color.GREEN);
        else
            mGradientDrawable4.setColor(Color.GREEN);

        if (mQuestionNumber==21) {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mGradientDrawable1.setColor(Color.rgb(49, 90, 115));
                    mGradientDrawable2.setColor(Color.rgb(49, 90, 115));
                    mGradientDrawable3.setColor(Color.rgb(49, 90, 115));
                    mGradientDrawable4.setColor(Color.rgb(49, 90, 115));
                    mButtonChoice1.setEnabled(true);
                    mButtonChoice2.setEnabled(true);
                    mButtonChoice3.setEnabled(true);
                    mButtonChoice4.setEnabled(true);
                    finishAct();
                }
            }, 1000);
        } else {

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mGradientDrawable1.setColor(Color.rgb(49, 90, 115));
                    mGradientDrawable2.setColor(Color.rgb(49, 90, 115));
                    mGradientDrawable3.setColor(Color.rgb(49, 90, 115));
                    mGradientDrawable4.setColor(Color.rgb(49, 90, 115));
                    mButtonChoice1.setEnabled(true);
                    mButtonChoice2.setEnabled(true);
                    mButtonChoice3.setEnabled(true);
                    mButtonChoice4.setEnabled(true);

                    updateQuestion();
                }
            }, 1000);
        }
    }

    public void home(){
        finish();
    }

    public void finishAct(){
        Intent intent = new Intent(this, FinishActivity.class);
        intent.putExtra("mScore", mScoreView.getText().toString());
        startActivity(intent);
        finish();
    }

    public void updateScore() {
        mScoreView.setText(mScore + "");
    }

    public void updateWrongAnswers() {
        mWrongAnswersView.setText(mWrongAnswers + "");
    }

    public String[][] mChoices = {
            {"Одностороннее движение", "Двустороннее движение", "Направление поворота", "Пересечение равнозначных дорог"},
            {"Дети", "Спортивная площадка", "Пешеходный переход", "Прекращение движения"},
            {"Заповедник", "Перегон скота", "Зона отдыха", "Дикие животные"},
            {"Дорожные работы", "Угольная шахта", "Ферма", "Строительство здания"},
            {"Частная собственность", "Ж/Д переезд со шлагбаумом", "Ж/Д переезд без шлагбаума", "Сельская местность"},
            {"Ж/Д переезд без шлагбаума", "Товарный поезд", "Пассажирский поезд", "Ж/Д станция"},
            {"Неровная дорога", "Искуственная неровность", "Сужение дороги", "Обочина"},
            {"Пересечение с велосипедной дорожкой", "Спортивный комплекс", "Велосипедный клуб", "Ремонт велосипедов"},
            {"Тоннель", "Пересечение равнозначных дорог", "Пересечение с круговым движением", "Переработка отходов"},
            {"Неровная дорога", "Скользкая дорога", "Опасный поворот", "Затор"},
            {"Остановка запрещена", "Движение механических транспортных средств запрещено", "Проезда нет", "Въезд запрещён"},
            {"Конец зоны всех ограничений", "Одностороннее движение", "Проезда нет", "Конец зоны запрета обгона"},
            {"Одностороннее движение", "Обгон запрещён", "Движение всех механических транспортных средств запрещено", "Движение запрещено только легковым транспортным средствам"},
            {"Стоянка запрещена", "Въезд запрещён", "Парковка", "Остановка запрещена"},
            {"Обгон запрещён", "Движение разрешено только легковым транспортным средствам", "Движение запрещено только легковым транспортным средствам", "Движение всех механических транспортных средств запрещено"},
            {"Движение пешеходов запрещено", "Дети", "Пешеходный переход", "Подземный переход"},
            {"Дальше проезда нет", "Движение запрещено", "Конец зоны предыдущего ограничения", "Стоянка запрещена"},
            {"Разворот запрещён", "Поворот налево запрещён", "Одностороннее движение", "Поворот направо запрещён"},
            {"Ограничение минимальной дистанции", "Ограничение максимального веса груза", "Ограничение минимальной скорости", "Ограничение максимальной скорости"},
            {"Дальше дороги нет", "Стоянка запрещена", "Остановка запрещена", "Пересечение двух дорог"},
            {"Стоянка запрещена по чётным числам месяца", "Стоянка запрещена по нечётным числам месяца", "Стоянка запрещена", "Одностороннее движение"},
    };

       public String[] mCorrectAnswers = {
            "Двустороннее движение",
            "Дети",
            "Дикие животные",
            "Дорожные работы",
            "Ж/Д переезд со шлагбаумом",
            "Ж/Д переезд без шлагбаума",
            "Искуственная неровность",
            "Пересечение с велосипедной дорожкой",
            "Пересечение с круговым движением",
            "Скользкая дорога",
            "Въезд запрещён",
            "Конец зоны всех ограничений",
            "Обгон запрещён",
            "Остановка запрещена",
            "Движение всех механических транспортных средств запрещено",
            "Пешеходный переход",
            "Движение запрещено",
            "Разворот запрещён",
            "Ограничение максимальной скорости",
            "Стоянка запрещена",
            "Стоянка запрещена по чётным числам месяца"
    };

    public String getChoice1(int a) {

        return mChoices[questions.get(a)][variants.get(0)];
 //       return mChoices[quests[a]][vars[0]];
    }

    public String getChoice2(int a) {

        return mChoices[questions.get(a)][variants.get(1)];
  //      return mChoices[quests[a]][vars[1]];
    }

    public String getChoice3(int a) {

        return mChoices[questions.get(a)][variants.get(2)];
   //     return mChoices[quests[a]][vars[2]];
    }
    public String getChoice4(int a) {

        return mChoices[questions.get(a)][variants.get(3)];
    //    return mChoices[quests[a]][vars[3]];
    }

    public String getCorrectAnswer(int a) {

        return mCorrectAnswers[questions.get(a)];
      //  return mCorrectAnswers[quests[a]];
    }
}
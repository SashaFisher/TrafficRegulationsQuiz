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

public class SecondQuizActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mScoreView2, mWrongAnswersView2, mQuestionView2;
    private Button mButtonChoice12, mButtonChoice22, mButtonChoice32, mButtonChoice42;
    private GradientDrawable mGradientDrawable12, mGradientDrawable22, mGradientDrawable32, mGradientDrawable42;
    //private QuizActivity quizActivity = new QuizActivity();

    private Handler handler2 = new Handler();
    private String mAnswer2;
    private int mScore2 = 0;
    private int mWrongAnswers2 = 0;
    private int mQuestionNumber2 = 0;
    public ArrayList<Integer> questions2;
    public ArrayList <Integer> variants2;

    private MediaPlayer correctAudio2, wrongAudio2, btn_clicked2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1question_4answers);

        mScoreView2 = (TextView) findViewById(R.id.score2);
        mWrongAnswersView2 = (TextView) findViewById(R.id.wrong_answers2);
        mQuestionView2 = (TextView) findViewById(R.id.txt_question2);
        mButtonChoice12 = (Button) findViewById(R.id.choice12);
        mButtonChoice22 = (Button) findViewById(R.id.choice22);
        mButtonChoice32 = (Button) findViewById(R.id.choice32);
        mButtonChoice42 = (Button) findViewById(R.id.choice42);
        ImageButton home2 = (ImageButton) findViewById(R.id.home2);
        mGradientDrawable12 = (GradientDrawable) mButtonChoice12.getBackground().mutate();
        mGradientDrawable22 = (GradientDrawable) mButtonChoice22.getBackground().mutate();
        mGradientDrawable32 = (GradientDrawable) mButtonChoice32.getBackground().mutate();
        mGradientDrawable42 = (GradientDrawable) mButtonChoice42.getBackground().mutate();

        questions2 = new ArrayList<>();
        variants2 = new ArrayList<>();

        for (int i = 0; i < 14; i++) {
            questions2.add(i);
        }

        Collections.shuffle(questions2);


        for (int i = 0; i < 4; i++) {
            variants2.add(i);
        }

        Collections.shuffle(variants2);

        correctAudio2 = MediaPlayer.create(this, R.raw.correct);
        wrongAudio2 = MediaPlayer.create(this, R.raw.wrong);
        btn_clicked2 = MediaPlayer.create(this, R.raw.button_clicked);

        updateQuestion2();

        mButtonChoice12.setOnClickListener(this);
        mButtonChoice22.setOnClickListener(this);
        mButtonChoice32.setOnClickListener(this);
        mButtonChoice42.setOnClickListener(this);

        home2.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.home2:
                btn_clicked2.start();
                handler2.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        home2();
                    }
                }, 100);
                break;

            case R.id.choice12:

                if (mButtonChoice12.getText() == mAnswer2){
                 //   mButtonChoice1.setBackgroundColor(Color.GREEN);
                    mGradientDrawable12.setColor(Color.GREEN);
                    correctChoice2();
                } else {
                 //   mButtonChoice1.setBackgroundColor(Color.RED);
                    mGradientDrawable12.setColor(Color.RED);
                    wrongChoice2();
                }
                break;

            case R.id.choice22:

                if (mButtonChoice22.getText() == mAnswer2){
                   // mButtonChoice2.setBackgroundColor(Color.GREEN);
                   mGradientDrawable22.setColor(Color.GREEN);
                    correctChoice2();
                } else {
                  //  mButtonChoice2.setBackgroundColor(Color.RED);
                    mGradientDrawable22.setColor(Color.RED);
                    wrongChoice2();
                }
                break;

            case R.id.choice32:

                if (mButtonChoice32.getText() == mAnswer2){
                  //  mButtonChoice3.setBackgroundColor(Color.GREEN);
                    mGradientDrawable32.setColor(Color.GREEN);
                    correctChoice2();
                } else {
                  //  mButtonChoice3.setBackgroundColor(Color.RED);
                    mGradientDrawable32.setColor(Color.RED);
                    wrongChoice2();
                }
                break;

            case R.id.choice42:

                if (mButtonChoice42.getText() == mAnswer2){
                  //  mButtonChoice4.setBackgroundColor(Color.GREEN);
                    mGradientDrawable42.setColor(Color.GREEN);
                    correctChoice2();
                } else {
                   // mButtonChoice4.setBackgroundColor(Color.RED);
                    mGradientDrawable42.setColor(Color.RED);
                    wrongChoice2();
                }
                break;
        }
    }


    private void updateQuestion2() {
        mButtonChoice12.setText(getChoice12(mQuestionNumber2));
        mButtonChoice22.setText(getChoice22(mQuestionNumber2));
        mButtonChoice32.setText(getChoice32(mQuestionNumber2));
        mButtonChoice42.setText(getChoice42(mQuestionNumber2));

        String mQuestion2 = getQuestion2(mQuestionNumber2);
        mQuestionView2.setText(mQuestion2);
        mAnswer2 = getCorrectAnswer2(mQuestionNumber2);
        mQuestionNumber2++;

    }

    public void correctChoice2() {
        mButtonChoice12.setEnabled(false);
        mButtonChoice22.setEnabled(false);
        mButtonChoice32.setEnabled(false);
        mButtonChoice42.setEnabled(false);
        mScore2++;
        updateScore2();
        correctAudio2.start();
        if (mQuestionNumber2==14) {

            handler2.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mGradientDrawable12.setColor(Color.rgb(49, 90, 115));
                    mGradientDrawable22.setColor(Color.rgb(49, 90, 115));
                    mGradientDrawable32.setColor(Color.rgb(49, 90, 115));
                    mGradientDrawable42.setColor(Color.rgb(49, 90, 115));
                    /*mButtonChoice1.setBackgroundColor(Color.rgb(49, 90, 115));
                    mButtonChoice2.setBackgroundColor(Color.rgb(49, 90, 115));
                    mButtonChoice3.setBackgroundColor(Color.rgb(49, 90, 115));
                    mButtonChoice4.setBackgroundColor(Color.rgb(49, 90, 115));*/
                    mButtonChoice12.setEnabled(true);
                    mButtonChoice22.setEnabled(true);
                    mButtonChoice32.setEnabled(true);
                    mButtonChoice42.setEnabled(true);
                    finishAct2();
                }
            }, 1000);
        } else {
            handler2.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mGradientDrawable12.setColor(Color.rgb(49, 90, 115));
                    mGradientDrawable22.setColor(Color.rgb(49, 90, 115));
                    mGradientDrawable32.setColor(Color.rgb(49, 90, 115));
                    mGradientDrawable42.setColor(Color.rgb(49, 90, 115));
                   /* mButtonChoice1.setBackgroundColor(Color.rgb(49, 90, 115));
                    mButtonChoice2.setBackgroundColor(Color.rgb(49, 90, 115));
                    mButtonChoice3.setBackgroundColor(Color.rgb(49, 90, 115));
                    mButtonChoice4.setBackgroundColor(Color.rgb(49, 90, 115));*/
                    mButtonChoice12.setEnabled(true);
                    mButtonChoice22.setEnabled(true);
                    mButtonChoice32.setEnabled(true);
                    mButtonChoice42.setEnabled(true);
                    updateQuestion2();
                }
            }, 1000);
        }
    }

    public void wrongChoice2() {
        mButtonChoice12.setEnabled(false);
        mButtonChoice22.setEnabled(false);
        mButtonChoice32.setEnabled(false);
        mButtonChoice42.setEnabled(false);
        mWrongAnswers2++;
        updateWrongAnswers2();
        wrongAudio2.start();

        if (mButtonChoice12.getText() == mAnswer2)
            //mButtonChoice1.setBackgroundColor(Color.GREEN);
            mGradientDrawable12.setColor(Color.GREEN);
        else if (mButtonChoice22.getText() == mAnswer2)
       //     mButtonChoice2.setBackgroundColor(Color.GREEN);
            mGradientDrawable22.setColor(Color.GREEN);
        else if(mButtonChoice32.getText() == mAnswer2)
     //       mButtonChoice3.setBackgroundColor(Color.GREEN);
            mGradientDrawable32.setColor(Color.GREEN);
        else
       //     mButtonChoice4.setBackgroundColor(Color.GREEN);
            mGradientDrawable42.setColor(Color.GREEN);

        if (mQuestionNumber2==14) {
            handler2.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mGradientDrawable12.setColor(Color.rgb(49, 90, 115));
                    mGradientDrawable22.setColor(Color.rgb(49, 90, 115));
                    mGradientDrawable32.setColor(Color.rgb(49, 90, 115));
                    mGradientDrawable42.setColor(Color.rgb(49, 90, 115));
                    /*mButtonChoice1.setBackgroundColor(Color.rgb(49, 90, 115));
                    mButtonChoice2.setBackgroundColor(Color.rgb(49, 90, 115));
                    mButtonChoice3.setBackgroundColor(Color.rgb(49, 90, 115));
                    mButtonChoice4.setBackgroundColor(Color.rgb(49, 90, 115));*/
                    mButtonChoice12.setEnabled(true);
                    mButtonChoice22.setEnabled(true);
                    mButtonChoice32.setEnabled(true);
                    mButtonChoice42.setEnabled(true);
                    finishAct2();
                }
            }, 1000);
        } else {

            handler2.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mGradientDrawable12.setColor(Color.rgb(49, 90, 115));
                    mGradientDrawable22.setColor(Color.rgb(49, 90, 115));
                    mGradientDrawable32.setColor(Color.rgb(49, 90, 115));
                    mGradientDrawable42.setColor(Color.rgb(49, 90, 115));
                   /* mButtonChoice1.setBackgroundColor(Color.rgb(49, 90, 115));
                    mButtonChoice2.setBackgroundColor(Color.rgb(49, 90, 115));
                    mButtonChoice3.setBackgroundColor(Color.rgb(49, 90, 115));
                    mButtonChoice4.setBackgroundColor(Color.rgb(49, 90, 115));*/
                    mButtonChoice12.setEnabled(true);
                    mButtonChoice22.setEnabled(true);
                    mButtonChoice32.setEnabled(true);
                    mButtonChoice42.setEnabled(true);

                    updateQuestion2();
                }
            }, 1000);
        }
    }

    public void home2(){
        finish();
    }

    public void finishAct2(){
        Intent intent2 = new Intent(this, FinishActivity2.class);
        intent2.putExtra("mScore2", mScoreView2.getText().toString());
        startActivity(intent2);
        finish();
    }

    public void updateScore2() {
        mScoreView2.setText(mScore2 + "");
    }

    private void updateWrongAnswers2() {
        mWrongAnswersView2.setText(mWrongAnswers2 + "");
    }

    public String[] mQuestions2 = {
            "Эксплуатация каких транспортных средств запрещена, если у них отсутствуют аптечка и огнетушитель?",
            "Звуковым сигналом общей тревоги на железнодорожном переезде служат серия из:",
            "На автомагистрали запрещено:",
            "Что должен выполнять водитель при движении транспортного средства задним ходом?",
            "При движении по кривой дороге автомобиль более устойчив, если движение осуществляется:",
            "При каких условиях запрещается эксплуатация транспортных средств?",
            "На дороге с двухсторонним движением, имеющей три полосы, Вам необходимо повернуть направо. С какой полосы Вы осуществите данный маневр?",
            "В каких местах разрешается стоянка транспортных средств под углом к краю проезжей части?",
            "С какой максимальной скоростью разрешается движение легковых автомобилей на участках дорог вне населенных пунктов?",
            "Вы остановились на подъеме в ожидании разрешающего сигнала светофора. При этом удерживать автомобиль на месте лучше всего:",
            "В каких случаях разрешается буксировка транспортного средства при отсутствии водителя за рулем буксируемого транспортного средства?",
            "В каких случаях Вы можете наезжать на прерывистые линии разметки, разделяющие проезжую часть на полосы движения?",
            "Какой неподвижный объект, не позволяющий продолжить движение по полосе, не относится к понятию \"Препятствие\"?",
            "Водитель обязан подавать сигналы световыми указателями поворота (рукой):"
    };

    public String[][] mChoices2 = {
            {"Только легковых автомобилей",
                    "Только автобусов",
                    "Только грузовых автомобилей",
                    "Всех указанных транспортных средств"},
            {"Двух длинных и двух коротких сигналов",
                    "Одного длинного и трех коротких сигналов",
                    "Трех длинных и трех коротких сигналов",
                    "Трех длинных и одного короткого сигнала"},
            {"Разворот и въезд в разрывы разделительной полосы",
                    "Движение задним ходом",
                    "Остановка вне специальных площадок для стоянки, обозначенных знаком \"Место стоянки\" или \"Место отдыха\"",
                    "Все перечисленные действия"},
            {"Не создавать помех другим участникам движения. Для обеспечения безопасности движения он, при необходимости, должен прибегнуть к помощи других лиц",
                    "Прибегнуть к помощи других лиц",
                    "Включить задние противотуманные фонари, если они имеются на транспортном средстве",
                    "Включить габаритные огни"},
            {"С включенной передачей",
                    "С выключенной передачей",
                    "С увеличением скорости",
                    "C уменьшением скорости"},
            {"Подтекает жидкость из системы гидравлических тормозов",
                    "Не действует рабочая тормозная система",
                    "Компрессор не обеспечивает установленного давления в системе пневматических тормозов",
                    "При всех указанных условиях"},
            {"С правой полосы",
                    "Со средней полосы",
                    "С правой или средней полосы",
                    "Со средней полосы, но лишь когда занята правая полоса"},
            {"На дорогах с двумя полосами движения в каждом направлении",
                    "На дорогах с тремя и более полосами движения в каждом направлении",
                    "Только на дорогах с односторонним движением",
                    "На расширенных участках проезжей части, с условием, что не будет создана помеха другим участникам движения"},
            {"110 км/ч",
                    "100 км/ч",
                    "90 км/ч",
                    "80 км/ч"},
            {"Стояночным тормозом",
                    "За счет пробуксовки сцепления при включенной первой передаче",
                    "Выключенным двигателем, с включенной пониженной передачей",
                    "Рабочим тормозом"},
            {"Во всех случаях",
                    "При буксировке с помощью гибкого или жесткого буксирного устройства",
                    "В случае, когда конструкция жесткой сцепки обеспечивает следование буксируемого транспортного средства, по траектории буксирующего",
                    "При буксировке на жесткой сцепке"},
            {"Только при движении в темное время суток",
                    "Только при перестроении",
                    "Только если на дороге нет других транспортных средств",
                    "Во всех перечисленных случаях"},
            {"Неисправное или поврежденное транспортное средство",
                    "Посторонний предмет",
                    "Транспортное средство, остановившееся на этой полосе из-за образования затора",
                    "Дефект проезжей части"},
            {"Перед началом движения или перестроением",
                    "Перед поворотом или разворотом",
                    "Перед остановкой",
                    "Во всех перечисленных случаях"}
    };

    public String[] mCorrectAnswers2 = {
            "Всех указанных транспортных средств",
            "Одного длинного и трех коротких сигналов",
            "Все перечисленные действия",
            "Не создавать помех другим участникам движения. Для обеспечения безопасности движения он, при необходимости, должен прибегнуть к помощи других лиц",
            "С включенной передачей",
            "При всех указанных условиях",
            "С правой полосы",
            "На расширенных участках проезжей части, с условием, что не будет создана помеха другим участникам движения",
            "100 км/ч",
            "Стояночным тормозом",
            "В случае, когда конструкция жесткой сцепки обеспечивает следование буксируемого транспортного средства, по траектории буксирующего",
            "Только при перестроении",
            "Транспортное средство, остановившееся на этой полосе из-за образования затора",
            "Во всех перечисленных случаях"

    };

    public String getChoice12(int a) {

        return mChoices2[questions2.get(a)][variants2.get(0)];
        //       return mChoices[quests[a]][vars[0]];
    }

    public String getChoice22(int a) {

        return mChoices2[questions2.get(a)][variants2.get(1)];
        //      return mChoices[quests[a]][vars[1]];
    }

    public String getChoice32(int a) {

        return mChoices2[questions2.get(a)][variants2.get(2)];
        //     return mChoices[quests[a]][vars[2]];
    }
    public String getChoice42(int a) {

        return mChoices2[questions2.get(a)][variants2.get(3)];
        //    return mChoices[quests[a]][vars[3]];
    }

    public String getCorrectAnswer2(int a) {

        return mCorrectAnswers2[questions2.get(a)];
        //  return mCorrectAnswers[quests[a]];
    }
    public String getQuestion2(int a) {

        return mQuestions2[questions2.get(a)];
        //  return mCorrectAnswers[quests[a]];
    }




}
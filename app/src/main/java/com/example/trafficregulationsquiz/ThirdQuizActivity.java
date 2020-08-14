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

public class ThirdQuizActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mScoreView2, mWrongAnswersView2, mQuestionView2;
    private Button mButtonChoice12, mButtonChoice22, mButtonChoice32;
    private GradientDrawable mGradientDrawable12, mGradientDrawable22, mGradientDrawable32;

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
        setContentView(R.layout.activity_third_quiz);

        mScoreView2 = (TextView) findViewById(R.id.score2);
        mWrongAnswersView2 = (TextView) findViewById(R.id.wrong_answers2);
        mQuestionView2 = (TextView) findViewById(R.id.txt_question2);
        mButtonChoice12 = (Button) findViewById(R.id.choice12);
        mButtonChoice22 = (Button) findViewById(R.id.choice22);
        mButtonChoice32 = (Button) findViewById(R.id.choice32);
        ImageButton home2 = (ImageButton) findViewById(R.id.home2);
        mGradientDrawable12 = (GradientDrawable) mButtonChoice12.getBackground().mutate();
        mGradientDrawable22 = (GradientDrawable) mButtonChoice22.getBackground().mutate();
        mGradientDrawable32 = (GradientDrawable) mButtonChoice32.getBackground().mutate();

        questions2 = new ArrayList<>();
        variants2 = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            questions2.add(i);
        }

        Collections.shuffle(questions2);


        for (int i = 0; i < 3; i++) {
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
                    mGradientDrawable12.setColor(Color.GREEN);
                    correctChoice2();
                } else {
                    mGradientDrawable12.setColor(Color.RED);
                    wrongChoice2();
                }
                break;

            case R.id.choice22:

                if (mButtonChoice22.getText() == mAnswer2){
                    mGradientDrawable22.setColor(Color.GREEN);
                    correctChoice2();
                } else {
                    mGradientDrawable22.setColor(Color.RED);
                    wrongChoice2();
                }
                break;

            case R.id.choice32:

                if (mButtonChoice32.getText() == mAnswer2){
                    mGradientDrawable32.setColor(Color.GREEN);
                    correctChoice2();
                } else {
                    mGradientDrawable32.setColor(Color.RED);
                    wrongChoice2();
                }
                break;

        }
    }


    private void updateQuestion2() {
        mButtonChoice12.setText(getChoice12(mQuestionNumber2));
        mButtonChoice22.setText(getChoice22(mQuestionNumber2));
        mButtonChoice32.setText(getChoice32(mQuestionNumber2));

        String mQuestion2 = getQuestion2(mQuestionNumber2);
        mQuestionView2.setText(mQuestion2);
        mAnswer2 = getCorrectAnswer2(mQuestionNumber2);
        mQuestionNumber2++;

    }

    public void correctChoice2() {
        mButtonChoice12.setEnabled(false);
        mButtonChoice22.setEnabled(false);
        mButtonChoice32.setEnabled(false);
        mScore2++;
        updateScore2();
        correctAudio2.start();
        if (mQuestionNumber2==15) {

            handler2.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mGradientDrawable12.setColor(Color.rgb(49, 90, 115));
                    mGradientDrawable22.setColor(Color.rgb(49, 90, 115));
                    mGradientDrawable32.setColor(Color.rgb(49, 90, 115));
                    mButtonChoice12.setEnabled(true);
                    mButtonChoice22.setEnabled(true);
                    mButtonChoice32.setEnabled(true);
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
                    mButtonChoice12.setEnabled(true);
                    mButtonChoice22.setEnabled(true);
                    mButtonChoice32.setEnabled(true);
                    updateQuestion2();
                }
            }, 1000);
        }
    }

    public void wrongChoice2() {
        mButtonChoice12.setEnabled(false);
        mButtonChoice22.setEnabled(false);
        mButtonChoice32.setEnabled(false);
        mWrongAnswers2++;
        updateWrongAnswers2();
        wrongAudio2.start();

        if (mButtonChoice12.getText() == mAnswer2)
            mGradientDrawable12.setColor(Color.GREEN);
        else if (mButtonChoice22.getText() == mAnswer2)
            mGradientDrawable22.setColor(Color.GREEN);
        else if(mButtonChoice32.getText() == mAnswer2)
            mGradientDrawable32.setColor(Color.GREEN);

        if (mQuestionNumber2==15) {
            handler2.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mGradientDrawable12.setColor(Color.rgb(49, 90, 115));
                    mGradientDrawable22.setColor(Color.rgb(49, 90, 115));
                    mGradientDrawable32.setColor(Color.rgb(49, 90, 115));
                    mButtonChoice12.setEnabled(true);
                    mButtonChoice22.setEnabled(true);
                    mButtonChoice32.setEnabled(true);
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
                    mButtonChoice12.setEnabled(true);
                    mButtonChoice22.setEnabled(true);
                    mButtonChoice32.setEnabled(true);

                    updateQuestion2();
                }
            }, 1000);
        }
    }

    public void home2(){
       finish();
    }

    public void finishAct2(){
        Intent intent3 = new Intent(this, FinishActivity3.class);
        intent3.putExtra("mScore3", mScoreView2.getText().toString());
        startActivity(intent3);
        finish();
    }

    public void updateScore2() {
        mScoreView2.setText(mScore2 + "");
    }

    private void updateWrongAnswers2() {
        mWrongAnswersView2.setText(mWrongAnswers2 + "");
    }

    public String[] mQuestions2 = {
           "Как обеспечить восстановление и поддержание проходимости дыхательных путей пострадавшего при подготовке к проведению сердечно-легочной реанимации?",
           "Какова первая помощь при черепно-мозговой травме, сопровождающейся ранением волосистой части головы?",
           "Как определить наличие дыхания у потерявшего сознание пострадавшего?",
           "В каких случаях пострадавшего следует извлекать из салона автомобиля?",
           "Как следует уложить пострадавшего при потере им сознания и наличии дыхания и кровообращения для оказания первой помощи? ",
           "На какой срок может быть наложен кровоостанавливающий жгут?",
           "В каких случаях следует начинать сердечно-легочную реанимацию пострадавшего?",
           "Как остановить кровотечение при ранении вены и некрупных артерий?",
           "Разрешено ли давать пострадавшему лекарственные средства при оказании ему первой помощи?",
           "Что следует сделать для оказания первой помощи пострадавшему при повреждении позвоночника?",
           "Как оказать первую помощь при отморожении и переохлаждении?",
           "В медицинской аптечке транспортного средства имеется «Валидол». Он применяется при:",
           "Что необходимо сделать при переломе ключицы у пострадавшего?",
           "Как оказать первую медицинскую помощь при отравлении парами бензина?",
           "Что необходимо сделать при переломе рёбер у пострадавшего?"
    };

    public String[][] mChoices2 = {
            {"Уложить пострадавшего на спину на твердую поверхность, запрокинуть ему голову, положить одну руку на лоб, приподняв подбородок двумя пальцами другой руки",
                    "Уложить пострадавшего на бок, наклонить его голову к груди",
                    "Уложить пострадавшего на спину и, не запрокидывая ему голову, сжать щеки, чтобы раздвинуть губы и раскрыть рот"},
            {"Остановить кровотечение прямым давлением на рану и наложить давящую повязку. При потере сознания придать устойчивое боковое положение. По возможности, приложить к голове холод",
                    "Фиксировать шейный отдел позвоночника с помощью импровизированной шейной шины (воротника). На рану наложить стерильный ватный тампон, пострадавшего уложить на спину, приподняв ноги. По возможности, к голове приложить холод",
                    "Шейную шину не накладывать, рану заклеить медицинским пластырем, пострадавшего уложить на бок"},
            {"Взять пострадавшего за подбородок, запрокинуть голову и в течение 10 секунд проследить за движением его грудной клетки",
                    "Положить одну руку на лоб пострадавшего, двумя пальцами другой поднять подбородок и, запрокинув голову, наклониться к его лицу и в течение 10 секунд прислушаться к дыханию, постараться ощутить выдыхаемый воздух своей щекой, проследить за движением грудной клетки",
                    "Не запрокидывая головы пострадавшего, наклониться к его лицу и в течение 10 секунд прислушаться к дыханию, почувствовать его своей щекой, проследить за движением его грудной клетки"},
            {"При высокой вероятности опрокидывания автомобиля, пожара, взрыва или при потере потерпевшим сознания",
                    "При высокой вероятности опрокидывания автомобиля, пожара, взрыва, переохлаждения потерпевшего, при отсутствии у него сознания и дыхания, а также невозможности оказания первой помощи непосредственно в салоне автомобиля",
                    "При высокой вероятности опрокидывания автомобиля, пожара, взрыва или при обильном кровотечении либо черепно-мозговой травме"},
            {"На спину с подложенным под голову валиком",
                    "На спину с вытянутыми ногами",
                    "Придать пострадавшему устойчивое боковое положение, чтобы согнутые колени опирались о землю, а верхняя рука находилась под щекой"},
            {"Не более получаса в теплое время года и не более одного часа в холодное время года",
                    "Не более одного часа в теплое время года и не более получаса в холодное время года",
                    "Время наложения жгута не ограничено"},
            {"При наличии болей в области сердца и затрудненного дыхания",
                    "При отсутствии у пострадавшего сознания, независимо от наличия дыхания",
                    "При отсутствии у пострадавшего сознания, дыхания и кровообращения"},
            {"Наложить давящую повязку на место ранения",
                    "Наложить жгут выше места ранения",
                    "Наложить жгут ниже места ранения"},
            {"Разрешено",
                    "Разрешено в случае крайней необходимости",
                    "Запрещено"},
            {"Уложить пострадавшего на бок",
                    "Уложить пострадавшего на спину на ровную твердую поверхность",
                    "Уложить пострадавшего на спину, подложить под шею валик из одежды и приподнять ноги"},
            {"Растереть пораженные участки тела снегом или шерстью, затем их утеплить, дать алкоголь, переместить в теплое помещение",
                    "Утеплить пораженные участки тела и обездвижить их, укутать пострадавшего теплой одеждой или пледом, дать теплое питье, переместить в теплое помещение",
                    "Смазать пораженные участки тела кремом, наложить согревающий компресс и грелку, переместить в теплое помещение, дать теплое питье"},
            {"Обмороке",
                    "Головной боли",
                    "Болях в сердце"},
            {"Наложить холодный компресс на место перелома и потуже забинтовать",
                    "Подвесить руку на косынку или прибинтовать выпрямленную руку к туловищу",
                    "Подложить валик из бинта или ваты в подмышечную область и прибинтовать согнутую в локте руку к туловищу",},
            {"Вынести пострадавшего на свежий воздух, согреть, провести искусственное дыхание",
                    "Промыть желудок большим количеством жидкости",
                    "Вынести пострадавшего на свежий воздух и дать ему горячий чай"},
            {"Наложить шину со стороны перелома",
                    "Наложить холодный компресс на место перелома",
                    "Наложить тугую повязку на грудную клетку"},


    };

    public String[] mCorrectAnswers2 = {
           "Уложить пострадавшего на спину на твердую поверхность, запрокинуть ему голову, положить одну руку на лоб, приподняв подбородок двумя пальцами другой руки",
           "Остановить кровотечение прямым давлением на рану и наложить давящую повязку. При потере сознания придать устойчивое боковое положение. По возможности, приложить к голове холод",
           "Положить одну руку на лоб пострадавшего, двумя пальцами другой поднять подбородок и, запрокинув голову, наклониться к его лицу и в течение 10 секунд прислушаться к дыханию, постараться ощутить выдыхаемый воздух своей щекой, проследить за движением грудной клетки",
           "При высокой вероятности опрокидывания автомобиля, пожара, взрыва, переохлаждения потерпевшего, при отсутствии у него сознания и дыхания, а также невозможности оказания первой помощи непосредственно в салоне автомобиля",
           "Придать пострадавшему устойчивое боковое положение, чтобы согнутые колени опирались о землю, а верхняя рука находилась под щекой",
           "Не более одного часа в теплое время года и не более получаса в холодное время года",
           "При отсутствии у пострадавшего сознания, дыхания и кровообращения",
           "Наложить давящую повязку на место ранения",
           "Запрещено",
           "Уложить пострадавшего на спину на ровную твердую поверхность",
           "Утеплить пораженные участки тела и обездвижить их, укутать пострадавшего теплой одеждой или пледом, дать теплое питье, переместить в теплое помещение",
           "Болях в сердце",
           "Подложить валик из бинта или ваты в подмышечную область и прибинтовать согнутую в локте руку к туловищу",
           "Вынести пострадавшего на свежий воздух, согреть, провести искусственное дыхание",
           "Наложить тугую повязку на грудную клетку"
    };

    public String getChoice12(int a) {

        return mChoices2[questions2.get(a)][variants2.get(0)];
    }

    public String getChoice22(int a) {

        return mChoices2[questions2.get(a)][variants2.get(1)];
    }

    public String getChoice32(int a) {

        return mChoices2[questions2.get(a)][variants2.get(2)];
    }

    public String getCorrectAnswer2(int a) {

        return mCorrectAnswers2[questions2.get(a)];
    }
    public String getQuestion2(int a) {

        return mQuestions2[questions2.get(a)];
    }
}

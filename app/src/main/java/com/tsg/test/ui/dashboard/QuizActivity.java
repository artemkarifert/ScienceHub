package com.tsg.test.ui.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.tsg.test.End;
import com.tsg.test.Question;
import com.tsg.test.R;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;

public class QuizActivity extends AppCompatActivity {
    ArrayList<Question> questions = new ArrayList<>();

    int time = 10;
    int score = 0;
    int correct = 0;
    Timer mTimer = new Timer();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        MyTimerTask mMyTimerTask = new MyTimerTask();
        mTimer.schedule(mMyTimerTask, 1000, 1000);

        questions.add(new Question("География", "Где надо построить дом, чтобы все его окна выходили на север?", "На Южном полюсе", new String[]{"На северном полюсе", "В северном полушарии", "В любом месте"}));
        questions.add(new Question("География", "При пересечении чего моряки, по традиции, устраивают «праздник Нептуна»?", "Экватора", new String[]{"Границы океана", "Нептуна", "Полюса"}));
        questions.add(new Question("География", "Океан, занимающий одну треть поверхности земного шара?", "Тихий", new String[]{"Южный", "Индийский", "Атлантический"}));
        questions.add(new Question("География", "Морской путь, в какую страну искала экспедиция Х.Колумба, доплыв вместо этого до Америки?", "Индия", new String[]{"Египет", "Китай", "Австралия"}));
        questions.add(new Question("История", "Главный бог славян был", "Перун", new String[]{"Велес", "Даждьбог", "Зевс"}));
        questions.add(new Question("История", "Ермак осваил эту территорию", "Сибирь", new String[]{"Дальний восток", "Японию", "Америку"}));
        questions.add(new Question("История", "От какой империи Россия унаследовала двуглавого орла на гербе?", "Византия", new String[]{"Древний Рим", "Англия", "Древняя Греция"}));
        questions.add(new Question("История", "Когда Москва была впервые упомянута в летописи?", "1147г", new String[]{"980г", "1324г", "1271г"}));
        questions.add(new Question("История", "Какому богу были посвящены Олимпийские игры в Древней Греции?", "Зевсу", new String[]{"Посейдону", "Аиду", "Гераклу"}));
        questions.add(new Question("Биохимия", "Химическая формула мела?", "СаСО3", new String[]{"Ca(OH)2", "K2SO4", "Ca"}));
        questions.add(new Question("Биохимия", "Самый легкий газ?", "Водород", new String[]{"Гелий", "Кислород", "Фтор"}));
        questions.add(new Question("Биохимия", "Что И.П. Павлов назвал «изумительной пищей», приготовленной самой природой?", "Молоко", new String[]{"Воду", "Овощи", "Воздух"}));
        questions.add(new Question("Биохимия", "Что изучает антропология?", "Человека", new String[]{"Растения", "Животных", "Бактерии"}));
        questions.add(new Question("Биохимия", "Элемент в переводе с греческого «несущий свет»", "Фосфор", new String[]{"Фтор", "Неон", "Фотон"}));
        questions.add(new Question("Исскуство", "Кому посвятил И.С.Тургенев свой наиболее известный роман Отцы и дети?", "В.Г.Белинскому", new String[]{"А.И.Герцену", "П.Я.Чаадаеву", "В.А.Жуковскому"}));
        questions.add(new Question("Исскуство", "Кем по профессии был А.П.Чехов?", "Врач", new String[]{"Бакалейщик", "Юрист", "Учитель"}));
        questions.add(new Question("Исскуство", "Сколько сыновей было у Тараса Бульбы,главного героя одноименного романа Н.В.Гоголя?", "2", new String[]{"3", "4", "1"}));
        questions.add(new Question("Исскуство", "В переводе на русский это означает «мертвая натура»","Натюрморт", new String[]{"Портрет", "Пейзаж", "Акварель"}));
        questions.add(new Question("Исскуство", "Рисунок, выполненный карандашом или тушью?", "Графика", new String[]{"Набросок", "Портрет", "Натюрморт"}));
        questions.add(new Question("Физика", "Какой цвет имеют холодные звезды?", "Красный", new String[]{"Голубой", "Белый", "Черный"}));
        questions.add(new Question("Физика", "Какой древнегреческий ученый утверждал, что Земля - это шар?", "Пифагор", new String[]{"Аристотель", "Евклид", "Платон"}));
        questions.add(new Question("Физика", "Прибор для измерения силы", "Динамометр", new String[]{"Барометр", "Термометр", "Гигрометр"}));
        questions.add(new Question("Физика", "В каком созвездии находится Полярная звезда?", "В Большой Медведице", new String[]{"В Малой Медведице", "В созвездии Тельца", "В созвездии Рыбы"}));
        questions.add(new Question("Физика", "Какие частицы были открыты первыми?", "Электроны", new String[]{"Кварки", "Нейтроны", "Протоны"}));


        correct = generate();

        final Button first = findViewById(R.id.firstAnswer);
        final Button second = findViewById(R.id.secondAnswer);
        final Button third = findViewById(R.id.thirdAnswer);
        final Button fourth = findViewById(R.id.fourthAnswer);

        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comparison(1, first);
            }
        });

        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comparison(2, second);
            }
        });

        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comparison(3, third);
            }
        });

        fourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comparison(4, fourth);
            }
        });
    }

    public void comparison(int number, Button button) {
        TextView scoreView = findViewById(R.id.scoreView2);

        if(number == correct){
            score += 1;
            time += 2;


            button.setBackgroundResource(R.drawable.correct);
            button.setTextColor(Color.WHITE);
            scoreView.setText(Integer.toString(score));

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    correct = generate();
                }
            }, 2000);
        }
        else{
            Button button1;
            button.setBackgroundResource(R.drawable.uncorrect);
            button.setTextColor(Color.WHITE);

            if (correct == 1){
                button1 = findViewById(R.id.firstAnswer);
                button1.setBackgroundResource(R.drawable.correct);
                button1.setTextColor(Color.WHITE);
            }
            else if (correct == 2){
                button1 = findViewById(R.id.secondAnswer);
                button1.setBackgroundResource(R.drawable.correct);
                button1.setTextColor(Color.WHITE);
            }
            else if (correct == 3){
                button1 = findViewById(R.id.thirdAnswer);
                button1.setBackgroundResource(R.drawable.correct);
                button1.setTextColor(Color.WHITE);
            }
            else if (correct == 4){
                button1 = findViewById(R.id.fourthAnswer);
                button1.setBackgroundResource(R.drawable.correct);
                button1.setTextColor(Color.WHITE);
            }

            mTimer.cancel();
            mTimer.purge();

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    lose();
                }
            }, 2000);
        }
    }

    public int generate(){
        time = 11;
        int correctAnswer = 0;

        Random random = new Random();
        int questionNumber = random.nextInt(25);
        Question question = questions.get(questionNumber);

        TextView questionView = findViewById(R.id.question);
        questionView.setText(question.getBody());

        TextView category = findViewById(R.id.category);
        category.setText(question.getCategory());

        Stack<Button> buttons = new Stack<>();
        buttons.add((Button) findViewById(R.id.firstAnswer));
        buttons.add((Button) findViewById(R.id.secondAnswer));
        buttons.add((Button) findViewById(R.id.thirdAnswer));
        buttons.add((Button) findViewById(R.id.fourthAnswer));

        ArrayList<String> answers = new ArrayList<>();
        answers.add(question.getCorrectAnswer());
        answers.add(question.getUnCorrectAnswers()[0]);
        answers.add(question.getUnCorrectAnswers()[1]);
        answers.add(question.getUnCorrectAnswers()[2]);

        for (int i=4; i>0; i--){
            int j = random.nextInt(i);
            String currentAnswer = answers.get(j);
            Button currentButton = buttons.pop();

            currentButton.setText(currentAnswer);
            currentButton.setBackgroundResource(R.drawable.unselected);
            currentButton.setTextColor(getColor(R.color.colorText));

            if(currentAnswer.equals(question.getCorrectAnswer()))
                correctAnswer = i;

            answers.remove(j);
        }

        //header Color
        ImageView header = findViewById(R.id.headerBackground);

        if(question.getCategory().equals("География"))
            header.setImageResource(R.drawable.purple);
        else if(question.getCategory().equals("История"))
            header.setImageResource(R.drawable.yellow);
        else if(question.getCategory().equals("Биохимия"))
            header.setImageResource(R.drawable.green);
        else if(question.getCategory().equals("Исскуство"))
            header.setImageResource(R.drawable.surface);
        else if(question.getCategory().equals("Физика"))
            header.setImageResource(R.drawable.black);


        return correctAnswer;
    }

    class MyTimerTask extends TimerTask {

        @Override
        public void run() {
            final TextView timeView = findViewById(R.id.timeView2);

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    time -= 1;
                    timeView.setText(Integer.toString(time));

                    if(time <= 0) {
                        lose();
                        cancel();
                    }
                }
            });
        }
    }

    public void lose(){
        Intent intent = new Intent(QuizActivity.this, End.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("score", score);
        intent.putExtra("path", 2);
        startActivity(intent);
    }
}
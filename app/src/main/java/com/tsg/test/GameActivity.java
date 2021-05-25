package com.tsg.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class GameActivity extends AppCompatActivity {

    int time = 5;
    int score = 0;
    int answer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answer = generate();




        Timer mTimer = new Timer();
        MyTimerTask mMyTimerTask = new MyTimerTask();
        mTimer.schedule(mMyTimerTask, 1000, 1000);



        /*while (answer == 0) {
            generate();
        }*/

        Button one = findViewById(R.id.one);
        Button two = findViewById(R.id.two);
        Button three = findViewById(R.id.three);
        Button four = findViewById(R.id.four);
        Button five = findViewById(R.id.five);
        Button six = findViewById(R.id.six);
        Button seven = findViewById(R.id.seven);
        Button eight = findViewById(R.id.eight);
        Button nine = findViewById(R.id.nine);
        Button zero = findViewById(R.id.zero);
        final ImageButton delete = findViewById(R.id.del);
        final ImageButton done = findViewById(R.id.done);


        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendToText(1);
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendToText(2);
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendToText(3);
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendToText(4);
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendToText(5);
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendToText(6);
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendToText(7);
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendToText(8);
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendToText(9);
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendToText(0);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete();
            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView textView = findViewById(R.id.result);
                TextView scoreView = findViewById(R.id.scoreView);

                int result = Integer.parseInt((String) textView.getText());

                while (answer == 0)
                    answer = generate();



                if (textView.getText() != null){

                    if(answer == result){
                        time += 4;
                        score += 1;

                        answer = generate();

                        textView.setText("");
                        scoreView.setText(Integer.toString(score));
                    }

                    else {
                        //System.exit(0);
                    }

                }







            }
        });


    }

    public void sendToText(int number){
        TextView result = findViewById(R.id.result);

        if(result.length() < 6) {
            if (result.getText() != null) {
                String old = result.getText().toString();

                result.setText(old + number);

            } else {
                result.setText(number);
            }
        }
    }

    public void delete(){
        TextView result = findViewById(R.id.result);
        String old = result.getText().toString();

        if(old.length() > 0) {
            result.setText(old.substring(0, old.length() - 1));
        }
    }

    public int generate(){
        TextView result = findViewById(R.id.math);
        int answer = 0;

        Random random = new Random();

        int operation = random.nextInt(4);

        if(operation == 0){
            int firstNumber = rnd(5, 100);
            int secondNumber = rnd(5, 100);
            answer = firstNumber + secondNumber;

            String math = firstNumber + "+" + secondNumber;
            result.setText(math);
        }

        else if(operation == 1){
            int firstNumber = rnd(5, 100);
            int secondNumber = rnd(5, 100);

            if(firstNumber - secondNumber > 0){
                String math = firstNumber + "-" + secondNumber;
                result.setText(math);
                answer = firstNumber - secondNumber;
            }
            else {
                return 0;
            }

        }

        else if(operation == 2){
            int firstNumber = rnd(5, 10);
            int secondNumber = rnd(2, 10);
            answer = firstNumber * secondNumber;

            String math = firstNumber + "*" + secondNumber;
            result.setText(math);
        }

        else if(operation == 3){
            int firstNumber = rnd(5, 100);
            int secondNumber = rnd(2, 10);

            if(firstNumber % secondNumber == 0){
                String math = firstNumber + "/" + secondNumber;
                result.setText(math);
                answer = firstNumber / secondNumber;
            }

            else {
                return 0;
            }

        }

        return answer;
    }

    public int rnd(int min, int max)
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    class MyTimerTask extends TimerTask {

        @Override
        public void run() {
            final TextView timeView = findViewById(R.id.timeView);

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    time -= 1;
                    timeView.setText(Integer.toString(time));

                    /*if(time < 0) {
                        System.exit(0);
                    }*/
                }
            });
        }
    }

}
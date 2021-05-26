package com.tsg.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.tsg.test.ui.dashboard.QuizActivity;
import com.tsg.test.ui.home.HomeFragment;

public class End extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        Bundle arguments = getIntent().getExtras();
        String score = arguments.get("score").toString();
        final int path = arguments.getInt("path");

        ImageButton restart = findViewById(R.id.restart);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(path == 1){
                    Intent intent = new Intent(End.this, GameActivity.class);
                    startActivity(intent);
                }
                else if(path == 2){
                    Intent intent = new Intent(End.this, QuizActivity.class);
                    startActivity(intent);
                }

            }
        });

        ImageButton mainMenu = findViewById(R.id.home);
        mainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(End.this, MainActivity.class);
                startActivity(intent);
            }
        });

        TextView scoreView = findViewById(R.id.score);
        scoreView.setText(score);


    }
}
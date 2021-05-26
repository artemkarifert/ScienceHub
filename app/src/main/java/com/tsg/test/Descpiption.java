package com.tsg.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tsg.test.ui.dashboard.QuizActivity;

public class Descpiption extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descpiption);

        Bundle arguments = getIntent().getExtras();
        String name = arguments.get("name").toString();
        String descpiption = arguments.get("descpiption").toString();
        final int path = arguments.getInt("path");

        TextView nameView = findViewById(R.id.textView11);
        TextView descpiptionView = findViewById(R.id.textView13);

        nameView.setText(name);
        descpiptionView.setText(descpiption);

        Button play = findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                if(path == 1)
                    intent = new Intent(Descpiption.this, GameActivity.class);
                else
                    intent = new Intent(Descpiption.this, QuizActivity.class);

                startActivity(intent);
            }
        });
    }
}
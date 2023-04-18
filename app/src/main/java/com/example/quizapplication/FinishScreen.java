package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FinishScreen extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_screen);

        TextView congratsText = (TextView) findViewById(R.id.congrats);

        String name = SharedData.getName();
//        displays the name the user entered on the main activity
        congratsText.setText("Congratulations " + name);

        TextView scoreText = (TextView) findViewById(R.id.textView5);
        TextView percentText = (TextView) findViewById(R.id.textView6);

        int score = SharedData.getScore();
        int totalQ = QuestionClass.question.length;
        int percentNum = 100 * score / totalQ;

        scoreText.setText(Integer.toString(score) + " out of " + Integer.toString(totalQ));
        percentText.setText(Integer.toString(percentNum) + "%");

        Button tryAgainButton = (Button) findViewById(R.id.againButton);
//        sends user back to the main screen when they click the try again button
        tryAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FinishScreen.this, MainActivity.class));
            }

        });
        Button quitButton = findViewById(R.id.button4);
//        closes the app when the quit button is pressed
        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FinishScreen.this.finish();
                System.exit(0);
            }

        });


    }
}
package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class QuestionAnswer extends AppCompatActivity implements View.OnClickListener {

//    declares all variables
    Button aButton;
    Button bButton;
    Button cButton;
    Button dButton;

    Button nextButton;
    Button submitButton;

    TextView textQuestion;
    int score = 0;
    int questionCurrent = 0;
    int questionTotal = QuestionClass.question.length;
    int userSelection;

    Button choiceButton;
    Button correctButton;

    ProgressBar progressBar;

    TextView currentQ;

    void loadNewQuestion(){
//        sets the buttons and textview to the next question
        textQuestion.setText(QuestionClass.question[questionCurrent]);
        aButton.setText(QuestionClass.choices[questionCurrent][0]);
        bButton.setText(QuestionClass.choices[questionCurrent][1]);
        cButton.setText(QuestionClass.choices[questionCurrent][2]);
        dButton.setText(QuestionClass.choices[questionCurrent][3]);

//        resets all buttons to gray
        aButton.setBackgroundColor(Color.GRAY);
        bButton.setBackgroundColor(Color.GRAY);
        cButton.setBackgroundColor(Color.GRAY);
        dButton.setBackgroundColor(Color.GRAY);
    }
    void getButton() {
//        returns the user's choice to the button they pressed
        switch (userSelection) {
            case (0):
                choiceButton = aButton;
                break;
            case (1):
                choiceButton = bButton;
                break;
            case (2):
                choiceButton = cButton;
                break;
            case (3):
                choiceButton = dButton;
                break;
        }
    }
    void getCorrectButton(){
//        sets the correct answer from the question class
        switch(QuestionClass.correctAnswers[questionCurrent]){
            case(0):
                correctButton = aButton;
                break;
           case(1):
                correctButton = bButton;
                break;
           case(2):
                correctButton = cButton;
                break;
           case(3):
                correctButton = dButton;
                break;
            }
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_answer);

//        sets the id of elements
        aButton = (Button) findViewById(R.id.button0);
        bButton = (Button) findViewById(R.id.button1);
        cButton = (Button) findViewById(R.id.button2);
        dButton = (Button) findViewById(R.id.button3);

        nextButton = (Button) findViewById(R.id.button7);
        submitButton = (Button) findViewById(R.id.button8);

        textQuestion = (TextView) findViewById(R.id.textView2);
        currentQ = (TextView) findViewById(R.id.currentQ);

        progressBar=(ProgressBar)findViewById(R.id.progressBar2);
        progressBar.setMax(questionTotal); // sets maximum value for the progress value

//        these click listeners set the user selection and then set the button to blue and all other buttons to grey
        aButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userSelection = 0;
                aButton.setBackgroundColor(Color.BLUE);
                bButton.setBackgroundColor(Color.GRAY);
                cButton.setBackgroundColor(Color.GRAY);
                dButton.setBackgroundColor(Color.GRAY);
            }

        });
        bButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userSelection = 1;
                aButton.setBackgroundColor(Color.GRAY);
                bButton.setBackgroundColor(Color.BLUE);
                cButton.setBackgroundColor(Color.GRAY);
                dButton.setBackgroundColor(Color.GRAY);
            }

        });
        cButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userSelection = 2;
                aButton.setBackgroundColor(Color.GRAY);
                bButton.setBackgroundColor(Color.GRAY);
                cButton.setBackgroundColor(Color.BLUE);
                dButton.setBackgroundColor(Color.GRAY);
            }

        });
        dButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userSelection = 3;
                aButton.setBackgroundColor(Color.GRAY);
                bButton.setBackgroundColor(Color.GRAY);
                cButton.setBackgroundColor(Color.GRAY);
                dButton.setBackgroundColor(Color.BLUE);
            }

        });

        loadNewQuestion();

//        sets the question number text to the current question
        String questionNumText = ("Question " + Integer.toString(questionCurrent + 1) + " of " + Integer.toString(questionTotal));
        currentQ.setText(questionNumText);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                gets the button the user clicked and the correct button to press
                getButton();
                getCorrectButton();
//                if the user is correct increase the score,
//                set colours based on chosen and correct answers
                if(userSelection == QuestionClass.correctAnswers[questionCurrent]){
                    score++;
                    choiceButton.setBackgroundColor(Color.GREEN);
                }
                else{
                    choiceButton.setBackgroundColor(Color.RED);
                    correctButton.setBackgroundColor(Color.GREEN);
                }
                submitButton.setVisibility(View.INVISIBLE);
                nextButton.setVisibility(View.VISIBLE);
                progressBar.setProgress(questionCurrent + 1);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                questionCurrent++;

//                sends the user to the finish screen activity if they are out of questions
//                or else to the next question if there are more
                if(questionCurrent == questionTotal){
                    SharedData.setScore(score); // sets the score in the SharedData class
                    startActivity(new Intent(QuestionAnswer.this, FinishScreen.class));
                    QuestionAnswer.this.finish();
                }
                else{
                    submitButton.setVisibility(View.VISIBLE);
                    nextButton.setVisibility(View.INVISIBLE);
                    String questionNumText = ("Question " + Integer.toString(questionCurrent + 1) + " of " + Integer.toString(questionTotal));
                    currentQ.setText(questionNumText);

                    loadNewQuestion();
                }
            }
        });




    }


    @Override
    public void onClick(View view) {

    }
}
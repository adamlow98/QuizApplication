package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button startButton;
    EditText editTextName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = (Button) findViewById(R.id.button);
        editTextName = (EditText) findViewById(R.id.editTextTextPersonName);

        editTextName.setText(SharedData.getName());

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                sends the name to the SharedData class and opens the next activity upon click
                SharedData.setName(editTextName.getText().toString());

                startActivity(new Intent(MainActivity.this, QuestionAnswer.class));
                MainActivity.this.finish();
            }

        });
    }


}
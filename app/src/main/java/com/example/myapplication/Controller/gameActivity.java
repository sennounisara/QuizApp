package com.example.myapplication.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Model.Question;
import com.example.myapplication.Model.QuestionBank;
import com.example.myapplication.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class gameActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView question;
    private Button answer1 ;
    private Button answer2 ;
    private Button answer3 ;
    private Button answer4 ;

    private Question currentQuestion;
    private QuestionBank questionBank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        question = findViewById(R.id.question);
        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        answer4 = findViewById(R.id.answer4);

        questionBank = this.generateQuestion();

        answer1.setOnClickListener(this);
        answer2.setOnClickListener(this);
        answer3.setOnClickListener(this);
        answer4.setOnClickListener(this);

        answer1.setTag(0);
        answer2.setTag(1);
        answer3.setTag(2);
        answer4.setTag(3);

        currentQuestion = questionBank.getQuestion();
        this.displayQuestion(currentQuestion);
    }

    private QuestionBank generateQuestion(){
        Question question1 = new Question("Who created Android?",
                Arrays.asList("Andy Rubin",
                        "Steve Wozniak",
                        "Jake Wharton",
                        "Paul Smith"),
                0);

        Question question2 = new Question("When did the first person land on the moon?",
                Arrays.asList("1958",
                        "1962",
                        "1967",
                        "1969"),
                3);

        Question question3 = new Question("What is the house number of The Simpsons?",
                Arrays.asList("42", "101", "666", "742"), 3);

        return new QuestionBank(Arrays.asList(question1,question2,question3));
    }

    private void displayQuestion(final Question qst){
        question.setText(qst.getQuestion());
        answer1.setText(qst.getChoiceList().get(0));
        answer2.setText(qst.getChoiceList().get(1));
        answer3.setText(qst.getChoiceList().get(2));
        answer4.setText(qst.getChoiceList().get(3));
    }
    @Override
    public void onClick(View view) {
        int userAnswer = (int) view.getTag();
        if(userAnswer == currentQuestion.getAnswerIndex()){
            // ---- Correct answer ---- //
            Toast.makeText(gameActivity.this,"Goog job",Toast.LENGTH_LONG).show();
        }else{
            // ---- Incorrect answer ---- //
            Toast.makeText(gameActivity.this, "Uh oh, that's wrong! :(",Toast.LENGTH_LONG).show();
        }
    }
}

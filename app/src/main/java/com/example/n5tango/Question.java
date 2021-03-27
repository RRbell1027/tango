package com.example.n5tango;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.OutputStream;
import java.lang.reflect.Array;


public class Question extends AppCompatActivity {

    int count;
    String type;

    public EditText answerText;
    public TextView questionText;
    public Button ok;

    int currect, wrong, top;
    int[] questionId;
    String[] answers;
    String[] questions;
    String[] correctAnswers;

    void OutputQuestion() {
        top++;
        if(top == count) {
            quizEnd();
            return;
        }
        int id = (int)(Math.random()*64);
        questionId[top] = id;
        questionText.setText(questions[id]);
        answerText.setText("平假名");
        answerText.setSelectAllOnFocus(true);
    }

    void quizEnd() {
        Intent result = new Intent(Question.this,Score.class);
        Bundle bundle = new Bundle();
        bundle.putIntArray("questionId", questionId);
        bundle.putInt("currect",currect);
        bundle.putInt("wrong",wrong);
        bundle.putStringArray("answers",answers);
        bundle.putInt("count",count);
        bundle.putString("type",type);
        result.putExtras(bundle);
        startActivity(result);
        finish();
    }

    void InputAnswer(String answer) {
        answers[top] = answer;
        if(answer.equals(correctAnswers[questionId[top]])) {
            currect++;
        }else {
            wrong++;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        answerText = (EditText)findViewById(R.id.answertext);
        questionText = (TextView)findViewById(R.id.questiontext);
        ok = (Button)findViewById(R.id.ok);
        correctAnswers = getResources().getStringArray(R.array.hiragana);
        top = -1;

        Intent intent = getIntent();
        count = intent.getIntExtra("Amount", 10);
        type = intent.getStringExtra("type");
        switch (type) {
            case "chinese":
                questions = getResources().getStringArray(R.array.chinses);
                break;
            case "hannji":
                questions = getResources().getStringArray(R.array.hannji);
                break;
        }
        questionId = new int[count];
        answers = new String[count];

        OutputQuestion();

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputAnswer(answerText.getText().toString());
                OutputQuestion();
            }
        });

        answerText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                InputAnswer(answerText.getText().toString());
                OutputQuestion();
                return false;
            }
        });

        answerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerText.selectAll();
            }
        });
    }
}

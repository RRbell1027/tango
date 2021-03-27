package com.example.n5tango;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.ParcelUuid;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Score extends AppCompatActivity {

    public TextView correctTEXT;
    public TextView wrongText;
    public ListView listView;

    public MyListAdapter myListAdapter;

    Bundle bundle;

    String[] answers;
    int correct;
    int wrong;
    int count;
    int[] questionId;
    String type;
    String[] questions,correctAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        correctAnswers = getResources().getStringArray(R.array.hiragana);

        bundle = getIntent().getExtras();
        correct = bundle.getInt("currect",0);
        wrong = bundle.getInt("wrong",0);
        answers = bundle.getStringArray("answers");
        count = bundle.getInt("count");
        questionId = bundle.getIntArray("questionId");
        type = bundle.getString("type");
        switch (type) {
            case "chinese":
                questions = getResources().getStringArray(R.array.chinses);
                break;
            case "hannji":
                questions = getResources().getStringArray(R.array.hannji);
                break;
        }

        correctTEXT = (TextView)findViewById(R.id.currect);
        wrongText = (TextView)findViewById(R.id.wrong);
        correctTEXT.setText("答對"+correct+"題");
        wrongText.setText("答錯"+wrong+"題");

        myListAdapter = new MyListAdapter();
        listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(myListAdapter);
    }

    public class MyListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return count;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View Convertview, ViewGroup parent) {
            ViewHolder holder;
            if(Convertview==null) {
                holder = new ViewHolder();
                LayoutInflater inflater = Score.this.getLayoutInflater();
                Convertview = inflater.inflate(R.layout.adapter,null);
                holder.question = (TextView)Convertview.findViewById(R.id.question);
                holder.answer = (TextView)Convertview.findViewById(R.id.answer);
                holder.correctanswer = (TextView)Convertview.findViewById(R.id.currectAnswer);
                Convertview.setTag(holder);
            }else {
                holder = (ViewHolder)Convertview.getTag();
            }
            holder.question.setText(questions[questionId[position]]);
            holder.answer.setText(answers[position]);
            holder.correctanswer.setText(correctAnswers[questionId[position]]);
            if(!holder.answer.equals(holder.correctanswer))
                holder.answer.setTextColor(Color.RED);
            return Convertview;
        }

        public class ViewHolder {
            TextView question;
            TextView answer;
            TextView correctanswer;
        }
    }
}

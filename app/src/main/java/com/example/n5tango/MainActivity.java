package com.example.n5tango;

import androidx.appcompat.app.AppCompatActivity;

import android.app.LauncherActivity;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;

public class MainActivity extends AppCompatActivity {
    String ListItemName[] = {"新增單字集", "查看單字集", "練習"};

    Intent intent;

    public Button question10, question50, question100, chinese, hannji;

    public void ChooseNumber(View v) {
        int value = 0;
        switch (v.getId()) {
            case R.id.question10:
                value = 10;
                break;
            case R.id.question50:
                value = 50;
                break;
            case R.id.question100:
                value = 100;
                break;
        }

        intent.putExtra("Amount",value);
        startActivity(intent);
        chinese.setVisibility(View.VISIBLE);
        hannji.setVisibility(View.VISIBLE);
        question10.setVisibility(View.GONE);
        question50.setVisibility(View.GONE);
        question100.setVisibility(View.GONE);
        }

    public void ChooseType(View v) {
        switch (v.getId()) {
            case R.id.chineseQuiz:
                intent.putExtra("type","chinese");
                break;
            case R.id.hannjiQuiz:
                intent.putExtra("type","hannji");
                break;
        }
        chinese.setVisibility(View.GONE);
        hannji.setVisibility(View.GONE);
        question10.setVisibility(View.VISIBLE);
        question50.setVisibility(View.VISIBLE);
        question100.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        question10 = (Button)findViewById(R.id.question10);
        question50 = (Button)findViewById(R.id.question50);
        question100 = (Button)findViewById(R.id.question100);
        chinese = (Button)findViewById(R.id.chineseQuiz);
        hannji = (Button)findViewById(R.id.hannjiQuiz);

        ListAdapter adapter = new ListAdapter() {
            @Override
            public boolean areAllItemsEnabled() {
                return true;
            }

            @Override
            public boolean isEnabled(int position) {
                return false;
            }

            @Override
            public void registerDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public void unregisterDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public int getCount() {
                return 0;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public boolean hasStableIds() {
                return false;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                return null;
            }

            @Override
            public int getItemViewType(int position) {
                return 0;
            }

            @Override
            public int getViewTypeCount() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }
        };

        intent = new Intent(MainActivity.this, Question.class);
    }
}

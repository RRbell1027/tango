package com.example.n5tango;

import androidx.appcompat.app.AppCompatActivity;

import android.app.LauncherActivity;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String ListItemName[] = new String[]{"新增單字集", "查看單字集", "練習"};

    Intent intent;

    public ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViews();
        setAdapter();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent = new Intent(MainActivity.this, WordSet.class);
                switch (position) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
                startActivity(intent);

            }
        });
    }

    void setAdapter() {
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, R.layout.listitem_1, ListItemName);
        list.setAdapter(adapter);

    }

    void setViews() {
        list = (ListView) findViewById(R.id.list);
    }

/*    public void ChooseNumber(View v) {
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

        intent.putExtra("Amount", value);
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
    }*/
}
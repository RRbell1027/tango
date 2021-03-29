package com.example.n5tango;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    String ListItemName[] = new String[]{"新增單字集", "查看單字集", "練習"};

    Intent intent;

    private FragmentMainTesting fragmentMainTesting = new FragmentMainTesting();
    private FragmentMainAddition fragmentMainAddition = new FragmentMainAddition();
    private FragmentMainCase fragmentMainCase = new FragmentMainCase();
    private TabLayout tabLayout;
    int now = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //定義所有Views
        setViews();
        //初始設定Fragment
        FragmentManager fragmentManager =getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_test,fragmentMainAddition,"add");
        fragmentTransaction.add(R.id.fragment_test,fragmentMainTesting,"test");
        fragmentTransaction.add(R.id.fragment_test,fragmentMainCase,"case");
        fragmentTransaction.hide(fragmentMainAddition);
        fragmentTransaction.hide(fragmentMainTesting);
        fragmentTransaction.commit();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //切換Fragment
                FragmentChange(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    void setViews() {
        tabLayout = (TabLayout)findViewById(R.id.tabLayoutMain);
    }

    //切換Fragment
    void FragmentChange(int position) {
        FragmentManager fragmentManager =getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //隱藏目前Fragment
        switch (now) {
            case 0:
                fragmentTransaction.hide(fragmentMainCase);
                break;
            case  1:
                fragmentTransaction.hide(fragmentMainTesting);
                break;
            case 2:
                fragmentTransaction.hide(fragmentMainAddition);
                break;
        }
        //顯示目標Fragment
        switch (position) {
            case 0:
                fragmentTransaction.show(fragmentMainCase);
                break;
            case  1:
                fragmentTransaction.show(fragmentMainTesting);
                break;
            case 2:
                fragmentTransaction.show(fragmentMainAddition);
                break;
        }
        fragmentTransaction.commit();
        //更新目前所在的Fragment
        now = position;
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
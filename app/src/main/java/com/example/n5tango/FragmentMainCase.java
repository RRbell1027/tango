package com.example.n5tango;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.PropertyResourceBundle;
import java.util.concurrent.ConcurrentHashMap;

public class FragmentMainCase extends Fragment {

    private View view;
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_main_case,container,false);
        listView = (ListView)view.findViewById(R.id.listview);
        String[] wordSet = new String[]{"Empty"};

        ArrayList<String> arraylist = getWordSet();

        if(arraylist != null) {
            String[] wordSet1 = new String[arraylist.size()];
            for (int j=0;j<arraylist.size();j++)
                wordSet[j] = arraylist.get(j);
            ListAdapter adapter = new ArrayAdapter<>(this.getContext(),android.R.layout.simple_list_item_1,wordSet1);
            listView.setAdapter(adapter);
        }else {
            ListAdapter adapter = new ArrayAdapter<>(this.getContext(),android.R.layout.simple_list_item_1,wordSet);
            listView.setAdapter(adapter);
        }


        return view;
    }


    private ArrayList<String> getWordSet() {
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("WordSet",Context.MODE_PRIVATE);
        String json = sharedPreferences.getString("NameJson",null);
        if(json != null) {
            Gson gson = new Gson();
            Type type = new TypeToken<ArrayList<String>>() {}.getType();
            ArrayList<String> arrayList = gson.fromJson(json,type);
            return arrayList;
        }
        return null;
    }
}

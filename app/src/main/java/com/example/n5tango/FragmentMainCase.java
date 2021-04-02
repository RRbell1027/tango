package com.example.n5tango;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PropertyResourceBundle;
import java.util.concurrent.ConcurrentHashMap;

public class FragmentMainCase extends Fragment {

    private View view;
    private ListView listView;
//    private FragmentWordList fragmentWordList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //結合xml
        view = inflater.inflate(R.layout.fragment_main_case,container,false);
        listView = (ListView)view.findViewById(R.id.list);
        //Fragment設定
/*        FragmentManager fragmentManager = getChildFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.main, fragmentWordList,"WordList");
        fragmentTransaction.hide(fragmentWordList);
        fragmentTransaction.commit();*/
        //List設定
        String[] default_wordSet = getResources().getStringArray(R.array.default_name);
        ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(default_wordSet));
        addWordSet(arrayList);
        String[] wordSet = new String[arrayList.size()];
        arrayList.toArray(wordSet);
        if(wordSet!=null) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,wordSet);
            listView.setAdapter(adapter);
        }else {
            String[] empty = new String[]{"Empty"};
            ArrayAdapter<String > adapter = new ArrayAdapter<String >(getActivity(),android.R.layout.simple_list_item_1,empty);
            listView.setAdapter(adapter);
        }
        //List事件設定
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
  /*              Bundle bundle = new Bundle();
                bundle.putInt("position",position);
                fragmentWordList.setArguments(bundle);
                fragmentTransaction.show(fragmentWordList);
                fragmentTransaction.commit();*/
            }
        });
        return view;
    }

    //將儲存的單字集名字丟給list
    private void addWordSet(ArrayList<String> arrayList) {
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("WordSet",Context.MODE_PRIVATE);
        String json = sharedPreferences.getString("NameJson",null);
        if(json != null) {
            Gson gson = new Gson();
            Type type = new TypeToken<ArrayList<String>>() {}.getType();
            ArrayList<String> addList = gson.fromJson(json,type);
            for (int i=0;i<addList.size();i++) {
                arrayList.add(addList.get(i));
            }
        }
    }
}

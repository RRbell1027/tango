package com.example.n5tango;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.TestLooperManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.CheckedInputStream;

public class FragmentWordList extends Fragment {

    private ListView listView;
    private ArrayList<String> japaneseText;
    private ArrayList<String> chineseText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_word_list,container,false);
        myAdapter adapter = new myAdapter();
        listView = (ListView)view.findViewById(R.id.list);
        listView.setAdapter(adapter);
        return view;
    }

    public class myAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 1;
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
        public View getView(int position, View ConvertView, ViewGroup parent) {
            ViewHolder holder;
            if(ConvertView==null) {
                holder = new ViewHolder();
                LayoutInflater inflater = FragmentWordList.this.getLayoutInflater();
                ConvertView = inflater.inflate(R.layout.adapter_wordset,null);
                holder.position = (TextView)ConvertView.findViewById(R.id.position);
                holder.chineseView = (TextView) ConvertView.findViewById(R.id.chineseView);
                holder.japaneseView = (TextView)ConvertView.findViewById(R.id.japaneseView);
                ConvertView.setTag(holder);
            }else {
                holder = (ViewHolder)ConvertView.getTag();
            }
            holder.position.setText(""+position);
            holder.chineseView.setText("chineseView");
            holder.japaneseView.setText("japaneseView");
            return ConvertView;
        }

        private class ViewHolder {
            public TextView position;
            public TextView japaneseView;
            public TextView chineseView;
        }
    }
}

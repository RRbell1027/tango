package com.example.n5tango;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FragmentMainAddition extends Fragment {

    private TextView textView;
    private EditText nameInput;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main_addition, container, false);
        setViews(view);

        return view;
    }

    private void setViews(View view) {
        textView = (TextView)view.findViewById(R.id.textView);
        nameInput = (EditText)view.findViewById(R.id.nameInput);
    }
}

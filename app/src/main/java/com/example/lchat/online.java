package com.example.lchat;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.io.Console;

public class online extends Fragment {

    Button show;
    String Logintime;
    TextView textView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_online, container, false);
        Bundle bundle = getArguments();
        homepage hp=new homepage();
        show = view.findViewById(R.id.lastseen);
        Logintime= bundle.getString("Logintime","0");
        textView = view.findViewById(R.id.txtLast);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(Logintime);


            }
        });


        return view;
    }
}


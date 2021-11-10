package com.example.lchat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class homepage extends AppCompatActivity {


    BottomNavigationView bottomnav;
    String logintime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        logintime=getIntent().getExtras().getString("Logintime","0");
        bottomnav = findViewById(R.id.bottom_navigation);
        bottomnav.setOnNavigationItemSelectedListener(navlistner);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_nav,new chat()).commit();


    }
    private BottomNavigationView.OnNavigationItemSelectedListener navlistner =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()){
                        case R.id.chat:
                            selectedFragment = new chat();
                            break;
                        case R.id.onlineShow:
                            selectedFragment = new online();
                            Bundle bundle = new Bundle();
                            bundle.putString("Logintime",getLogintime());
                            selectedFragment.setArguments(bundle);
                            break;
                        case R.id.last:
                            selectedFragment = new lastmes();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_nav,selectedFragment).commit();
                    return true;
                }
            };
    public String getLogintime() {
        return logintime;
    }
}
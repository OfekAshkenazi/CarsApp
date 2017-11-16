package com.example.android.carsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import java.util.ArrayList;

import Entities.Car;

public class MainActivity extends AppCompatActivity {
    private static final int SEARCH_BY_TAG =0 ;
    Toolbar toolbar;
    EditText searcBarTB;
    ArrayList<Car> carsList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar= (Toolbar) findViewById(R.id.myToolbar);
        getMenuInflater().inflate(R.menu.sort_menu_layout,toolbar.getMenu());
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                toolbar.setTag(SEARCH_BY_TAG,item.getItemId());
                return true;
            }
        });
        searcBarTB=toolbar.findViewById(R.id.searchBarET_tb);
        searcBarTB.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
}

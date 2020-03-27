package com.naimur978.bottomsheetgridviewwithqueryoption;

import android.os.Bundle;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.searchButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new FullBottomSheetDialogFragment().show(getSupportFragmentManager(), "search_dialog");
            }
        });


    }
}

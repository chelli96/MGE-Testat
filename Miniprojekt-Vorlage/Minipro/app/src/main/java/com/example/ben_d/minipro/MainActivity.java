package com.example.ben_d.minipro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import service.LibraryService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LibraryService.setServerAddress("http://mge7.dev.ifs.hsr.ch/public");

    }
}

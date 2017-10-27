package com.example.ben_d.minipro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.ben_d.minipro.service.Callback;
import com.example.ben_d.minipro.service.LibraryService;

import java.util.Date;

public class ActivitySettings extends AppCompatActivity {

    private final static String SERVER_URL_PATTERN = "http://mge%d.dev.ifs.hsr.ch/public";
    private final static int DEFAULT_SERVER = 8;

    public static String[] generateServerUrls() {
        String[] urls = new String[10];
        for (int i = 0; i < 10; i++) {
            urls[i] = String.format(SERVER_URL_PATTERN, i + 1);
        }
        return urls;
    }

    public static int getDefaultServerValue() {
        return DEFAULT_SERVER;
    }

    public static String getServerAddress() {
        return getServerAddress(DEFAULT_SERVER);
    }

    public static String getServerAddress(int value) {
        return String.format(SERVER_URL_PATTERN, value);
    }

}

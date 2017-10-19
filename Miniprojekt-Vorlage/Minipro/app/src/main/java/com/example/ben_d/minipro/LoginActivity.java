package com.example.ben_d.minipro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ben_d.minipro.service.Callback;
import com.example.ben_d.minipro.service.LibraryService;

/**
 * Created by kelle on 18.10.2017.
 */

public class LoginActivity extends AppCompatActivity {


    private EditText Mail;
    private EditText Password;
    private Button   SignIn;
    private TextView Registration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LibraryService.setServerAddress("http://mge8.dev.ifs.hsr.ch/public");
       setContentView(R.layout.loginscreen);

        Mail = (EditText)findViewById(R.id.email);
        Password = (EditText)findViewById(R.id.password);
        SignIn = (Button)findViewById(R.id.login);
        Registration = (TextView)findViewById(R.id.registrieren);

        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,GadothekActivity.class);
                startActivity(intent);
            }
        });


        findViewById(R.id.registrieren).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegistrationActivity.class);
                startActivity(intent);
            }
        });


    }
    }
package com.example.ben_d.minipro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ben_d.minipro.R;
import com.example.ben_d.minipro.service.LibraryService;


/**
 * Created by kelle on 18.10.2017.
 */

public class RegistrationActivity extends AppCompatActivity {

    private EditText NewMail;
    private EditText NewPassword;
    private EditText NewNumber;
    private Button   NewRegistration;
    private TextView BackToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);

        NewMail = (EditText) findViewById(R.id.NeueEmail);
        NewPassword = (EditText) findViewById(R.id.NeuesPassword);
        NewRegistration = (Button) findViewById(R.id.neuRegistrieren);
        NewNumber = (EditText) findViewById(R.id.NeueMatrikelnummer);
        BackToLogin = (TextView)findViewById(R.id.backToLogin);

        findViewById(R.id.backToLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}


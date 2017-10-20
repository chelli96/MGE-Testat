package com.example.ben_d.minipro;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
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
    boolean isLoginOnProgress = false;


    private EditText Mail;
    private EditText Password;
    private Button   SignIn;
    private TextView Registration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LibraryService.setServerAddress("http://mge8.dev.ifs.hsr.ch/public");
        setContentView(R.layout.loginscreen);

        Mail = (EditText) findViewById(R.id.email);
        Password = (EditText) findViewById(R.id.password);

        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tryToLogin();
            }
        });

        findViewById(R.id.registrieren).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });

    }
    public boolean validate(){

        boolean valid = true;

        final String email = Mail.getText().toString();
        final String password = Password.getText().toString();

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Mail.setError("enter a valid email address");
            valid = false;
        } else {
            Mail.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 ) {
            Password.setError("at least 4 characters");
            valid = false;
        } else {
            Password.setError(null);
        }

        return valid;
    }

    private void tryToLogin() {

        final String email = Mail.getText().toString();
        final String password = Password.getText().toString();

        if(validate())
            LibraryService.login(email, password, new Callback<Boolean>() {
                @Override
                public void onCompletion(Boolean input) {
                    erfolgreicheAnmeldung(input);
                }

                @Override
                public void onError(String message) {
                    fehlerhafterLogin(message);
                }
            });
    }

    private void erfolgreicheAnmeldung(Boolean success){

        if (success) {
            Intent intent = new Intent(LoginActivity.this, GadothekActivity.class);
            startActivity(intent);
        }
    }

    private void fehlerhafterLogin(String message){

        Snackbar.make(findViewById(R.id.login), message, Snackbar.LENGTH_INDEFINITE).show();
    }
}



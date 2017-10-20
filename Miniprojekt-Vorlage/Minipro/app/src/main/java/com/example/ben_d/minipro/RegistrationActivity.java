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

public class RegistrationActivity extends AppCompatActivity {

    private EditText NewName;
    private EditText NewMail;
    private EditText NewPassword;
    private EditText NewNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);

        NewName = (EditText) findViewById(R.id.NeuerName);
        NewMail = (EditText) findViewById(R.id.NeueEmail);
        NewPassword = (EditText) findViewById(R.id.NeuesPassword);
        NewNumber = (EditText) findViewById(R.id.NeueMatrikelnummer);;

        findViewById(R.id.backToLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.neuRegistrieren).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             attemptRegistration();
            }
        });
    }
    public boolean validate(){

        boolean valid = true;

        final String email = NewMail.getText().toString();
        final String password = NewPassword.getText().toString();
        final String name = NewName.getText().toString();
        final String studentNumber = NewNumber.getText().toString();


        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            NewMail.setError("enter a valid email address");
            valid = false;
        } else {
            NewMail.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 ) {
            NewPassword.setError("at least 4 characters");
            valid = false;
        } else {
            NewPassword.setError(null);
        }

        if(name.isEmpty() || name.length() < 3 ){
            NewName.setError("at least 3 characters");
        }else {
            NewName.setError(null);
        }

        if(studentNumber.isEmpty() || studentNumber.length() < 6 ){
            NewNumber.setError("at least 6 numbers");
        }else {
            NewNumber.setError(null);
        }
        return valid;
    }

    private void attemptRegistration() {

        final String email = NewMail.getText().toString();
        final String password = NewPassword.getText().toString();
        final String name = NewName.getText().toString();
        final String studentNumber = NewNumber.getText().toString();

        if(validate()){
            LibraryService.register(email, password, name, studentNumber, new Callback<Boolean>() {
                @Override
                public void onCompletion(Boolean input) {
                    erfolgreicheRegistration(input);
                }

                @Override
                public void onError(String message) {
                    fehlerhafteRegistierung(message);
                }
            });

        }
    }

    private void erfolgreicheRegistration(Boolean success){

        if (success) {
            Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }

    private void fehlerhafteRegistierung(String message){

        Snackbar.make(findViewById(R.id.login), message, Snackbar.LENGTH_INDEFINITE).show();
    }

}


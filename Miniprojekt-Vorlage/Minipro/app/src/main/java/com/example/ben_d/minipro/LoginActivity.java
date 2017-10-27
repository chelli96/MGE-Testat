package com.example.ben_d.minipro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


import com.example.ben_d.minipro.service.Callback;
import com.example.ben_d.minipro.service.LibraryService;


public class LoginActivity extends AppCompatActivity {
    private static final String DEFAULT_SERVER = "DEFAULT_SERVER";


    private EditText Mail;
    private EditText Password;
    private Spinner ChooseServer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //LibraryService.setServerAddress("http://mge8.dev.ifs.hsr.ch/public");
        setContentView(R.layout.loginscreen);

        Mail = (EditText) findViewById(R.id.email);
        Password = (EditText) findViewById(R.id.password);
        ChooseServer = (Spinner) findViewById(R.id.spinner);

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

        final ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(LoginActivity.this, android.R.layout.simple_spinner_dropdown_item, ActivitySettings.generateServerUrls());
        ChooseServer.setAdapter(spinnerAdapter);
        setServerAddress();

        ChooseServer.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                storeSelectedServer(position + 1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public boolean validate() {

        boolean valid = true;

        final String email = Mail.getText().toString();
        final String password = Password.getText().toString();

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Mail.setError("enter a valid email address");
            valid = false;
        } else {
            Mail.setError(null);
        }

        if (password.isEmpty() || password.length() < 4) {
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

        if (validate())
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

    private void erfolgreicheAnmeldung(Boolean success) {

        if (success) {
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
        }
    }

    private void fehlerhafterLogin(String message) {

        Snackbar.make(findViewById(R.id.login), message, Snackbar.LENGTH_INDEFINITE).show();
    }

    private void setServerAddress() {
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        int prefServer = prefs.getInt(DEFAULT_SERVER, ActivitySettings.getDefaultServerValue());
        LibraryService.setServerAddress(ActivitySettings.getServerAddress(prefServer));
        ChooseServer.setSelection(prefServer - 1);
    }

    private void storeSelectedServer(int selectedServer) {
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(DEFAULT_SERVER, selectedServer);
        editor.commit();

        LibraryService.setServerAddress(ActivitySettings.getServerAddress(selectedServer));
    }

}



package com.example.ben_d.minipro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.example.ben_d.minipro.service.Callback;
import com.example.ben_d.minipro.service.LibraryService;

public class HomeActivity extends AppCompatActivity {

    private ImageButton loan;
    private ImageButton reservation;

    private final String token = "token";
    private final String user = "user";



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        loan  = (ImageButton) findViewById(R.id.loan);
        reservation = (ImageButton) findViewById(R.id.reservation);

        loan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, LoanActivity.class);
                startActivity(intent);
            }
        });

        reservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, ReservationActivity.class);
                startActivity(intent);
            }
        });
    }        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.action_logout) {
            LibraryService.logout(new Callback<Boolean>() {
                @Override
                public void onCompletion(Boolean input) {
                    removeSharedPreferences();

                    Intent i = new Intent(HomeActivity.this, LoginActivity.class);
                    startActivity(i);
                    finish();
                }

                @Override
                public void onError(String message) {
                    Log.d("error logout:", message);
                }
            });
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void removeSharedPreferences() {
        SharedPreferences sharedPreferencesLogin = getSharedPreferences("Login", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferencesLogin.edit();
        editor.putString(token, null);
        editor.putString(user, null);
        editor.commit();
    }







}

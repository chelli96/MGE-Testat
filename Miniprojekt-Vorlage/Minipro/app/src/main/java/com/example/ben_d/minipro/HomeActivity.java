package com.example.ben_d.minipro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.example.ben_d.minipro.service.LibraryService;

/**
 * Created by kelle on 26.10.2017.
 */

public class HomeActivity extends AppCompatActivity {

    private ImageButton loan; //
    private ImageButton reservation;


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
    }


}

package com.example.ben_d.minipro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.ben_d.minipro.domain.Reservation;
import com.example.ben_d.minipro.service.Callback;
import com.example.ben_d.minipro.service.LibraryService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kelle on 26.10.2017.
 */

public class ReservationActivity extends AppCompatActivity {


    final ArrayList<Reservation> reservation = new ArrayList<>();

    private RecyclerView reservationOverview;
    private RecyclerView.LayoutManager layoutManager;
    private ReservationAdapter reservationAdapter;
    private TextView emptyView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reservation_activity);

        getSupportActionBar().setTitle("Reservations");

        reservationOverview = (RecyclerView) findViewById(R.id.rvReservations);
        reservationOverview.setHasFixedSize(true);
        layoutManager  = new LinearLayoutManager(this);
        reservationOverview.setLayoutManager(layoutManager);

        reservationAdapter = new ReservationAdapter(reservation);
        reservationOverview.setAdapter(reservationAdapter);



        getMyReservations();
    }

    private void getMyReservations(){

        LibraryService.getReservationsForCustomer(new Callback<List<Reservation>>() {
            @Override
            public void onCompletion(List<Reservation> input) {

                reservation.addAll(input);
                reservationAdapter.notifyDataSetChanged();


                //unbedingt notwendig sonst zeigt es nichts an
                reservationOverview.setVisibility(View.VISIBLE);

            }

            @Override
            public void onError(String message) {

                Log.d("Error fetchActivity(): ", message);
            }
        });
    }




}
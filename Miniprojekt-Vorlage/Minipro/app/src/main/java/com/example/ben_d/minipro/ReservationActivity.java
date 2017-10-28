package com.example.ben_d.minipro;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ben_d.minipro.domain.Gadget;
import com.example.ben_d.minipro.domain.Reservation;
import com.example.ben_d.minipro.service.Callback;
import com.example.ben_d.minipro.service.LibraryService;

import java.util.ArrayList;
import java.util.List;

import static com.example.ben_d.minipro.R.id.rvReservations;

/**
 * Created by kelle on 26.10.2017.
 */

public class ReservationActivity extends AppCompatActivity implements NewReservationFragment.NewReservationDialogListener {


    final ArrayList<Reservation> reservation = new ArrayList<>();

    private RecyclerView reservationOverview;
    private RecyclerView.LayoutManager layoutManager;
    private ReservationAdapter reservationAdapter;
    private FloatingActionButton newReservation;
    private View view;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reservation_activity);

        getSupportActionBar().setTitle("Reservations");

        reservationOverview = (RecyclerView) findViewById(rvReservations);
        reservationOverview.setHasFixedSize(true);
        layoutManager  = new LinearLayoutManager(this);
        reservationOverview.setLayoutManager(layoutManager);

        reservationAdapter = new ReservationAdapter(reservation);
        reservationOverview.setAdapter(reservationAdapter);

        newReservation = (FloatingActionButton) findViewById(R.id.AddNewReservation);






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

        newReservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNewReservationDialog();
            }
        });
    }

    private void openNewReservationDialog() {
        DialogFragment dialog = NewReservationFragment.newInstance();
        dialog.show(getFragmentManager(), "NewReservationFragment");
    }

    @Override
    public void onReservationCompletion(Gadget gadget, boolean success) {
        if (success) {
            Toast.makeText(this, String.format("%s is reserved successfully", gadget.getName()), Toast.LENGTH_LONG).show();
            getMyReservations();
            Snackbar.make(view, "Success", 1500 );
            reservationAdapter.notifyDataSetChanged();
        } else {

            Toast.makeText(this, "Reservation Failed", Toast.LENGTH_LONG);
           // Snackbar.make(rvReservations,
                  //  String.format("Reservation failed for %s", gadget.getName()),
                  //  Snackbar.LENGTH_INDEFINITE).show();
        }
    }

    @Override
    public void onReservationError(String message) {

        Toast.makeText(this, "Reservation Failed", Toast.LENGTH_LONG);

    }




}
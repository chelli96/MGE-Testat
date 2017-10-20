package com.example.ben_d.minipro;

import com.example.ben_d.minipro.domain.Reservation;
import com.example.ben_d.minipro.service.Callback;
import com.example.ben_d.minipro.service.LibraryService;

import java.util.List;

/**
 * Created by kelle on 20.10.2017.
 */

public class ReservationActivity {

    public void getReservations(){

        LibraryService.getReservationsForCustomer(new Callback<List<Reservation>>() {
            @Override
            public void onCompletion(List<Reservation> input) {

            }

            @Override
            public void onError(String message) {

            }
        });
    }
}

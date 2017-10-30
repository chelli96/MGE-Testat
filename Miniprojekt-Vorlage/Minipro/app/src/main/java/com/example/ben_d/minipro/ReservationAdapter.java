package com.example.ben_d.minipro;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.ben_d.minipro.domain.Gadget;
import com.example.ben_d.minipro.domain.Reservation;

import java.util.ArrayList;
import java.util.List;

public class ReservationAdapter extends RecyclerView.Adapter<ReservationViewHolder> {
    private ArrayList<Reservation> dataset;
    private ReservationViewHolder reserve;
    private ReservationHandler handler;


    private List<Reservation> reservationList;

    public ReservationAdapter(ArrayList<Reservation> reservations) {
        dataset = reservations;
    }

    @Override
    public ReservationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.rowlayout_reservation, parent, false);
        TextView gadgetName = v.findViewById(R.id.rvGadgetName);
        ImageButton deleteButton = v.findViewById(R.id.deleteButton);
        return new ReservationViewHolder(v, gadgetName, deleteButton);
    }

    @Override
    public void onBindViewHolder(ReservationViewHolder holder, final int position) {
        final Reservation reservation = dataset.get(position);

        holder.rvGadgetName.setText(reservation.getGadget().getName());

        reserve.deleteButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                handler.deleteReservation(reservation);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public static String[] getGadgetsForDialog(List<Gadget> gadgets) {
        List<String> gadgetsList = new ArrayList<>();
        for (Gadget g : gadgets) {
            gadgetsList.add(g.getName() + " - " + g.getCondition());
        }
        return gadgetsList.toArray(new String[gadgets.size()]);
    }

    public static String formatPrice(double price){
        return String.format("Fr. %.2f", price);
    }

    public void setReservations(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }
}


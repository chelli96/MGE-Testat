package com.example.ben_d.minipro;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ben_d.minipro.domain.Reservation;

import java.util.ArrayList;

public class ReservationAdapter extends RecyclerView.Adapter<ReservationViewHolder> {
    private ArrayList<Reservation> dataset;

    public ReservationAdapter(ArrayList<Reservation> reservations) {
        dataset = reservations;
    }

    @Override
    public ReservationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.rowlayout_reservation, parent, false);
        TextView gadgetName = v.findViewById(R.id.rvGadgetName);
        return new ReservationViewHolder(v, gadgetName);
    }

    @Override
    public void onBindViewHolder(ReservationViewHolder holder, int position) {
        final Reservation reservation = dataset.get(position);

        holder.rvGadgetName.setText(reservation.getGadget().getName());

    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}

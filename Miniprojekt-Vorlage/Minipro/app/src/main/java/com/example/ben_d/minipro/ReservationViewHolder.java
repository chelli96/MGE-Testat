package com.example.ben_d.minipro;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by kelle on 23.10.2017.
 */

public class ReservationViewHolder extends RecyclerView.ViewHolder {
    public View parent;
    public TextView rvGadgetName;
    public ImageButton deleteButton;


    //Konstrukter erweitern mit Datum?
    public ReservationViewHolder(View parent, TextView rvGadgetName, ImageButton deleteButton) {
        super(parent);
        this.parent = parent;
        this.rvGadgetName = rvGadgetName;
        this.deleteButton = deleteButton;

    }

}

package com.example.ben_d.minipro;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by kelle on 23.10.2017.
 */

public class LoanViewHolder extends RecyclerView.ViewHolder {
    public View parent;
    public TextView gadgetName;
    public TextView loanDate;

    public LoanViewHolder(View parent, TextView gadgetName, TextView loanDate) {
        super(parent);
        this.parent = parent;
        this.gadgetName = gadgetName;
        this.loanDate = loanDate;
    }
}

package com.example.ben_d.minipro;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ben_d.minipro.domain.Loan;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class LoanAdapter extends RecyclerView.Adapter<LoanViewHolder>{
    private ArrayList<Loan> dataset;

    public LoanAdapter(ArrayList<Loan> loans) {dataset = loans;}


    @Override
    public LoanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.rowlayout_loan, parent, false);
        TextView gadgetName = v.findViewById(R.id.gadgetName);
        TextView loanDate = v.findViewById(R.id.loanDate);
        return new LoanViewHolder(v, gadgetName, loanDate);
    }

    @Override
    public void onBindViewHolder(LoanViewHolder holder, int position) {
        final Loan loan = dataset.get(position);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy");

        holder.gadgetName.setText(loan.getGadget().getName());

        holder.loanDate.setText(dateFormat.format(loan.getReturnDate()));

    }


    @Override
    public int getItemCount() {
        return dataset.size();
    }
}

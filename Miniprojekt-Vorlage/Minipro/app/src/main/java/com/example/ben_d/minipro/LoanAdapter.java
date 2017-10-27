package com.example.ben_d.minipro;

import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ben_d.minipro.domain.Loan;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LoanAdapter extends RecyclerView.Adapter<LoanViewHolder> {

    private List<Loan> dataset;

    public  LoanAdapter(){
        this.dataset = new ArrayList<>();
    }

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
        if(dataset.isEmpty()){
           // holder.emptyView.setVisibility(View.VISIBLE);
        }else {
            final Loan loan = dataset.get(position);

            holder.gadgetName.setText(loan.getGadget().getName());

            Date returnDate = loan.overDueDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy");


            if (returnDate != null) {
                holder.loanDate.setText(dateFormat.format(loan.overDueDate()));
            }else{
<<<<<<< HEAD



            }
=======
                holder.loanDate.setText("Wir haben ein Problem");
           }
>>>>>>> aa5d1cc04a15c350cab1dbe4d1df195c912c57dc
        }
    }

    @Override
    public int getItemCount() { return dataset.size(); }

    public void setDataSet(List<Loan> dataset){
        this.dataset = dataset;
    }


}

package com.example.ben_d.minipro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.ben_d.minipro.domain.Loan;
import com.example.ben_d.minipro.service.Callback;
import com.example.ben_d.minipro.service.LibraryService;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.input;

/**
 * Created by kelle on 26.10.2017.
 */

public class LoanActivity extends AppCompatActivity {

    private RecyclerView loanOverview;
    private RecyclerView.LayoutManager layoutManager;
    private LoanAdapter adapter;
    private TextView emptyView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loan_activity);

        getSupportActionBar().setTitle("Loans");

        loanOverview = (RecyclerView) findViewById(R.id.loanOverview);
        loanOverview.setHasFixedSize(true);
        layoutManager  = new LinearLayoutManager(this);
        loanOverview.setLayoutManager(layoutManager);

        adapter = new LoanAdapter();
        loanOverview.setAdapter(adapter);



        getMyLoans();
    }

    private void getMyLoans(){

        LibraryService.getLoansForCustomer(new Callback<List<Loan>>() {
            @Override
            public void onCompletion(List<Loan> input) {
                adapter.setDataSet(input);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onError(String message) {

                Log.d("Error fetchLoans(): ", message);
            }
        });
    }

}

package com.example.ben_d.minipro;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ben_d.minipro.domain.Loan;
import com.example.ben_d.minipro.service.Callback;
import com.example.ben_d.minipro.service.LibraryService;

import java.util.ArrayList;
import java.util.List;

public class LoanFragment extends Fragment {

    private RecyclerView loanOverview;
    private LoanAdapter loanAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private TextView emptyView;

    final ArrayList<Loan> loans = new ArrayList<>();

    public static Fragment newInstance() {
        LoanFragment myFragment = new LoanFragment();

        Bundle args = new Bundle();

        return myFragment;
    }

    // @Override
    public View onCreate(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState){
        View root =  inflater.inflate(R.layout.loan_fragment, container, false);
        loanOverview = root.findViewById(R.id.loanOverview);
        loanOverview.setHasFixedSize(true);

        emptyView = root.findViewById(R.id.empty_view);

        layoutManager = new LinearLayoutManager(getActivity());
        loanOverview.setLayoutManager(layoutManager);

        LibraryService.getLoansForCustomer(new GetCustomerLoansCallback());

        loanAdapter = new LoanAdapter(loans);
        loanOverview.setAdapter(loanAdapter);

        return root;

    }

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
    }

    public class GetCustomerLoansCallback implements Callback<List<Loan>> {

        @Override
        public void onCompletion(List<Loan> input) {
            if(input.size() > 0) {
                loans.addAll(input);

                loanAdapter.notifyDataSetChanged();

                loanOverview.setVisibility(View.VISIBLE);
                emptyView.setVisibility(View.GONE);
            } else {
                loanOverview.setVisibility(View.GONE);
                emptyView.setVisibility(View.VISIBLE);
            }
        }
        @Override
        public void onError(String message) {
            // Emtpy list, show picture on recyclerview
        }
    }

}
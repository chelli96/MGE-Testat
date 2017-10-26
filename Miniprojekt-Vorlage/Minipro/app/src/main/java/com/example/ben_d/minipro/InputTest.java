package com.example.ben_d.minipro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.ben_d.minipro.domain.Loan;
import com.example.ben_d.minipro.service.Callback;
import com.example.ben_d.minipro.service.LibraryService;

import java.util.ArrayList;
import java.util.List;


public class InputTest extends AppCompatActivity {

    private TextView Input;
    ArrayList<Loan> loans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gadothek);
        Input = (TextView) findViewById(R.id.input);
        final boolean test = LibraryService.isLoggedIn();
        LibraryService.getLoansForCustomer(new Callback<List<Loan>>() {


            @Override
            public void onCompletion(List<Loan> input) {
                //loans.toString();
                if(test){
                    Input.setText(input.toString());
                } else{
                Input.setText(input.toString());}

                            }

            @Override
            public void onError(String message) {

                Input.setText("Fail");

            }
        });
        
    }
}

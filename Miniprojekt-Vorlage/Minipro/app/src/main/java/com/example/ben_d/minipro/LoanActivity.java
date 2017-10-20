package com.example.ben_d.minipro;

import com.example.ben_d.minipro.domain.Loan;
import com.example.ben_d.minipro.service.Callback;
import com.example.ben_d.minipro.service.LibraryService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kelle on 20.10.2017.
 */

public class LoanActivity {


   private void getLoans(){

       LibraryService.getLoansForCustomer(new Callback<List<Loan>>() {
           @Override
           public void onCompletion(List<Loan> input) {

           }

           @Override
           public void onError(String message) {

           }
       });
   }
}

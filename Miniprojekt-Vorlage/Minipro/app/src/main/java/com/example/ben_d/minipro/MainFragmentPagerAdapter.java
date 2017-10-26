package com.example.ben_d.minipro;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MainFragmentPagerAdapter extends FragmentPagerAdapter {
    private String tabTitles[] = new String[] { "Übersicht", "Reservation" };

    public MainFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                // ToDo: return UBERSICHTS-FRAGMENT.newInstance()
                return LoanFragment.newInstance();
           /* case 1:
                // ToDo: return Reservation-FRAGMENT.newInstance()
                return ReservationFragment.newInstance();*/
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
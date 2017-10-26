package com.example.ben_d.minipro;

import android.text.format.DateFormat;

import java.util.Date;

/**
 * Created by kelle on 26.10.2017.
 */

public class ActivitySettings {

    public static String formatShortDate(Date date) {
        return String.valueOf(DateFormat.format("dd MMM yyyy", date));
    }
}

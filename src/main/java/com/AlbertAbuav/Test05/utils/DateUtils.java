package com.AlbertAbuav.Test05.utils;

import java.sql.Date;
import java.text.SimpleDateFormat;


public class DateUtils {

    private static final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    public static String formattedDate(Date date) {
        return formatter.format(date);
    }

}

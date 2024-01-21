package com.ranjit.spacex.launches.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtils {

    /**
     * Converts the input date string from the format "yyyy-MM-dd'T'HH:mm:ssXXX" to "dd-MM-yyyy hh:mm a".
     *
     * @param inputDate The input date string in the format "yyyy-MM-dd'T'HH:mm:ssXXX".
     * @return The formatted date string in the format "dd-MM-yyyy hh:mm a".
     */
    public static String convertDateFormat(String inputDate) {
        try {
            // Parse input date string
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX", Locale.getDefault());
            Date date = inputFormat.parse(inputDate);

            // Format the date to the desired output format
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm a", Locale.getDefault());
            return outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return ""; // Handle parsing exception
        }
    }


}

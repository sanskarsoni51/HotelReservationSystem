package com.bridgelabz;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateInput{

    /**
     * Parses a date string in the format "ddMMMyyyy" and returns a Date object.
     *
     * @param dateInput The date string to be parsed.
     * @return A Date object representing the parsed date.
     * @throws ParseException If the input date string cannot be parsed according to the specified format.
     */
    public static Date DateFormat(String dateInput) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("ddMMMyyyy");

        Date date = null;
        date = format.parse(dateInput);

//        System.out.println(date);
        return date;
    }

    public static boolean IsWeekend(Date date){
//        System.out.println(date.getDay());
        if(date.getDay() == 6 || date.getDay() ==0){
            return true;
        }
        return false;
    }
}

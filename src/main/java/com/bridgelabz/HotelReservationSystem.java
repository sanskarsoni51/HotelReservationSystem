package com.bridgelabz;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class HotelReservationSystem {
    public static void main(String[] args) throws ParseException {
        System.out.println("Welcome to Hotel Reservation System");

        ArrayList<Hotels> hotelList = new ArrayList<>();

        Hotels Lakewood = new Hotels("Lakewood", 110,90);
        Hotels Bridgewood = new Hotels("Bridgewood", 150,50);
        Hotels Ridgewood = new Hotels("Ridgewood", 220,150);

        hotelList.add(Lakewood);
        hotelList.add(Bridgewood);
        hotelList.add(Ridgewood);

        System.out.println(hotelList);
        Scanner sc = new Scanner(System.in);
        Scanner s = new Scanner(System.in);
        System.out.println("Enter number of days: ");
        int noOfDays = sc.nextInt();
        Set<String> Stay = new HashSet<String>();
//        List<String> Stay = new Vector<String>();
        int TotalRate = 0;
        System.out.println("Enter dates: ");
        String dateInput;
        for (int i = 0; i <noOfDays; i++) {
            dateInput = s.nextLine();
            // Parsing the user input date string and checking if it's a weekend
            boolean weekEnd = DateInput.IsWeekend(DateInput.DateFormat(dateInput));

            // Choosing a hotel based on whether it's a weekend or not
            if(weekEnd){
                // Choosing the hotel with the minimum rate for weekends
                String h = hotelList.stream().min(Comparator.comparing(Hotels::getRateForWeekends)).get().getName();
                Stay.add(h);
                // Adding the rate of the selected hotel for weekends to the total rate
                int rate = hotelList.stream().min(Comparator.comparing(Hotels::getRateForWeekends)).get().getRateForWeekends();
                TotalRate = TotalRate+rate;
            }else {
                // Choosing the hotel with the minimum rate for regular days
                String h = hotelList.stream().min(Comparator.comparing(Hotels::getRateForRegular)).get().getName();
                Stay.add(h);
                // Adding the rate of the selected hotel for regular days to the total rate
                int rate = hotelList.stream().min(Comparator.comparing(Hotels::getRateForRegular)).get().getRateForRegular();
                TotalRate = TotalRate + rate;
            }

        }
        for (String i:Stay
             ) {
            System.out.print(i + " and ");
        }
        System.out.print("With Total rate $"+TotalRate);

    }
}

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
        System.out.println("Enter number of days: ");
        int noOfDays = sc.nextInt();
        Set<String> Stay = new HashSet<String>();
//        List<String> Stay = new Vector<String>();
        int TotalRate = 0;
        for (int i = 0; i <noOfDays; i++) {
            String dateInput = sc.nextLine();
            String h = hotelList.stream().min(Comparator.comparing(Hotels::getRateForRegular)).get().getName();
            Stay.add(h);
            int rate = hotelList.stream().min(Comparator.comparing(Hotels::getRateForRegular)).get().getRateForRegular();
            TotalRate = TotalRate+rate;
//            boolean weekEnd = DateInput.IsWeekend(DateInput.DateFormat(dateInput));
//            System.out.println(weekEnd);
        }
        for (String i:Stay
             ) {
            System.out.print(i + " ");
        }
        System.out.print("With Total rate $"+TotalRate);

    }
}

package com.bridgelabz;

import java.text.ParseException;

import java.util.*;

import static java.lang.Math.min;

public class HotelReservationSystem {
    public static void main(String[] args) throws ParseException {
        // Constants for different hotel selection options
        final int CheapestHotels = 1;
        final int CheapestBestRated = 2;
        final int BestRated = 3;
        final int CheapestBeatRatedForRewardCustomer = 4;

        System.out.println("Welcome to Hotel Reservation System");

        // Create a list to store hotel objects
        ArrayList<Hotels> hotelList = new ArrayList<>();

        // Initialize hotel objects and add them to the list
        Hotels Lakewood = new Hotels("Lakewood", 110, 90, 3, 80, 80);
        Hotels Bridgewood = new Hotels("Bridgewood", 150, 50, 4, 50, 110);
        Hotels Ridgewood = new Hotels("Ridgewood", 220, 150, 5, 40, 100);

        hotelList.add(Lakewood);
        hotelList.add(Bridgewood);
        hotelList.add(Ridgewood);

        // Display the list of hotels
        System.out.println(hotelList);

        // Set up scanners for user input
        Scanner sc = new Scanner(System.in);
        Scanner s = new Scanner(System.in);

        // Set to store selected hotels, and variable to track total rate
        Set<String> Stay = new HashSet<>();
        int TotalRate = 0;

        // Display menu options
        System.out.println("1)Cheapest Hotels \n 2)Cheapest Hotel with best Rating \n 3)Best Rated Hotel \n 4)Cheapest Hotel with best Rating for Reward customer");
        int option = sc.nextInt();

        // Get the number of days for the stay
        System.out.println("Enter number of days: ");
        int noOfDays = sc.nextInt();

        // Get dates for the stay
        System.out.println("Enter dates: ");
        String dateInput;

        // Switch statement to handle different hotel selection options
        switch (option) {

            case CheapestHotels:
                // Logic for selecting the cheapest hotels based on weekdays or weekends
                for (int i = 0; i < noOfDays; i++) {
                    dateInput = s.nextLine();
                    // Parsing the user input date string and checking if it's a weekend
                    boolean weekEnd = DateInput.IsWeekend(DateInput.DateFormat(dateInput));

                    // Choosing a hotel based on whether it's a weekend or not
                    if (weekEnd) {
                        // Choosing the hotel with the minimum rate for weekends
                        String h = hotelList.stream().min(Comparator.comparing(Hotels::getRateForWeekends)).get().getName();
                        Stay.add(h);
                        // Adding the rate of the selected hotel for weekends to the total rate
                        int rate = hotelList.stream().min(Comparator.comparing(Hotels::getRateForWeekends)).get().getRateForWeekends();
                        TotalRate = TotalRate + rate;
                    } else {
                        // Choosing the hotel with the minimum rate for regular days
                        String h = hotelList.stream().min(Comparator.comparing(Hotels::getRateForRegular)).get().getName();
                        Stay.add(h);
                        // Adding the rate of the selected hotel for regular days to the total rate
                        int rate = hotelList.stream().min(Comparator.comparing(Hotels::getRateForRegular)).get().getRateForRegular();
                        TotalRate = TotalRate + rate;
                    }
                }
                break;

            case CheapestBestRated:
                // Logic for selecting the cheapest hotel with the best rating
                int week_end = 0;
                for (int i = 0; i < noOfDays; i++) {
                    dateInput = s.nextLine();
                    // Parsing the user input date string and checking if it's a weekend
                    boolean weekEnd = DateInput.IsWeekend(DateInput.DateFormat(dateInput));
                    if (weekEnd) week_end++;
                }
                final int W = week_end;
                Hotels htel = hotelList.stream()
                        .min(Comparator.comparingInt(hotel ->
                                        ((hotel.getRateForRegular() * (noOfDays - W)) +
                                        (hotel.getRateForWeekends() * W)) / hotel.getRatings()))
                        .orElse(null);
                TotalRate = ((htel.getRateForRegular() * (noOfDays - W)) +
                        (htel.getRateForWeekends() * W));
                Stay.add(htel.getName());
                break;

            case BestRated:
                // Logic for selecting the best-rated hotel based on weekdays or weekends
                for (int i = 0; i < noOfDays; i++) {
                    dateInput = s.nextLine();
                    // Parsing the user input date string and checking if it's a weekend
                    boolean weekEnd = DateInput.IsWeekend(DateInput.DateFormat(dateInput));

                    // Choosing a hotel based on whether it's a weekend or not
                    if (weekEnd) {
                        // Choosing the hotel with the best Rating for weekends
                        String h = hotelList.stream().max(Comparator.comparing(Hotels::getRatings)).get().getName();
                        Stay.add(h);
                        // Adding the rate of the selected hotel for weekends to the total rate
                        int rate = hotelList.stream().max(Comparator.comparing(Hotels::getRatings)).get().getRateForWeekends();
                        TotalRate = TotalRate + rate;
                    } else {
                        // Choosing the hotel with the Best Rating for regular days
                        String h = hotelList.stream().max(Comparator.comparing(Hotels::getRatings)).get().getName();
                        Stay.add(h);
                        // Adding the rate of the selected hotel for regular days to the total rate
                        int rate = hotelList.stream().max(Comparator.comparing(Hotels::getRatings)).get().getRateForRegular();
                        TotalRate = TotalRate + rate;
                    }
                }
                break;

            case CheapestBeatRatedForRewardCustomer:
                // Logic for selecting the cheapest hotel with the best rating for reward customers
                int wend = 0;

                for (int i = 0; i < noOfDays; i++) {
                    // Assuming DateInput is a class with static methods IsWeekend and DateFormat
                    dateInput = s.nextLine();
                    boolean weekEnd = DateInput.IsWeekend(DateInput.DateFormat(dateInput));
                    if (weekEnd) wend++;
                }
                final int WEnd = wend;
                // Use streams to find the cheapest and best-rated hotel for reward customers
                Hotels selectedHotel = hotelList.stream()
                        .min(Comparator.comparingInt(hotel ->
                                ((hotel.getRateForRewardCustomerRegular() * (noOfDays - WEnd)) +
                                        (hotel.getRateForRewardCustomerWeekends() * WEnd)) / hotel.getRatings()))
                        .orElse(null);

                if (selectedHotel != null) {
                    // Calculate the total rate based on the selected hotel's rates and ratings
                    int totalRate = (selectedHotel.getRateForRewardCustomerRegular() * (noOfDays - WEnd)) +
                            (selectedHotel.getRateForRewardCustomerWeekends() * WEnd);
                    TotalRate = totalRate;

                    // Do something with the selected hotel (e.g., store it in Stay list)
                    Stay.add(selectedHotel.getName());
                } else {
                    // Handle the case when no hotel is found
                }
                break;
        }

        // Display selected hotels and total rate
        for (String i : Stay) {
            System.out.print(i + " and ");
        }
        System.out.print("With Total rate $" + TotalRate);
    }
}
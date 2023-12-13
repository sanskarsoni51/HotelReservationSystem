package com.bridgelabz;

import java.util.ArrayList;

public class HotelReservationSystem {
    public static void main(String[] args) {
        System.out.println("Welcome to Hotel Reservation System");

        ArrayList<Hotels> hotelList = new ArrayList<>();

        Hotels Lakewood = new Hotels("Lakewood",110);
        Hotels Bridgewood = new Hotels("Bridgewood",160);
        Hotels Ridgewood = new Hotels("Ridgewood",220);

        hotelList.add(Lakewood);
        hotelList.add(Bridgewood);
        hotelList.add(Ridgewood);

        System.out.println(hotelList);

    }
}

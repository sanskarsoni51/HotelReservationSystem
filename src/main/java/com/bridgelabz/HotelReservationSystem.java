package com.bridgelabz;

public class HotelReservationSystem {
    public static void main(String[] args) {
        System.out.println("Welcome to Hotel Reservation System");

        Hotels Lakewood = new Hotels("Lakewood",110);
        Hotels Bridgewood = new Hotels("Bridgewood",160);
        Hotels Ridgewood = new Hotels("Ridgewood",220);

        System.out.println(Lakewood.toString());
        System.out.println(Bridgewood.toString());
        System.out.println(Ridgewood.toString());

    }
}

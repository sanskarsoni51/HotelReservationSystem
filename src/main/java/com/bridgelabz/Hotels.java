package com.bridgelabz;

public class Hotels {

    private String Name;

    private int rateForRegular;

    private int rateForWeekends;

    private int Ratings;

    @Override
    public String toString() {
        return "Hotels{" +
                "Name='" + Name + '\'' +
                ", rateForRegular=" + rateForRegular +
                ", rateForWeekends=" + rateForWeekends +
                ", Ratings=" + Ratings +
                '}';
    }

    public Hotels(String name, int rateForRegular, int rateForWeekends, int ratings) {
        Name = name;
        this.rateForRegular = rateForRegular;
        this.rateForWeekends = rateForWeekends;
        Ratings = ratings;
    }

    public int getRatings() {
        return Ratings;
    }

    public void setRatings(int ratings) {
        Ratings = ratings;
    }

    public int getRateForWeekends() {
        return rateForWeekends;
    }

    public void setRateForWeekends(int rateForWeekends) {
        this.rateForWeekends = rateForWeekends;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getRateForRegular() {
        return rateForRegular;
    }

    public void setRateForRegular(int rateForRegular) {
        this.rateForRegular = rateForRegular;
    }

}

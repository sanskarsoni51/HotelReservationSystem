package com.bridgelabz;

public class Hotels {

    private String Name;

    private int rateForRegular;

    private int rateForWeekends;

    @Override
    public String toString() {
        return "Hotels{" +
                "Name='" + Name + '\'' +
                ", rateForRegular=" + rateForRegular +
                ", rateForWeekends=" + rateForWeekends +
                '}';
    }

    public int getRateForWeekends() {
        return rateForWeekends;
    }

    public void setRateForWeekends(int rateForWeekends) {
        this.rateForWeekends = rateForWeekends;
    }

    public Hotels(String name, int rateForRegular, int rateForWeekends) {
        Name = name;
        this.rateForRegular = rateForRegular;
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

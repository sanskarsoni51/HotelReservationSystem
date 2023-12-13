package com.bridgelabz;

public class Hotels {

    private String Name;

    private int rateForRegular;

    public Hotels(String name, int rateForRegular) {
        Name = name;
        this.rateForRegular = rateForRegular;
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

    @Override
    public String toString() {
        return "Hotels{" +
                "Name='" + Name + '\'' +
                ", rateForRegular=" + rateForRegular +
                '}';
    }
}

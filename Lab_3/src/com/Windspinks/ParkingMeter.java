package com.Windspinks;

public class ParkingMeter {
    private int minutesPaidFor;

    public ParkingMeter(int minutesPaidFor) {
        this.minutesPaidFor = minutesPaidFor;
    }

    public int getMinutesPaidFor() {
        return minutesPaidFor;
    }

    public void setMinutesPaidFor(int minutesPaidFor) {
        this.minutesPaidFor = minutesPaidFor;
    }

    public String toString() {
        //MINUTES minutes paid for
        return String.format("%d minutes paid for", minutesPaidFor);
    }
}
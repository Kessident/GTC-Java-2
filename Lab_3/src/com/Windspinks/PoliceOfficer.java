package com.Windspinks;

public class PoliceOfficer {
    private String name;
    private String badgeNum;

    public PoliceOfficer(String name, String badgeNum) {
        this.name = name;
        this.badgeNum = badgeNum;
    }

    public String getName() {
        return name;
    }

    public String getBadgeNum() {
        return badgeNum;
    }

    public boolean isParkedIllegally(ParkedCar car, ParkingMeter meter) {
        return car.getMinutesParked() > meter.getMinutesPaidFor();
    }

    public ParkingTicket writeTicket(ParkedCar car, ParkingMeter meter) {
        if (isParkedIllegally(car, meter)) {
            return new ParkingTicket(car, this, meter.getMinutesPaidFor());
        } else {
            return null;
        }
    }

    public String toString() {
        //Officer NAME, badge number BADGENUMBER
        return String.format("Officer %s, badge number %s", name, badgeNum);
    }
}
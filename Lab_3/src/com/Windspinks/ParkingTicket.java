package com.Windspinks;

public class ParkingTicket {
    private ParkedCar ticketedCar;
    private int fineAmount;
    private PoliceOfficer issuingOfficer;

    public ParkingTicket(ParkedCar ticketedCar, PoliceOfficer issuingOfficer, int minutesPaidFor) {
        this.ticketedCar = ticketedCar;
        this.issuingOfficer = issuingOfficer;
        fineAmount = calcFineAmount(minutesPaidFor);
    }

    public ParkedCar getTicketedCar() {
        return ticketedCar;
    }

    public int getFineAmount() {
        return fineAmount;
    }

    public PoliceOfficer getIssuingOfficer() {
        return issuingOfficer;
    }

    private int calcFineAmount(int minutesPaidFor) {
        int fineAmount = 0;
        double minutesOverParked = ticketedCar.getMinutesParked() - minutesPaidFor;
        //Fine for first hour
        fineAmount += 25;
        minutesOverParked -= 60;

        while (minutesOverParked > 0) {
            //Fine for every subsequent hour
            fineAmount += 10;
            minutesOverParked -= 60;
        }

        return fineAmount;
    }

    public String toString() {
        //Ticket issued to a CAR by OFFICER for PRICE
        return String.format("Ticket issued to a %s written by %s for $%,d", ticketedCar, issuingOfficer, getFineAmount());
    }

}

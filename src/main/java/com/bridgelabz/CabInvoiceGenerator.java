package com.bridgelabz;

public class CabInvoiceGenerator {
    final int PER_KM_COST = 10;
    final int PER_MIN_COST = 1;
    final int MIN_FARE = 5;

    public int calculateFare(int distance,int time) {
        int totalFare = distance * PER_KM_COST + time * PER_MIN_COST;
        if( totalFare < MIN_FARE) {
            totalFare = MIN_FARE;
        }
        return totalFare;
    }

    public int multipleRides(Rides[] rides) {
        int totalFare = 0;
        for(Rides ride : rides) {
            totalFare += calculateFare(ride.distance,ride.duration);
        }
        return totalFare;
    }

    public InvoiceSummary calculateInvoiceSummary(Rides[] rides) {
        int totalFare = 0;
        for(Rides ride : rides) {
            totalFare += calculateFare(ride.distance,ride.duration);
        }
        return new InvoiceSummary(rides.length,totalFare);
    }
}

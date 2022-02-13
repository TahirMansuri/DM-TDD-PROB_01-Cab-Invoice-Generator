package com.bridgelabz;

public class CabInvoiceGenerator {
    int perKmCost;
    int perMinCost;
    int minFare;

    public int calculateFare(int distance,int time,Rides.RideType rideType) {
        if(rideType == Rides.RideType.NORMAL) {
            perKmCost = 10;
            perMinCost = 1;
            minFare = 5;
        } else {
            perKmCost = 15;
            perMinCost = 2;
            minFare = 20;
        }
        int totalFare = distance * perKmCost + time * perMinCost;
        if( totalFare < minFare) {
            totalFare = minFare;
        }
        return totalFare;
    }

    public int multipleRides(Rides[] rides, Rides.RideType rideType) {
        int totalFare = 0;
        for(Rides ride : rides) {
            totalFare += calculateFare(ride.distance,ride.duration,rideType);
        }
        return totalFare;
    }

    public InvoiceSummary calculateInvoiceSummary(Rides[] rides, Rides.RideType rideType) {
        int totalFare = 0;
        for(Rides ride : rides) {
            totalFare += calculateFare(ride.distance,ride.duration,rideType);
        }
        return new InvoiceSummary(rides.length,totalFare);
    }
}
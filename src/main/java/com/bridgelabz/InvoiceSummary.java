package com.bridgelabz;

public class InvoiceSummary {
    int totalNoRide;
    int totalFare;
    double averageFarePerRide;

    public InvoiceSummary(int totalNoRide, int totalFare) {
        this.totalNoRide = totalNoRide;
        this.totalFare = totalFare;
        this.averageFarePerRide = this.totalFare / this.totalNoRide;
    }

    public int getTotalNoRide() {
        return totalNoRide;
    }

    public int getTotalFare() {
        return totalFare;
    }

    public double getAverageFarePerRide() {
        return averageFarePerRide;
    }
}

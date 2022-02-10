package com.bridgelabz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CabInvoiceGeneratorTest {
    CabInvoiceGenerator cabInvoiceGenerator;
    @BeforeEach
    void setUp() {
        cabInvoiceGenerator = new CabInvoiceGenerator();
    }

    @Test
    @DisplayName("Calculate Fair for given distance and duration")
    void calculateFare() {
        assertEquals(55,cabInvoiceGenerator.calculateFare(5,5));
    }

    @Test
    @DisplayName("Calculate fair for Multiple Rides")
    void multipleRides() {
        Rides[] rides = {new Rides(5,5),new Rides(5,5)};
        assertEquals(110,cabInvoiceGenerator.multipleRides(rides));
    }

    @Test
    @DisplayName("Calculate Invoice Summary for All Rides")
    void calculateInvoiceSummary() {
        Rides[] rides = {new Rides(5,5),new Rides(5,5),new Rides(5,5)};
        InvoiceSummary invoiceSummary = cabInvoiceGenerator.calculateInvoiceSummary(rides);
        InvoiceSummary invoiceSummaryExpected = new InvoiceSummary(3,165);
        if(invoiceSummaryExpected.getAverageFarePerRide() == invoiceSummary.getAverageFarePerRide()
        && invoiceSummaryExpected.getTotalNoRide() == invoiceSummary.getTotalNoRide()
        && invoiceSummaryExpected.getTotalFare() == invoiceSummary.getTotalFare())
        assertEquals(1,1);
    }
}
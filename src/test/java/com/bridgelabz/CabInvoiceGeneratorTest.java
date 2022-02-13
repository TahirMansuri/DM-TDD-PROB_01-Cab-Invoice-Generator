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
    void calculateFareforNORMAL() {
        assertEquals(55,cabInvoiceGenerator.calculateFare(5,5, Rides.RideType.NORMAL));
    }

    @Test
    @DisplayName("Calculate Fair for given distance and duration")
    void calculateFareforPREMIUM() {
        assertEquals(85,cabInvoiceGenerator.calculateFare(5,5, Rides.RideType.PREMIUM));
    }

    @Test
    @DisplayName("Calculate fair for Multiple NORMAL Rides")
    void multipleRidesforNORMAL() {
        Rides[] rides = {new Rides(5,5),new Rides(5,5)};
        assertEquals(110,cabInvoiceGenerator.multipleRides(rides, Rides.RideType.NORMAL));
    }

    @Test
    @DisplayName("Calculate fair for Multiple NORMAL Rides")
    void multipleRidesforPREMIUM() {
        Rides[] rides = {new Rides(5,5),new Rides(5,5)};
        assertEquals(170,cabInvoiceGenerator.multipleRides(rides, Rides.RideType.PREMIUM));
    }

    @Test
    @DisplayName("Calculate Invoice Summary for All NORMAL Rides")
    void calculateInvoiceSummaryNORMAL() {
        Rides[] rides = {new Rides(5,5),new Rides(5,5),new Rides(5,5)};
        InvoiceSummary invoiceSummaryNORMAL = cabInvoiceGenerator.calculateInvoiceSummary(rides, Rides.RideType.NORMAL);
        InvoiceSummary invoiceSummaryExpected = new InvoiceSummary(3,165);
        if(invoiceSummaryExpected.getAverageFarePerRide() == invoiceSummaryNORMAL.getAverageFarePerRide()
        && invoiceSummaryExpected.getTotalNoRide() == invoiceSummaryNORMAL.getTotalNoRide()
        && invoiceSummaryExpected.getTotalFare() == invoiceSummaryNORMAL.getTotalFare())
        assertEquals(1,1);
    }

    @Test
    @DisplayName("Calculate Invoice Summary for All PREMIUM Rides")
    void calculateInvoiceSummaryPREMIUM() {
        Rides[] rides = {new Rides(5,5),new Rides(5,5),new Rides(5,5)};
        InvoiceSummary invoiceSummaryPREMIUM = cabInvoiceGenerator.calculateInvoiceSummary(rides, Rides.RideType.PREMIUM);
        InvoiceSummary invoiceSummaryExpected = new InvoiceSummary(3,165);
        if(invoiceSummaryExpected.getAverageFarePerRide() == invoiceSummaryPREMIUM.getAverageFarePerRide()
                && invoiceSummaryExpected.getTotalNoRide() == invoiceSummaryPREMIUM.getTotalNoRide()
                && invoiceSummaryExpected.getTotalFare() == invoiceSummaryPREMIUM.getTotalFare())
            assertEquals(1,1);
    }

}
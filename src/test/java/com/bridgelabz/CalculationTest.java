package com.bridgelabz;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculationTest {
    Calculation calculation;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        calculation = new Calculation();
    }

    @org.junit.jupiter.api.Test
    void calculate() {
        Assert.assertEquals(10,calculation.add(5,5));
    }

    @Test
    void cube() {
        assertAll(()->assertEquals(27,calculation.cube(3)),
                ()->assertEquals(8,calculation.cube(2)),
                ()->assertEquals(1,calculation.cube(1)));
    }
}
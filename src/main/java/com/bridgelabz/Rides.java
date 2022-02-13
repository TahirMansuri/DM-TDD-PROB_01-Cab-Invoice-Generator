package com.bridgelabz;

public class Rides {
    int distance;
    int duration;
    enum RideType{
        NORMAL,PREMIUM
    };
    public Rides(int distance, int duration) {
        this.distance = distance;
        this.duration = duration;
    }

}

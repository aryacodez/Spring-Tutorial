package com.spring.core.tight;

public class Traveler {
    private Vehicle vehicle;

    public Traveler(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void start(){
        vehicle.move();
    }
}

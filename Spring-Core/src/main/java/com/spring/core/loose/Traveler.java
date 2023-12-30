package com.spring.core.loose;

public class Traveler {
    Car car = null;

    public Traveler() {
        this.car = new Car();
    }

    public void start(){
        this.car.move();
    }
}

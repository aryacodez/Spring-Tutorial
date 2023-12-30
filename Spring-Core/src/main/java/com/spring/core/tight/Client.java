package com.spring.core.tight;

public class Client {
    public static void main(String[] args){
        Vehicle vehicle = new Bike();

        Traveler traveler = new Traveler(vehicle);
        traveler.start();
    }
}

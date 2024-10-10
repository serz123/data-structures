package com.mycompany.hashtableqp;

import java.util.Objects;

public class Vehicle {
    private String registrationNumber;

    public Vehicle(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    @Override
    public int hashCode() {
        return registrationNumber.chars().sum();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vehicle vehicle = (Vehicle) obj;
        return Objects.equals(registrationNumber, vehicle.registrationNumber);
    }

    @Override
    public String toString() {
        return "Vehicle: " +
                "RegistrationNumber='" + registrationNumber + '\'';
    }
}


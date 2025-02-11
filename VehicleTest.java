/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.vehicletest;

/**
 *
 * @author ejones2025
 */

// Main Class to Test Inheritance
 public class VehicleTest {
    public static void main(String[] args) {
        Vehicle[] vehicles = {new SportsCar(), new SUV(), new Sailboat(), new Speedboat(), new Jet(), new PropellerPlane(), new Hovercraft(), new Tank()};
        
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
    }
}

// Base Vehicle Class
class Vehicle {
    protected String name;
    protected int maxSpeed;
    protected String fuelType;

    public Vehicle(String name, int maxSpeed, String fuelType) {
        this.name = name;
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return "Vehicle: " + name + ", Max Speed: " + maxSpeed + " mph, Fuel Type: " + fuelType;
    }
}

// Car Class
class Car extends Vehicle {
    protected int wheels;

    public Car(String name, int maxSpeed, String fuelType, int wheels) {
        super(name, maxSpeed, fuelType);
        this.wheels = wheels;
    }

    @Override
    public String toString() {
        return super.toString() + ", Wheels: " + wheels;
    }
}

// Sports Car Class
class SportsCar extends Car {
    private boolean turbo;

    public SportsCar() {
        super("Sports Car", 200, "Gasoline", 4);
        this.turbo = true;
    }

    @Override
    public String toString() {
        return super.toString() + ", Turbo: " + (turbo ? "Yes" : "No");
    }
}

// SUV Class
class SUV extends Car {
    private boolean allWheelDrive;

    public SUV() {
        super("SUV", 120, "Gasoline", 4);
        this.allWheelDrive = true;
    }

    @Override
    public String toString() {
        return super.toString() + ", All-Wheel Drive: " + (allWheelDrive ? "Yes" : "No");
    }
}

// Boat Class
class Boat extends Vehicle {
    protected boolean hasSails;

    public Boat(String name, int maxSpeed, String fuelType, boolean hasSails) {
        super(name, maxSpeed, fuelType);
        this.hasSails = hasSails;
    }
}

// Sailboat Class
class Sailboat extends Boat {
    public Sailboat() {
        super("Sailboat", 30, "Wind", true);
    }
}

// Speedboat Class
class Speedboat extends Boat {
    public Speedboat() {
        super("Speedboat", 80, "Gasoline", false);
    }
}

// Airplane Class
class Airplane extends Vehicle {
    protected int engines;

    public Airplane(String name, int maxSpeed, String fuelType, int engines) {
        super(name, maxSpeed, fuelType);
        this.engines = engines;
    }
}

// Jet Class
class Jet extends Airplane {
    public Jet() {
        super("Jet", 600, "Jet Fuel", 2);
    }
}

// PropellerPlane Class
class PropellerPlane extends Airplane {
    public PropellerPlane() {
        super("Propeller Plane", 250, "Aviation Gasoline", 1);
    }
}

// Hovercraft Class (Unique)
class Hovercraft extends Vehicle {
    private boolean amphibious;

    public Hovercraft() {
        super("Hovercraft", 50, "Diesel");
        this.amphibious = true;
    }

    @Override
    public String toString() {
        return super.toString() + ", Amphibious: " + (amphibious ? "Yes" : "No");
    }
}

// Tank Class (Unique)
class Tank extends Vehicle {
    private int armorThickness;

    public Tank() {
        super("Tank", 45, "Diesel");
        this.armorThickness = 100;
    }

    @Override
    public String toString() {
        return super.toString() + ", Armor Thickness: " + armorThickness + " mm";
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.polymorphism;

/**
 *
 * @author ejones2025
 */
import java.util.ArrayList;

//abstract base class
abstract class Aircraft {
    protected String wings;
    
    public Aircraft(String wings) {
        this.wings = wings;
    }
    public abstract void displayFeatures();
}

//subclass for single engine plane
class SingleEnginePlane extends Aircraft{
    protected String engineType;
    
    public SingleEnginePlane() {
        super("Fixed Wings");
        this.engineType = "Rotary Engine";
    }
    @Override
    public void displayFeatures() {
        System.out.println("Single Engine Plane -> Wings: "  + wings + ", Engine: " + engineType);
    }
}

//subclass for helicopter
class Helicopter extends SingleEnginePlane {
    private String rotorType;
    
    public Helicopter() {
        super();
        this.rotorType = "Rotating Helicopter Blades";
    }
    @Override
    public void displayFeatures() {
        System.out.println("Helicopter -> Wings: " + wings + ", Engine: " + engineType + ", Rotor: " + rotorType);
    }
}

public class Polymorphism {
    public static void main(String[] args) {
        ArrayList<Aircraft> aircraftList = new ArrayList<>();
        
        aircraftList.add(new SingleEnginePlane());
        aircraftList.add(new Helicopter());
        
        for (Aircraft aircraft : aircraftList){
            aircraft.displayFeatures();
        }
    }
}

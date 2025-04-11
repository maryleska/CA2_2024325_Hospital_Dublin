/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cakesinovenapp;
import java.time.LocalDateTime;

/**
 *
 * @author maryl
 */
public class cake {
    private String name;
    private int weight;
    private String bestBefore;
    private LocalDateTime timeAdded;

    public cake(String name, int weight, String bestBefore) {
        this.name = name;
        this.weight = weight;
        this.bestBefore = bestBefore;
        this.timeAdded = LocalDateTime.now();
    }

    public String getName() { return name; }
    public int getWeight() { return weight; }
    public String getBestBefore() { return bestBefore; }
    public LocalDateTime getTimeAdded() { return timeAdded; }

    @Override
    public String toString() {
        return name + " (" + weight + "g), Best Before: " + bestBefore +
               ", Added: " + timeAdded.toString();
    }
}
 


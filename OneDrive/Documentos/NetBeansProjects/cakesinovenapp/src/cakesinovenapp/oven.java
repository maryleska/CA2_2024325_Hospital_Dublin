/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cakesinovenapp;

/**
 *
 * @author maryl
 */

    import java.util.LinkedList;
import java.util.Queue;

public class oven {
    private Queue<cake> cakes = new LinkedList<>();
    private final int MAX_CAPACITY = 5;

    public boolean addCake(cake cake) {
        if (cakes.size() < MAX_CAPACITY) {
            cakes.add(cake);
            return true;
        } else {
            return false;
        }
    }

    public cake removeCake() {
        if (!cakes.isEmpty()) {
            return cakes.poll();  // remove first
        }
        return null;
    }

    public cake getTopCake() {
        return cakes.peek(); // just see first
    }

    public boolean isFull() {
        return cakes.size() == MAX_CAPACITY;
    }

    public boolean isEmpty() {
        return cakes.isEmpty();
    }

    public String displayAllCakes() {
        if (cakes.isEmpty()) return "Oven is empty.";

        StringBuilder builder = new StringBuilder();
        for (cake c : cakes) {
            builder.append(c.toString()).append("\n");
        }
        return builder.toString();
    }
}



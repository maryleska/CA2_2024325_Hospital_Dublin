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

public class Oven {
    private Queue<Cake> cakes = new LinkedList<>();
    private final int MAX_CAPACITY = 5;

    public boolean addCake(Cake cake) {
        if (cakes.size() < MAX_CAPACITY) {
            cakes.add(cake);
            return true;
        } else {
            return false;
        }
    }

    public Cake removeCake() {
        return cakes.poll();
    }

    public Cake topCake() {
        return cakes.peek();
    }

    public boolean isEmpty() {
        return cakes.isEmpty();
    }

    public boolean isFull() {
        return cakes.size() == MAX_CAPACITY;
    }
}

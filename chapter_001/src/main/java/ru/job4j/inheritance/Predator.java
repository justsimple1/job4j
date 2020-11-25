package ru.job4j.inheritance;

public class Predator extends Animal {
    public Predator() {
        super();
        System.out.println("Predator");
    }

    public static void main(String[] args) {
        Predator predator = new Predator();
    }
}

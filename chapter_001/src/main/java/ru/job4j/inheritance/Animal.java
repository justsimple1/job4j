package ru.job4j.inheritance;

public class Animal {
    private String name;

    public Animal() {
        super();
        System.out.println("Animal");
    }

    public Animal(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Animal animal = new Animal();
    }
}

package ru.job4j.strategy;

import java.util.StringJoiner;

public class Square implements Shape{
    public String draw() {
        StringJoiner pic = new StringJoiner(System.lineSeparator());
        pic.add("++++");
        pic.add("+     +");
        pic.add("+     +");
        pic.add("++++");
        pic.add(System.lineSeparator());
        return pic.toString();
    }
}

package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = -100; i <= 100; i++) {
            numbers.add(i);
        }
        List<Integer> positive = numbers.stream().filter(
                x -> x >= 0
        ).collect(Collectors.toList());
    }
}
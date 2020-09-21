package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] subStr;
        String[] subStr2;
        String point = ". ";
        subStr = left.split(point);
        subStr2 = right.split(point);
        int first = Integer.parseInt(subStr[0]);
        int second = Integer.parseInt(subStr2[0]);
        return Integer.compare(first, second);
    }
}
package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int res = 0;
        int length = left.length() > right.length() ? right.length() : left.length();
            for (int i = 0; i < length; i++) {
                char symbol = left.charAt(i);
                char second = right.charAt(i);
                res = Character.compare(symbol, second);
                if (res != 0) break;
            }
            if (res == 0 && left.length() != right.length()) {
                res = Integer.compare(left.length(), right.length());
            }
        return res;
    }
}
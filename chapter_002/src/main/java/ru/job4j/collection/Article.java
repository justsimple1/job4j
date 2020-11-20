package ru.job4j.collection;

import java.util.HashSet;

public class Article {
    public static boolean generateBy(String origin, String line) {
        String[] text = origin.split(" ");
        String[] text2 = line.split(" ");
        HashSet<String> arr = new HashSet<>();
        boolean result = true;
        for (String word : text) {
            word = word.replaceAll("[^\\da-zA-Zа-яёА-ЯЁ ]", "");
            arr.add(word);
        }
        for (String word : text2) {
            if (!arr.contains(word)) {
                result = false;
                break;
            }
        }
        return result;
    }
}
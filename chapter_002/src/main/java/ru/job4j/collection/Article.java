package ru.job4j.collection;

import java.util.HashMap;

public class Article {
    public static boolean generateBy(String origin, String line) {
        String[] text = origin.split(" ");
        String[] text2 = line.split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        boolean result = true;
        int i = 1;
        for (String word: text) {
            word = word.replaceAll("[^\\da-zA-Zа-яёА-ЯЁ ]", "");
            map.put(word, i);
        }
        for (String word: text2) {
            if(map.getOrDefault(word, 0) == 0) {
                result = false;
                break;
            }
        }
        return result;
    }
}
package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class DiapasonFunc {
    public List<Double> diapason(int start, int end, Function<Double, Double> func) {
       List<Double> dist = new ArrayList<>();
        for (int i = start; i < end; i++) {
           dist.add(func.apply((double) i));
        }
        return dist;
    }
}

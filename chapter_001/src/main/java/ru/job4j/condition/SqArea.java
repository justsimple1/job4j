package ru.job4j.condition;

public class SqArea {
    public static double square(int p, int k) {
        double square = k * (p / (2 * (k + 1))) * (p / (2 * (k + 1)));
        return square;
    }

    public static void main(String[] args) {
        double result = SqArea.square(6, 2);
        System.out.println(" p = 6, k = 2, s = 2, real = " + result);

    }
}

package ru.job4j.converter;

public class Converter {

    public static int rubleToEuro(int value) {
        return value / 70;
    }

    public static int rubleToDollar(int value) {
        return value / 60;
    }

    public static int euroToRuble(int value) {
        return value * 70;
    }

    public static int dollarToRuble(int value) {
        return value * 60;
    }

    public static void main(String[] args) {
        int in = 140;
        int expected = 2;
        int out = rubleToEuro(in);
        boolean passed = expected == out;
        System.out.println("140 rubles is 2 euros. Test result : " + passed);
        in = 120;
        out = rubleToDollar(in);
        passed = expected == out;
        System.out.println("120 rubles is 2 dollars. Test result : " + passed);
        in = 2;
        expected = 140;
        out = euroToRuble(in);
        passed = expected == out;
        System.out.println("2 euros is 140 rubles. Test result : " + passed);
        in = 3;
        expected = 180;
        out = dollarToRuble(in);
        passed = expected == out;
        System.out.println("3 dollars is 180 rubles. Test result : " + passed);
    }
}

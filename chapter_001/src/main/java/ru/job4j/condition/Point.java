package ru.job4j.condition;

public class Point {
    public static double distance(int x1, int x2, int y1, int y2) {
        double result = Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1),2));
        return result;
    }

    public static void main(String[] args) {
        double result = Point.distance(1,4,2,6);
        System.out.println("result (1, 2) to (4, 6) is " + result);
        result = Point.distance(6,10,8,11);
        System.out.println("result (3, 5) to (1, 8) is " + result);
    }
}

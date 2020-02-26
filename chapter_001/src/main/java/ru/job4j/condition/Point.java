package ru.job4j.condition;

public class Point {

    private int x;
    private int y;
    private int z;

    public Point(int first, int second) {
        this.x = first;
        this.y = second;
    }
    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double distance(Point that) {
        return Math.sqrt(Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2));
    }
    public double distance3d(Point that) {
        return Math.sqrt(Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2) + Math.pow(this.z - that.z, 2));
    }
    public static void main(String[] args) {
        Point first = new Point(1, 2);
        Point second = new Point(4, 6);
        Point first3d = new Point(2, 5, 6);
        Point second3d = new Point(4, 6, 1);
        double distance = first.distance(second);
        double distance3d = first3d.distance3d(second3d);
        System.out.println(distance);
        System.out.println(distance3d);
    }
}

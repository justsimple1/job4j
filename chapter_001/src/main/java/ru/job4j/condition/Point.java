package ru.job4j.condition;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class Point {

    private int x;
    private int y;

    public Point(int first, int second) {
        this.x = first;
        this.y = second;
    }

    public double distance(Point that) {
        return Math.sqrt(Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2));
    }

    public static void main(String[] args) {
        Point first = new Point(1, 2);
        Point second = new Point(4, 6);
        double distance = first.distance(second);
        System.out.println(distance);
    }
}

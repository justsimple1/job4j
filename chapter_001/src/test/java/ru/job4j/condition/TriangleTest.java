package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TriangleTest {
    @Test
    public void whenExist() {
        boolean result = Triangle.exist(2.0, 2.0, 2.0);
        assertThat(result, is(true));
    }

    @Test
    public void whenNoExist() {
        boolean result = Triangle.exist(1.0, 4.0, 18.0);
        assertThat(result, is(false));
    }

    @Test
    public void whenExistNoSquare() {
        Point a = new Point(1, 2);
        Point b = new Point(1, 3);
        Point c = new Point(1, 4);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        double exp = -1;
        assertThat(rsl, is(exp));
    }

    @Test
    public void whenExistSquare() {
        Point a = new Point(5, 10);
        Point b = new Point(10, 5);
        Point c = new Point(5, 5);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        double exp = 12.5;
        assertThat(rsl, is(exp));
    }
}
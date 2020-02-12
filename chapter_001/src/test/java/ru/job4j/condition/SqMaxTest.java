package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SqMaxTest {

    @Test
    public void whenMaxIsThird(){
        int in = SqMax.max(6,4,7,5);
        int expected = 7;
        assertThat(in, is(expected));
    }

    @Test
    public void whenMaxIsFirst(){
        int in = SqMax.max(6,4,1,5);
        int expected = 6;
        assertThat(in, is(expected));
    }

    @Test
    public void whenMaxIsSecond(){
        int in = SqMax.max(6,14,1,5);
        int expected = 14;
        assertThat(in, is(expected));
    }

    @Test
    public void whenMaxIsFourth(){
        int in = SqMax.max(6,4,1,9);
        int expected = 9;
        assertThat(in, is(expected));
    }
}

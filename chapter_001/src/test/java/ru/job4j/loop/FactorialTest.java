package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FactorialTest {
    @Test
    public void whenCalculateFactorialForFiveThenOneHundreedTwenty() {
        int calc = Factorial.calc(5);
        int expected = 120;
        assertThat(calc, is(expected));
    }

    @Test
    public void whenCalculateFactorialForZeroThenOne() {
        int calc = Factorial.calc(0);
        int expected = 1;
        assertThat(calc, is(expected));
    }
}

package ru.job4j.lambda;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FunctionTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        DiapasonFunc func = new DiapasonFunc();
        List<Double> result = func.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }
    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        DiapasonFunc func = new DiapasonFunc();
        List<Double> result = func.diapason(5, 8, x -> 2 * Math.pow(x, 2) + 3 * x - 5);
        List<Double> expected = Arrays.asList(60D, 85D, 114D);
        assertThat(result, is(expected));
    }
    @Test
    public void whenConstantFunctionThenPermanentResults() {
        DiapasonFunc func = new DiapasonFunc();
        List<Double> result = func.diapason(2, 5, x -> Math.pow(3, x));
        List<Double> expected = Arrays.asList(9D, 27D, 81D);
        assertThat(result, is(expected));
    }
}
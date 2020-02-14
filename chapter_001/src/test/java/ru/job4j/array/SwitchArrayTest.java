package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SwitchArrayTest {
    @Test
    public void whenSwap0to3() {
        int[] input = {1, 2, 3, 4};
        int[] expected = {4, 2, 3, 1};
        int[] result = SwitchArray.swap(input, 0, input.length - 1);
        assertThat(result, is(expected));
    }
    @Test
    public void whenSwap3to7() {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] expected = {1, 2, 3, 8, 5, 6, 7, 4};
        int[] result = SwitchArray.swap(input, 3, 7);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSwap2to6() {
        int[] input = {10, 11, 16, 13, 14, 15, 12, 17};
        int[] expected = {10, 11, 12, 13, 14, 15, 16, 17};
        int[] result = SwitchArray.swap(input, 2, 6);
        assertThat(result, is(expected));
    }
}

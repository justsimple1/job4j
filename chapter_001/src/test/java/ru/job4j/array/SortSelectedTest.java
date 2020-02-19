package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortSelectedTest {
    @Test
    public void whenSorting5numbers() {
        int[] input = new int[] {3, 4, 1, 2, 5};
        int[] result = SortSelected.sort(input);
        int[] expect = new int[] {1, 2, 3, 4, 5};
        assertThat(result, is(expect));
    }

    @Test
    public void whenSorting3numbers() {
        int[] input = new int[] {3, 1, 2};
        int[] result = SortSelected.sort(input);
        int[] expect = new int[] {1, 2, 3};
        assertThat(result, is(expect));
    }

    @Test
    public void whenSorting10numbers() {
        int[] input = new int[] {3, 1, 2, 15, 7, 10, 11, 6, 24, 15};
        int[] result = SortSelected.sort(input);
        int[] expect = new int[] {1, 2, 3, 6, 7, 10, 11, 15, 15, 24};
        assertThat(result, is(expect));
    }
}

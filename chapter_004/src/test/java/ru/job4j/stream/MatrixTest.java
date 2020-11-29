package ru.job4j.stream;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixTest {

    @Test
    public void whenMatrixThenList() {
        Integer[][] matrix = {{1, 2}, {2, 1}};
        List<Integer> rsl = new Matrix().matrixToList(matrix);
        List<Integer> exp = List.of(1, 2, 2, 1);
        assertThat(rsl, is(exp));
    }
}
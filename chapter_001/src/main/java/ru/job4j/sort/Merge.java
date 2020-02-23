package ru.job4j.sort;

import java.util.Arrays;

public class Merge {
    public int[] merge(int[] left, int[] right) {
        int[] rsl = new int[left.length + right.length];
        int index = 0;
        int count = 0;
        int i = 0 ;
        while (index < rsl.length) {
            if ((right.length - 1 - i < 0 ) && (left.length - 1 - count >= 0 ) || ((left.length - 1 - count >= 0 ) && (left[count] < right[i]))) {
                rsl[index++] = left[count++];
            } else {
                rsl[index++] = right[i++];
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        Merge process = new Merge();
        int[] rsl = process.merge(
                new int[] {1, 3, 5},
                new int[] {2, 4}
        );
        System.out.println(Arrays.toString(rsl));
    }
}

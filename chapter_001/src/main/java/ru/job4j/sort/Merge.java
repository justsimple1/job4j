package ru.job4j.sort;

import java.util.Arrays;

public class Merge {
    public int[] merge(int[] left, int[] right) {
        int[] rsl = new int[left.length + right.length];
        int index = 0;
        int count = 0;
        int i = 0 ;
        while (index < rsl.length - 1) {
            if (left.length == i) {
                System.arraycopy(right, count, rsl, index++, right.length - count);
                break;
            }
            if (count == right.length) {
                System.arraycopy(left, i, rsl, ++index, left.length - i);
                break;
            }
            rsl[index] = left[i] < right[count] ? left[i++] : right[count++];
            if (i == left.length) {
                System.arraycopy(right, count, rsl, ++index, right.length - count);
                break;
            }
            if (count == right.length) {
                System.arraycopy(left, i, rsl, ++index, left.length - i);
                break;
            }
            index++;
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

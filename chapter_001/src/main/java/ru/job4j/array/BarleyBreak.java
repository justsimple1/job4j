package ru.job4j.array;

public class BarleyBreak {
    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        int temp = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = temp++;
            }
        }
    }
}

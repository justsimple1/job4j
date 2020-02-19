package ru.job4j.array;

public class SortSelected {
    public static int[] sort(int[] data) {
        int temp = 0;
        for (int index = 0; index < data.length; index++) {
            int min = MinDiapason.findMin(data, index, data.length-1);
            int i = FindLoop.indexOf(data, min, index, data.length-1);
            if(data[index] > min){
                temp = data[index];
                data[index] = min;
                data[i] = temp;
            }
        }
        return data;
    }
}

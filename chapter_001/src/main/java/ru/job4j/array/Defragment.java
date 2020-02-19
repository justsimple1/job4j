package ru.job4j.array;

    public class Defragment {
        public static String[] compress(String[] array) {
            String temp = null;
            for (int index = 0; index < array.length; index++) {
                if (array[index] == null) {
                    int point = index; // указатель, на не null ячейку.
                    while (array[point] == null && point < array.length-1){
                            point++;
                    }
                    temp = array[point];
                    array[point] = array[index];
                    array[index] = temp;
                }
                System.out.print(array[index] + " ");
            }
            return array;
        }

        public static void main(String[] args) {
            String[] input = {"I", null, "wanna", null, "be", null, "compressed"};
            String[] compressed = compress(input);
            System.out.println();
            for (int index = 0; index < compressed.length; index++) {
                System.out.print(compressed[index] + " ");
            }
        }
    }


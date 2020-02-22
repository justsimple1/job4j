package ru.job4j.loop;

public class PrimeNumber {
    public int calc(int finish) {
        int sum = 0;
        for (int index = 2; index <= finish; index++) {
           if (CheckPrimeNumber.check(index)) {
               sum++;
           }
        }
       return sum;
    }
}

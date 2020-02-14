package ru.job4j.loop;

public class CheckPrimeNumber {
    public static boolean check(int n){
        boolean prime = true;
        if (n == 1) prime = false;
        for(int i = 2; i < n; i++){
            if(n%i == 0){
               prime = false;
               break;
            }
        }
        return prime;
    }
}

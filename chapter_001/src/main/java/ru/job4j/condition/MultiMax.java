package ru.job4j.condition;

public class MultiMax {
    public int max(int first, int second) {
        return first > second ? first : second;
    }
    public int max(int first, int second, int third) {
        return max(first, second) > third ? max(first, second) : third;
    }
    public int max(int first, int second, int third, int fourth) {
        return max(first, second, third) > fourth ? max(first, second, third) : fourth;
    }
}

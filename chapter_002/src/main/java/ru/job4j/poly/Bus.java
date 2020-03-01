package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void ride() {
    }

    @Override
    public void passengers() {
    }

    @Override
    public int fillUp(int liters) {
        return liters * 60;
    }
}

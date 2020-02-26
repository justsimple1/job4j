package ru.job4j.inheritance;

public class Dentist extends Doctor {
    public Tooth freezing(Pacient pacient) {return null;}
}

class Tooth {
    private int number;
    public int getNumberTooth(){return number;}
}
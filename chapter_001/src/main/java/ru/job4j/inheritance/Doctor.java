package ru.job4j.inheritance;

public class Doctor extends Profession {
    public Diagnose heal(Pacient pacient) {
        return null;
    }
}

class Diagnose {
    private String titleDisease;
    public String getTitleDisease() {
        return titleDisease;
    }
}

class Pacient {
    private String symptoms;
    private String name;
    public String getSymptoms() {
        return symptoms;
    }
    public String getName() {
        return name;
    }
}
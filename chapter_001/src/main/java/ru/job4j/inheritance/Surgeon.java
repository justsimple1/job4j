package ru.job4j.inheritance;

public class Surgeon extends Doctor{
    public Organ cut(Pacient pacient){return null;}
}

class Organ {
    private String titleOrgan;
    public String getTitleOrgan() {return titleOrgan;}
}
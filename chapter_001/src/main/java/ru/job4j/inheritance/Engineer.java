package ru.job4j.inheritance;

public class Engineer extends Profession {
    public Scheme planning(House House){return null;}
}

class Scheme {
    private String format;
    private String style;
    public String getFormat(){return format;}
    public String getStyle(){return style;}
}

class House {
    private String size;
    private String place;
    public String getSize(){return size;}
    public String getPlace(){return place;}
}
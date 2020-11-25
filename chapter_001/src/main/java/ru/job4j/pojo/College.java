package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Panin N. N.");
        student.setGroup("intern");
        student.setCreated(new Date());
        System.out.println(student.getFio() + " entered in group - '"
                + student.getGroup() + "' : "
                + student.getCreated());
    }
}

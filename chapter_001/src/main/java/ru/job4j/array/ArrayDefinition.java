package ru.job4j.array;

public class ArrayDefinition {
    public static void main(String[] args) {
        String[] name = new String[4];
        name[0] = "Victor";
        name[1] = "Petr";
        name[2] = "Sergey";
        name[3] = "Anatoliy";
        for (int index = 0; index < 4; index++) {
            System.out.println(name[index]);
        }
    }
}

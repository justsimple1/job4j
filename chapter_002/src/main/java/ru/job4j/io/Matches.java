package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public int enter(String name, Scanner input, int count) {
        System.out.println("Вводит игрок с именем " + name);
        count -= Integer.valueOf(input.nextLine());
        System.out.println(count <= 0 ? "Победил игрок " + name : "Спичек ос3талось " + count);
        return count;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Matches player = new Matches();
        Matches player2 = new Matches();
        int count = 11;
        while (count > 0) {
            count = player.enter("Sasha", input, count);
            if (count <= 0) {
                break;
            }
            count = player2.enter("Grisha", input, count);
        }
    }
}

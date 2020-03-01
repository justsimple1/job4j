package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public void ask() {
        int answer = new Random().nextInt(3);
        if (answer == 0) {
            System.out.println("Да");
        } else if (answer == 1) {
            System.out.println("Нет");
        } else {
            System.out.println("Может быть");
        }
    }

    public static void main(String[] args) {
        MagicBall magic = new MagicBall();
        Scanner input = new Scanner(System.in);
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        String name = input.nextLine();
        System.out.println("Хм.. твой вопрос '" + name + "' действительно хорош. Мой тебе ответ будет следующим");
        magic.ask();
    }
}

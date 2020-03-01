package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Find all Items ====");
                Item[] result = tracker.findAll();
                for (Item item: result) {
                    System.out.println("Name = " + item.getName() + " id = " + item.getId());
                }
            } else if (select == 2) {
                System.out.println("=== Edit Item by id ====");
                System.out.print("Enter name new Item: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                System.out.print("Enter id: ");
                String id = scanner.nextLine();
                if (tracker.replace(id, item)) {
                    System.out.println("Successful");
                } else {
                    System.out.println("Error. Id not found");
                }
            } else if (select == 3) {
                System.out.println("=== Delete Item by id ====");
                System.out.print("Enter id: ");
                String id = scanner.nextLine();
                if (tracker.delete(id)) {
                    System.out.println("Successful");
                } else {
                    System.out.println("Error. Id not found");
                }
            } else if (select == 4) {
                System.out.println("=== Find Item by id ====");
                System.out.print("Enter id: ");
                String id = scanner.nextLine();
                Item item = tracker.findById(id);
                System.out.println("Name =" + item.getName() + " id = " + item.getId());
            } else if (select == 5) {
                System.out.println("=== Find Items by name ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item[] result = tracker.findByName(name);
                for (Item item: result) {
                    System.out.println("Name =" + item.getName() + " id = " + item.getId());
                }
            }   else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println(" 6. Exit Program");
    }

    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Scanner input = new Scanner(System.in);
        new StartUI().init(input, tracker);
    }
}

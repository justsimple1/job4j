package ru.job4j.tracker;

public class StartUI {
    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }
    public static void findAll(Tracker tracker) {
        System.out.println("=== Find all Items ====");
        Item[] result = tracker.findAll();
        for (Item item: result) {
            System.out.println("Name = " + item.getName() + " id = " + item.getId());
        }
    }
    public static void editItem(Input input, Tracker tracker) {
        System.out.println("=== Edit Item by id ====");
        String name = input.askStr("Enter name new Item: ");
        Item item = new Item(name);
        String id = input.askStr("Enter id: ");
        if (tracker.replace(id, item)) {
            System.out.println("Successful");
        } else {
            System.out.println("Error. Id not found");
        }
    }
    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete Item by id ====");
        String id = input.askStr("Enter id: ");
        if (tracker.delete(id)) {
            System.out.println("Successful");
        } else {
            System.out.println("Error. Id not found");
        }
    }
    public static void findById(Input input, Tracker tracker) {
        System.out.println("=== Find Item by id ====");
        String id = input.askStr("Enter id: ");
        Item item = tracker.findById(id);
          if (item != null) {
              System.out.println("Name =" + item.getName() + " id = " + item.getId());
          } else {
              System.out.println("Error. Id not found");
          }
    }
    public static void findByName(Input input, Tracker tracker) {
        System.out.println("=== Find Items by name ====");
        String name = input.askStr("Enter name: ");
        Item[] result = tracker.findByName(name);
        for (Item item: result) {
            System.out.println("Name =" + item.getName() + " id = " + item.getId());
        }
    }
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(input.askStr("Select: "));
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.findAll(tracker);
            } else if (select == 2) {
                StartUI.editItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findById(input, tracker);
            } else if (select == 5) {
                StartUI.findByName(input, tracker);
            }   else if (select == 6) {
                run = false;
            } else {
                System.out.println("Please enter number 0 to 6");
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
        Input input = new ConsoleInput();
        new StartUI().init(input, tracker);
    }
}

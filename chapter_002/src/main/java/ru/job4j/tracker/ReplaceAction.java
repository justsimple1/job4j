package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "=== Replace item by id ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name:");
        Item item = new Item(name);
        String id = input.askStr("Enter id:");
        if (tracker.replace(id, item)) {
            System.out.println("Successful");
        } else {
            System.out.println("Error. Id not found");
        }
        return true;
    }
}

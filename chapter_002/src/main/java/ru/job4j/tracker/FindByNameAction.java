package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find Items by name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name:");
        Item[] result = tracker.findByName(name);
        for (Item item: result) {
            System.out.println(String.format("%s %s", item.getName(), item.getId()));
        }
        return true;
    }
}

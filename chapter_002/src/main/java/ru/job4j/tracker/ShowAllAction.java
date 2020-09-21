package ru.job4j.tracker;

public class ShowAllAction implements UserAction {
    @Override
    public String name() {
        return "=== Show all items ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
//        Item[] result = tracker.findAll();
//        for (Item item: result) {
//            System.out.println(String.format("%s %s", item.getName(), item.getId()));
//        }
        return true;
    }
}

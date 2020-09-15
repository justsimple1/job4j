package ru.job4j.tracker;

import java.util.Comparator;

public class Item implements Comparator<Item> {
    private String name;
    private String id;

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int compare(Item first, Item second) {
        return first.getName().compareTo(second.getName());
    }

    @Override
    public String toString() {
        return "Job{" +
                "name='" + name + '\'' +
                '}';
    }
}

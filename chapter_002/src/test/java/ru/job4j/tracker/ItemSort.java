package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class ItemSort {
    @Test
    public void whenSortToHigh() {
        Item item = new Item();
        List<Item> items = Arrays.asList(
                new Item("Load server"),
                new Item("Find bugs"),
                new Item("Create task")
        );
        List<Item> items2 = Arrays.asList(
                new Item("Create task"),
                new Item("Find bugs"),
                new Item("Load server")
        );
        Collections.sort(items, new Item());
        assertThat(item.compare(items.get(0), items2.get(0)), is(0));
        assertThat(item.compare(items.get(1), items2.get(1)), is(0));
        assertThat(item.compare(items.get(2), items2.get(2)), is(0));
    }

    @Test
    public void whenSortToLow() {
        Item item = new Item();
        List<Item> items = Arrays.asList(
                new Item("Create task"),
                new Item("Find bugs"),
                new Item("Load server")
        );
        List<Item> items2 = Arrays.asList(
                new Item("Load server"),
                new Item("Find bugs"),
                new Item("Create task")
        );
        Comparator c = Collections.reverseOrder(new Item());
        Collections.sort(items, c);
        assertThat(item.compare(items.get(0), items2.get(0)), is(0));
        assertThat(item.compare(items.get(1), items2.get(1)), is(0));
        assertThat(item.compare(items.get(2), items2.get(2)), is(0));
    }
}

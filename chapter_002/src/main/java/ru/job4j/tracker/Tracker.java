package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tracker {
    /**
     * Коллекция для хранение заявок.
     */
    private  List<Item> items = new ArrayList<Item>();
    /**
     * Метод реализующий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        if (!items.contains(item)){
            this.items.add(item);
        }
        return item;
    }
    /**
     * Метод выводящий список всех заявок.
     * @return items массив заявок.
     */
    public  List<Item> findAll() {
        return items;
    }
    /**
     * Метод выводящий список заявок с определённым именем
     * @param key имя заявки
     * @return список заявок по указанному имени
     */
    public List<Item> findByName(String key) {
        List<Item> names = new ArrayList<Item>();
        for (Item name: items) {
            if (name.getName().equals(key)) {
                names.add(name);
            }
        }
        return names;
    }
    /**
     * Метод возращает индекс искомого элеиента Находим индекс
     * @return - индекс искоомого
     */
    private int indexOf(String id) {
       int index= items.indexOf(id);
        int rsl = -1;
        for (Item item: items) {
            if (item.getId().equals(id)) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }
    /**
     * Метод заменяющий, существующую заяку по id на новосозданную
     * @param id ключ заменяемой заявки
     * @param item заявка на которую заменяем
     * @return rsl - провели или не провели заявку.
     */
    public boolean replace(String id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
            item.setId(items.get(index).getId());
            items.set(index, item);
        }
        return index != -1 ? true : false;
    }
    /**
     * Метод выводящий заявку по id
     * @param id уникальный идентификатор заявки
     * @return заявка по указанному id
     */
    public Item findById(String id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }
    /**
     * Метод удаляет заявку по id.
     * @param id идентификатор удаляемой заявки
     * @return удалили или не удалили заявку
     */
    public boolean delete(String id) {
        int index = indexOf(id);
        if (index != -1) {
            items.remove(index);
        }
        return index != -1 ? true : false;
    }
    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }
}
package ru.job4j.tracker;


import java.util.Arrays;
import java.util.Random;

public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод реализующий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }
    /**
     * Метод выводящий список всех заявок.
     * @return items массив заявок.
     */
    public Item[] findAll() {
        return Arrays.copyOf(items, position);
    }
    /**
     * Метод выводящий список заявок с определённым именем
     * @param key имя заявки
     * @return список заявок по указанному имени
     */
    public Item[] findByName(String key) {
        Item[] names = new Item[position];
        int size = 0;
        for (int index = 0; index < position; index++) {
            if (items[index].getName().equals(key)) {
                names[size] = items[index];
                size++;
            }
        }
        names = size > 0 ? Arrays.copyOf(items, size) : new Item[0];
        return names;
    }
    /**
     * Метод возращает индекс искомого элеиента Находим индекс
     * @return - индекс искоомого
     */
    private int indexOf(String id) {
        int rsl = -1;
        for (int index = 0; index < position; index++) {
            if (items[index].getId().equals(id)) {
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
            item.setId(items[index].getId());
            items[index] = item;
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
        return index != -1 ? items[index] : null;
    }
    /**
     * Метод удаляет заявку по id.
     * @param id идентификатор удаляемой заявки
     * @return удалили или не удалили заявку
     */
    public boolean delete(String id) {
        int index = indexOf(id);
        if (index != -1) {
            System.arraycopy(items, index + 1, items, index, position - index);
            items[position - 1] = null;
            position--;
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
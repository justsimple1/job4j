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
        item.setId(Long.parseLong(this.generateId()));
        this.items[this.position++] = item;
        return item;
    }
    /**
     * Метод выводящий список всех заявок.
     * @return items массив заявок.
     */
    public Item[] findAll() {
        Item[] exists = new Item[position];
        for (int index = 0; index < position; index++) {
            exists[index] = items[index];
        }
        return exists;
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
            if(items[index].getName() == key){
                names[size] = items[index];
                size++;
            }
        }
        names = size > 0 ? Arrays.copyOf(items, size) : null;
        return names;
    }

    private int indexOf(long id) {
        int rsl = -1;
        for (int index = 0; index < position; index++) {
            if (items[index].getId() == (id)) {
                rsl = index;
            }
        }
        return rsl;
    }
    /**
     * Метод выводящий заявку по id
     * @param id уникальный идентификатор заявки
     * @return заявка по указанному id
     */
    public Item findById(long id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    /**
     * Метод удаляет заявку по id.
     * @param id идентификатор удаляемой заявки
     * @return
     */
    public boolean delete(String id) {
        items[indexOf(id)] = null;
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

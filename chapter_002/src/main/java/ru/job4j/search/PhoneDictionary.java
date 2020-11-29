package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public ArrayList<Person> find(String key) {

        Predicate<Person> name = x -> x.getName().contains(key);
        Predicate<Person> surname = x -> x.getSurname().contains(key);
        Predicate<Person> phone = x -> x.getPhone().contains(key);
        Predicate<Person> address = x -> x.getPhone().contains(key);

        var combine = name.or(surname).or(phone).or(address);
        var result = new ArrayList<Person>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
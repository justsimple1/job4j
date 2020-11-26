package ru.job4j.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {
    private List<Profile> profiles = new ArrayList<>();

    @Before
    public void setUp() {
        profiles.add(new Profile(new Address("Москва","Лубянка", 12, 5)));
        profiles.add(new Profile(new Address("Санкт-Петербург","пр-кт Ленина", 21, 51)));
        profiles.add(new Profile(new Address("Челябинск","Бульвар мира", 22, 35)));
        profiles.add(new Profile(new Address("Нижний Новгород","пр-кт Гагарина", 123, 25)));
        profiles.add(new Profile(new Address("Москва","Лубянка", 12, 5)));
        profiles.add(new Profile(new Address("Екатеринбург","Металургов", 62, 71)));
        profiles.add(new Profile(new Address("Нижний Новгород","пр-кт Гагарина", 123, 25)));
    }
    @Test
    public void collectTest() {
        Profiles arr = new Profiles();
        List<Address> rsl = arr.collect(profiles);
        List<Address> exp = new ArrayList<>();
        exp.add(new Address("Екатеринбург","Металургов", 62, 71));
        exp.add(new Address("Москва","Лубянка", 12, 5));
        exp.add(new Address("Нижний Новгород","пр-кт Гагарина", 123, 25));
        exp.add(new Address("Санкт-Петербург","пр-кт Ленина", 21, 51));
        exp.add(new Address("Челябинск","Бульвар мира", 22, 35));
        assertThat(rsl, is(exp));
    }
}
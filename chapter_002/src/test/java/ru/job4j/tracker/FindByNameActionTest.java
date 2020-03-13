package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FindByNameActionTest {

    @Test
    public void whenCheckOutputByName() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream stdout = System.out;
        System.setOut(new PrintStream(out));
        Tracker tracker = new Tracker();
        Item item = new Item("test");
        tracker.add(item);
        FindByNameAction act = new FindByNameAction();
        act.execute(new StubInput(new String[] {"test"}), tracker);
        String expected = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add(item.getName() + " " + item.getId())
                .toString();
        assertThat(new String(out.toByteArray()), is(expected));
        System.setOut(stdout);
    }
}

package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    @Test
    public void whenExit() {
        StubInput input = new StubInput(
                new String[] {"0"}
        );
        StubAction action = new StubAction();
//        new StartUI().init(input, new Tracker(), new UserAction[] {action});
//        assertThat(action.isCall(), is(true));
    }

    @Test
    public void workingMenu() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream stdout = System.out;
        System.setOut(new PrintStream(out));
        StubInput input = new StubInput(new String[] {"0"});
        StubAction act = new StubAction();
//        new StartUI().init(input, new Tracker(), new UserAction[] {act});
        String expected = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("0. Stub Action")
                .toString();
        assertThat(new String(out.toByteArray()), is(expected));
        System.setOut(stdout);
    }
}

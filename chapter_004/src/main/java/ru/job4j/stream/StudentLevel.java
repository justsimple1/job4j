package ru.job4j.stream;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentLevel {
    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .filter(Objects::nonNull)
                .sorted((left, right) -> right.getScore() - left.getScore())
                .takeWhile(st -> st.getScore() > bound)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Stream.of(1, null, 2, null, 3)
                .flatMap(Stream::ofNullable)
                .map(v -> String.format(" %s", v))
                .forEach(System.out::print);
    }
}

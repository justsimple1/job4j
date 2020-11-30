package ru.job4j.stream;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * Class для подсчета статистики по аттестатам учеников*/
public class Analyze {

    /**
     * Метод вычисляет общий средний балл.
     *  @return число среднего балла.
     * */
    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(e -> e.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0D);
    }

    /**
     * Метод вычисляет средний балл ученика по его предметам.
     *  @return список из объекта Tuple (Имя ученика и средний балл).
     * */
    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(e -> new Tuple(e.getName(),
                (e.getSubjects().stream())
                        .mapToInt(Subject::getScore)
                        .average().orElse(0D)))
                .collect(Collectors.toList());
    }

    /**
     * Метод вычисляет средний бал всех предметов у каждого ученика.
     *  @return список из объекта Tuple (название предмета и средний балл).
     * */
    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return  stream.flatMap(e -> e.getSubjects().stream())
                .collect(Collectors.
                        groupingBy(Subject::getName, LinkedHashMap::new,
                                Collectors.averagingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(e -> new Tuple(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    /**
     * Метод вычисляет ученика с наибольшим баллом по всем предметам.
     *  @return ученика лучшего по всем предмтам.
     * */
    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(e -> new Tuple(e.getName(), (e.getSubjects().stream())
                .mapToInt(Subject::getScore).sum()))
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(null);
    }

    /**
     * Метод вычисляет предмет с наибольшим баллом для всех студентов.
     *  @return объект Tuple (имя предмета, сумма баллов каждого ученика по этому предмету)
     * */
    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(e -> e.getSubjects().stream())
                .collect(Collectors
                        .groupingBy(Subject::getName,
                                Collectors.summingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(e -> new Tuple(e.getKey(), e.getValue()))
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(null);
    }
}
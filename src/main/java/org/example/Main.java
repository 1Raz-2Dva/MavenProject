package org.example;

import java.util.ArrayList;
import java.util.Optional;


public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Student1", List.of(new Book("Book3", 2023))));
        students.add(new Student("Student2", List.of(new Book("Book1", 2024))));
        students.add(new Student("Student3", List.of(new Book("Book2", 10))));

        Optional<Integer> latestYear = students.stream()
                .flatMap(student -> student.getBooks().stream())
                .map(Book::getYear)
                .distinct()
                .reduce((first, second) -> second);

        latestYear.ifPresentOrElse(
                year -> System.out.println("Последний год выпуска книг: " + year),
                () -> System.out.println("Данные не найдены."));
    }
}


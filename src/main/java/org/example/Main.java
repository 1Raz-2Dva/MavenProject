package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class Book {
    private String title;
    private int year;

    public Book(String title, int year) {
        this.title = title;
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Book [title=" + title + ", year=" + year + "]";
    }
}

class Student {
    private String firstName;
    private List<Book> books;

    public Student(String firstName, List<Book> books) {
        this.firstName = firstName;
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }
}

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
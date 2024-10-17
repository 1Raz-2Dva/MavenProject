package org.example;

import java.util.List;

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

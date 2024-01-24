package org.example;

import org.example.model.Author;
import org.example.service.AuthorService;
import org.example.service.BookService;
import org.example.service.serviceImpl.AuthorServiceImpl;
import org.example.service.serviceImpl.BookServiceImpl;

import java.time.LocalDate;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        AuthorService authorService = new AuthorServiceImpl();
//        System.out.println(authorService.createAuthorTable());
//        System.out.println(authorService.updateAuthorById(1L, new Author("Nurlan", "LastName", "nurlan@gmail.com", "kg", LocalDate.of(2007, 12, 12))));
//        System.out.println(authorService.findAllAuthors());

        BookService bookService = new BookServiceImpl();
//        System.out.println(bookService.createBookTable());

        System.out.println(bookService.findAllAuthorBookById(1L));
    }
}

package org.example.service;

import org.example.model.Book;

import java.util.List;

public interface BookService {


    String createBookTable();
    boolean saveBook(Long authorId, Book book);
    List<Book> findAllAuthorBookById(Long authorId);
}

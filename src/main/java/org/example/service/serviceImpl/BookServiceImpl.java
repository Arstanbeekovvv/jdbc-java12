package org.example.service.serviceImpl;

import org.example.dao.BookDao;
import org.example.dao.impl.BookDaoImpl;
import org.example.model.Book;
import org.example.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    private final BookDao bookDao = new BookDaoImpl();

    @Override
    public String createBookTable() {
        return bookDao.createBookTable();
    }

    @Override
    public boolean saveBook(Long authorId, Book book) {
        return false;
    }

    @Override
    public List<Book> findAllAuthorBookById(Long authorId) {
        return bookDao.findAllAuthorBookById(authorId);
    }
}

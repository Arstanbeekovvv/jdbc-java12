package org.example.service.serviceImpl;

import org.example.dao.AuthorDao;
import org.example.dao.impl.AuthorDaoImpl;
import org.example.model.Author;
import org.example.service.AuthorService;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {

    private final AuthorDao authorDao = new AuthorDaoImpl();

    @Override
    public boolean createAuthorTable() {
        return authorDao.createAuthorTable();
    }

    @Override
    public String saveAuthor(Author newAuthor) {
        return null;
    }

    @Override
    public String updateAuthorById(Long id, Author author) {
        return authorDao.updateAuthorById(id, author);
    }

    @Override
    public Author findAuthorById(Long id) {
        return null;
    }

    @Override
    public void deleteAuthorById(Long id) {

    }

    @Override
    public List<Author> findAllAuthors() {
        return authorDao.findAllAuthors();
    }

    @Override
    public void dropAuthorTable() {

    }

    @Override
    public boolean cleanTable() {
        return false;
    }

    @Override
    public List<Author> sortByDateOfBirth() {
        return null;
    }
}

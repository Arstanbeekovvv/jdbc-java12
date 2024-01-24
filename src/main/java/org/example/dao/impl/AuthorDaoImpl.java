package org.example.dao.impl;

import org.example.config.JdbcConfig;
import org.example.dao.AuthorDao;
import org.example.model.Author;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorDaoImpl implements AuthorDao {

    private final Connection connection = JdbcConfig.getConnection();

    @Override
    public boolean createAuthorTable() {
        int execute = 0;
        String query = "create table if not exists authors(" +
                "id serial primary key," +
                "first_name varchar," +
                "last_name varchar," +
                "email varchar," +
                "country varchar," +
                "date_of_birth date);";

        try (Statement statement = connection.createStatement()){
            execute = statement.executeUpdate(query);
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return execute == 0;
    }

    @Override
    public String saveAuthor(Author newAuthor) {
        return null;
    }

    @Override
    public String updateAuthorById(Long id, Author author) {
        String query = "update authors " +
                "set first_name = ?," +
                "last_name = ?," +
                "email = ?," +
                "country = ?," +
                "date_of_birth = ? " +
                "where id = ?";
        int execute = 0;

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, author.getFirstName());
            preparedStatement.setString(2, author.getLastName());
            preparedStatement.setString(3, author.getEmail());
            preparedStatement.setString(4, author.getCountry());
            preparedStatement.setDate(5, Date.valueOf(author.getDateOfBirth()));
            preparedStatement.setLong(6, id);
            execute = preparedStatement.executeUpdate();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return execute != 0 ? "Updated" : "Failed";
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

        List<Author> authors = new ArrayList<>();

        String query = "select * from authors;";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                Author author = new Author();
                author.setId(resultSet.getLong("id"));
                author.setFirstName(resultSet.getString("first_name"));
                author.setLastName(resultSet.getString("last_name"));
                author.setEmail(resultSet.getString("email"));
                author.setCountry(resultSet.getString("country"));
                author.setDateOfBirth(resultSet.getDate("date_of_birth").toLocalDate());
                authors.add(author);
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return authors;
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

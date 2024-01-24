package org.example.dao.impl;

import org.example.config.JdbcConfig;
import org.example.dao.BookDao;
import org.example.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {

    private final Connection connection = JdbcConfig.getConnection();

    @Override
    public String createBookTable() {
        String query = "create table if not exists books(" +
                "id serial primary key," +
                "name varchar," +
                "country varchar," +
                "published_year int," +
                "price int," +
                "author_id int references authors(id));";

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
            return "Book table is created!";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "Failed";
    }

    @Override
    public boolean saveBook(Long authorId, Book book) {
        return false;
    }

    @Override
    public List<Book> findAllAuthorBookById(Long authorId) {

        List<Book> books = new ArrayList<>();
        String query = "select * from books b inner join authors a on b.author_id = a.id where b.author_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, authorId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                books.add(new Book(
                                resultSet.getLong("id"),
                                resultSet.getString("name"),
                                resultSet.getString("country"),
                                resultSet.getInt("published_year"),
                                resultSet.getInt("price"),
                                resultSet.getLong("author_id")
                        )
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return books;
    }
}

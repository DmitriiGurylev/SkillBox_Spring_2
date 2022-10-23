package com.example.MyBookShopApp.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BookService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> getBooksData() {
        List<Book> books = jdbcTemplate.query(
                "SELECT books.id, " +
                        "books.title, " +
                        "books.PRICE_OLD, " +
                        "books.price, " +
                        "authors.first_name AS authorFirstName, " +
                        "authors.first_name AS authorLastName " +
                        "FROM books " +
                        "INNER JOIN authors " +
                        "ON books.author_id = authors.id",
                (ResultSet rs, int rowNum) -> {
                    Book book = new Book();
                    book.setId(rs.getInt("id"));
                    book.setAuthor(rs.getString("authorFirstName")+ ' ' +rs.getString("authorLastName"));
                    book.setTitle(rs.getString("title"));
                    book.setPriceOld(rs.getInt("PRICE_OLD"));
                    book.setPrice(rs.getInt("price"));
                    return book;
                });
        return new ArrayList<>(books);
    }

    public List<Author> getAuthorsData() {
        List<Author> authors = jdbcTemplate.query(
                "SELECT * FROM authors",
                (ResultSet rs, int rowNum) -> {
                    Author author = new Author();
                    author.setId(rs.getInt("id"));
                    author.setName(rs.getString("first_name")+ ' ' +rs.getString("last_name"));
                    return author;
                });
        return new ArrayList<>(authors);
    }

}

package com.k8s.bookstore.adminapp.service;

import com.k8s.bookstore.adminapp.data.Author;
import com.k8s.bookstore.adminapp.data.Book;
import com.k8s.bookstore.adminapp.data.Genre;

public interface BookService {

    Book createBook(Book book);

    Book updateBook(Book book);

    void deleteBookById(String id);

    Author createAuthor(Author author);

    Author updateAuthor(Author author);

    void deleteAuthorById(String id);

    Genre createGenre(Genre genre);

    Genre updateGenre(Genre genre);

    void deleteGenreById(String id);

    Book getBookById(String id);

    Author getAuthorById(String id);

    Genre getGenreById(String id);
}

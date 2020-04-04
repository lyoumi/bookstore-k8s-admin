package com.k8s.bookstore.adminapp.service.impl;

import com.k8s.bookstore.adminapp.data.Author;
import com.k8s.bookstore.adminapp.data.Book;
import com.k8s.bookstore.adminapp.data.Genre;
import com.k8s.bookstore.adminapp.repository.AuthorRepository;
import com.k8s.bookstore.adminapp.repository.BookRepository;
import com.k8s.bookstore.adminapp.repository.GenreRepository;
import com.k8s.bookstore.adminapp.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBookById(String id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author updateAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void deleteAuthorById(String id) {
        authorRepository.deleteById(id);
    }

    @Override
    public Genre createGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public Genre updateGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public void deleteGenreById(String id) {
        genreRepository.deleteById(id);
    }

    @Override
    public Book getBookById(String id) {
        return bookRepository.getOne(id);
    }

    @Override
    public Author getAuthorById(String id) {
        return authorRepository.getOne(id);
    }

    @Override
    public Genre getGenreById(String id) {
        return genreRepository.getOne(id);
    }
}

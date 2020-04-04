package com.k8s.bookstore.adminapp.resource;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

import com.k8s.bookstore.adminapp.data.Author;
import com.k8s.bookstore.adminapp.data.Book;
import com.k8s.bookstore.adminapp.data.Genre;
import com.k8s.bookstore.adminapp.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    @ResponseStatus(OK)
    @PostMapping("/book")
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @ResponseStatus(OK)
    @PutMapping("/book")
    public Book updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping("/book/{id}")
    public void deleteBookById(@PathVariable("id") String id) {
        bookService.deleteBookById(id);
    }

    @ResponseStatus(OK)
    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable("id") String id) {
        return bookService.getBookById(id);
    }

    @ResponseStatus(OK)
    @PostMapping("/author")
    public Author createAuthor(@RequestBody Author author) {
        return bookService.createAuthor(author);
    }

    @ResponseStatus(OK)
    @PutMapping("/author")
    public Author updateAuthor(@RequestBody Author author) {
        return bookService.updateAuthor(author);
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping("/author/{id}")
    public void deleteAuthorById(@PathVariable("id") String id) {
        bookService.deleteAuthorById(id);
    }

    @ResponseStatus(OK)
    @GetMapping("/author/{id}")
    public Author getAuthorById(@PathVariable("id") String id) {
        return bookService.getAuthorById(id);
    }

    @ResponseStatus(OK)
    @PostMapping("/genre")
    public Genre createGenre(@RequestBody Genre genre) {
        return bookService.createGenre(genre);
    }

    @ResponseStatus(OK)
    @PutMapping("/genre")
    public Genre updateGenre(@RequestBody Genre genre) {
        return bookService.updateGenre(genre);
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping("/genre/{id}")
    public void deleteGenreById(@PathVariable("id") String id) {
        bookService.deleteGenreById(id);
    }

    @ResponseStatus(OK)
    @GetMapping("/genre/{id}")
    public Genre getGenreById(@PathVariable("id") String id) {
        return bookService.getGenreById(id);
    }
}

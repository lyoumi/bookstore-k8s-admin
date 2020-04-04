package com.k8s.bookstore.adminapp.data;

import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "price", nullable = false)
    private Double price;

    @ManyToMany(cascade = CascadeType.MERGE)
    @LazyCollection(LazyCollectionOption.TRUE)
    @JoinTable(name = "book_author",
        joinColumns = {
            @JoinColumn(name = "book_id")},
        inverseJoinColumns = {
            @JoinColumn(name = "author_id")
        })
    private List<Author> authors;

    @ManyToMany(cascade = CascadeType.MERGE)
    @LazyCollection(LazyCollectionOption.TRUE)
    @JoinTable(name = "book_genre",
        joinColumns = {
            @JoinColumn(name = "book_id")},
        inverseJoinColumns = {
            @JoinColumn(name = "genre_id")
        })
    private List<Genre> genres;

}

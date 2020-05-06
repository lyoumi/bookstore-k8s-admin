CREATE TABLE book_genre (
 book_id varchar(255) NOT NULL,
 genre_id varchar(255) NOT NULL,
 PRIMARY KEY (book_id, genre_id)
);

CREATE TABLE book_author (
 book_id VARCHAR(255) NOT NULL,
 author_id VARCHAR(255) NOT NULL,
 PRIMARY KEY (book_id, author_id)
);

CREATE TABLE book (
 id VARCHAR(255) NOT NULL,
 title VARCHAR(255) NOT NULL,
 price DOUBLE NOT NULL,
 PRIMARY KEY (id)
);

CREATE TABLE author (
 id VARCHAR(255) NOT NULL,
 name VARCHAR(255) NOT NULL,
 surname VARCHAR(255) NOT NULL,
 birth_date DATE,
 PRIMARY KEY (id)
);

CREATE TABLE genre (
 id VARCHAR(255) NOT NULL,
 name VARCHAR(255) NOT NULL,
 PRIMARY KEY (id)
);

CREATE TABLE candidate (
 id VARCHAR(255) NOT NULL,
 name VARCHAR(255) NOT NULL,
 email VARCHAR(255) NOT NULL,
 age INT NOT NULL,
 address_id VARCHAR(255) NOT NULL,
 PRIMARY KEY (id)
);

CREATE TABLE address (
 id VARCHAR(255) NOT NULL,
 country VARCHAR(255) NOT NULL,
 city VARCHAR(255) NOT NULL,
 PRIMARY KEY (id)
);

CREATE TABLE skill (
 id VARCHAR(255) NOT NULL,
 name VARCHAR(255) NOT NULL,
 level VARCHAR(255) NOT NULL,
 candidate_id VARCHAR(255) NOT NULL,
 PRIMARY KEY (id)
);

ALTER TABLE book_genre ADD CONSTRAINT book_genre_fk FOREIGN KEY (book_id) REFERENCES book(id);
ALTER TABLE book_genre ADD CONSTRAINT genre_book_fk FOREIGN KEY (genre_id) REFERENCES genre(id);

ALTER TABLE book_author ADD CONSTRAINT book_author_fk FOREIGN KEY (book_id) REFERENCES book(id);
ALTER TABLE book_author ADD CONSTRAINT author_book_fk FOREIGN KEY (author_id) REFERENCES author(id);

ALTER TABLE skill ADD CONSTRAINT skill_candidate_fk FOREIGN KEY (candidate_id) REFERENCES candidate(id);
ALTER TABLE skill DROP FOREIGN KEY skill_candidate_fk;
ALTER TABLE candidate ADD CONSTRAINT candidate_address_fk FOREIGN KEY (address_id) REFERENCES address(id);

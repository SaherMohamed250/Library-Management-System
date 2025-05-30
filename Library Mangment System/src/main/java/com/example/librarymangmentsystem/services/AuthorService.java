package com.example.librarymangmentsystem.services;

import com.example.librarymangmentsystem.models.Author;
import com.example.librarymangmentsystem.models.Book;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    Author createAuthor(Author author);
    Optional<Author> getAuthorById(Long id);
    List<Author> getAllAuthors();
    Author updateAuthor(Long id, Author author);
    String deletAuthor(Long id);
}

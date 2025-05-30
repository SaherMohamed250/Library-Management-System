package com.example.librarymangmentsystem.services;

import com.example.librarymangmentsystem.models.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getAllBooks();

    Optional<Book> getBookByIsbn(Long isbn);

    Book createBook(Book book);

    Book updateBook(Long isbn, Book updatedBook);

    String deleteBook(Long isbn);

}

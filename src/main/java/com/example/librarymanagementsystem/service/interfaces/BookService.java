package com.example.librarymanagementsystem.service.interfaces;

import com.example.librarymanagementsystem.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getAllBooks();

    Optional<Book> getBookById(Long id);

    Book createBook(Book book);

    Book updateBook(Long id, Book updatedBook);

    String deleteBook(Long id);
}

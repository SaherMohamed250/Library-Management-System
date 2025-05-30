package com.example.librarymangmentsystem.controller;

import com.example.librarymangmentsystem.models.Book;
import com.example.librarymangmentsystem.services.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/librarian/book")
public class BookController {
    @Autowired
    private BookServiceImpl bookService;

    @GetMapping
    public ResponseEntity<?> getAllBooks() {
        List<Book> bookList = bookService.getAllBooks();
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }
    @GetMapping("/{isbn}")
    public ResponseEntity<?> getBookById(@PathVariable Long isbn) {
        Optional<Book> book = bookService.getBookByIsbn(isbn);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> createBook(@RequestBody Book book){
        Book book1 =bookService.createBook(book);
        return new ResponseEntity<>(book1, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> editBook(@PathVariable long id,
                                          @RequestBody Book book) {
        Book book1 = bookService.updateBook(id, book);
        return new ResponseEntity<>(book1, HttpStatus.OK);
    }
    @DeleteMapping("/{isbn}")
    public ResponseEntity<?> deleteBook(@PathVariable long isbn) {
        bookService.deleteBook(isbn);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.NO_CONTENT);
    }
}

package com.example.librarymangmentsystem.services;

import com.example.librarymangmentsystem.models.Author;
import com.example.librarymangmentsystem.models.Book;
import com.example.librarymangmentsystem.models.Category;
import com.example.librarymangmentsystem.models.Publisher;
import com.example.librarymangmentsystem.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private PublisherServiceImpl publisherService;
    @Autowired
    private AuthorServiceImpl authorService;
    @Autowired
    private CategoryServiceImpl categoryService;
    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookByIsbn(Long isbn) {
        return bookRepository.findById(isbn);
    }

    @Override
    public Book createBook(Book book) {
        Book book1 =new Book();
        book1.setISBN(book.getISBN());
        book1.setLanguage(book.getLanguage());
        book1.setEdition(book.getEdition());
        book1.setSummary(book.getSummary());
        book1.setCoverImage(book.getCoverImage());
        book1.setPublicationYear(book.getPublicationYear());

        if (book.getPublisher() != null && book.getPublisher().getPublisherId() != null) {
            Publisher publisher = publisherService.getPublisherById(book.getPublisher().getPublisherId())
                    .orElseThrow(() -> new NoSuchElementException("Publisher not found"));
            book1.setPublisher(publisher);
        }

        if (book.getCategory() != null && book.getCategory().getCategoryId() != null) {
            Category category = categoryService.getCategoryById(book.getCategory().getCategoryId())
                    .orElseThrow(() -> new NoSuchElementException("Category not found"));
            book1.setCategory(category);
        }

        if (book.getAuthors() != null && !book.getAuthors().isEmpty()) {
            Set<Author> authorSet = new HashSet<>();
            for (Author author : book.getAuthors()) {
                if (author.getAuthorId() != null) {
                    Author existingAuthor = authorService.getAuthorById(author.getAuthorId())
                            .orElseThrow(() -> new NoSuchElementException("Author not found"));
                    authorSet.add(existingAuthor);
                }
            }
            book1.setAuthors(authorSet);
        }
        bookRepository.save(book1);
        return book1;
    }

    @Override
    public Book updateBook(Long isbn, Book updatedBook) {
        Book existingBook = bookRepository.findById(isbn)
                .orElseThrow(() -> new NoSuchElementException("Book not found"));

        existingBook.setLanguage(updatedBook.getLanguage());
        existingBook.setEdition(updatedBook.getEdition());
        existingBook.setSummary(updatedBook.getSummary());
        existingBook.setCoverImage(updatedBook.getCoverImage());
        existingBook.setPublicationYear(updatedBook.getPublicationYear());

        if (updatedBook.getPublisher() != null && updatedBook.getPublisher().getPublisherId() != null) {
            Publisher publisher = publisherService.getPublisherById(updatedBook.getPublisher().getPublisherId())
                    .orElseThrow(() -> new NoSuchElementException("Publisher not found"));
            existingBook.setPublisher(publisher);
        }

        if (updatedBook.getCategory() != null && updatedBook.getCategory().getCategoryId() != null) {
            Category category = categoryService.getCategoryById(updatedBook.getCategory().getCategoryId())
                    .orElseThrow(() -> new NoSuchElementException("Category not found"));
            existingBook.setCategory(category);
        }

        if (updatedBook.getAuthors() != null && !updatedBook.getAuthors().isEmpty()) {
            Set<Author> authorSet = new HashSet<>();
            for (Author author : updatedBook.getAuthors()) {
                if (author.getAuthorId() != null) {
                    Author existingAuthor = authorService.getAuthorById(author.getAuthorId())
                            .orElseThrow(() -> new NoSuchElementException("Author not found"));
                    authorSet.add(existingAuthor);
                }
            }
            existingBook.setAuthors(authorSet);
        }

        return bookRepository.save(existingBook);
    }

    @Override
    public String deleteBook(Long isbn) {
        bookRepository.deleteById(isbn);
        return "DELETED";
    }
}

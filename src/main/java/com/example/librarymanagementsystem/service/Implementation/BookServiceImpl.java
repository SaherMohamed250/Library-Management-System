package com.example.librarymanagementsystem.service.Implementation;

import com.example.librarymanagementsystem.model.Auther;
import com.example.librarymanagementsystem.model.Book;
import com.example.librarymanagementsystem.model.Category;
import com.example.librarymanagementsystem.model.Publisher;
import com.example.librarymanagementsystem.repository.AutherRepository;
import com.example.librarymanagementsystem.repository.BookRepository;
import com.example.librarymanagementsystem.repository.CategoryRepository;
import com.example.librarymanagementsystem.repository.PublisherRepository;
import com.example.librarymanagementsystem.service.interfaces.BookService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private PublisherRepository publisherRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private AutherRepository autherRepository;
    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book createBook(Book book) {

        Book newBook = new Book();
        newBook.setIsbn(book.getIsbn());
        newBook.setLanguage(book.getLanguage());
        newBook.setCoverImage(book.getCoverImage());
        newBook.setSummary(book.getSummary());
        newBook.setEdition(book.getEdition());
        newBook.setPublicationYear(book.getPublicationYear());

        if (book.getPublisher() != null && book.getPublisher().getPublisherId() != null) {
            Publisher publisher = publisherRepository.findById(book.getPublisher().getPublisherId())
                    .orElseThrow(() -> new EntityNotFoundException("Publisher not found with ID: " + book.getPublisher().getPublisherId()));
            newBook.setPublisher(publisher);
        }

        if (book.getAuthors() != null && !book.getAuthors().isEmpty()) {
            Set<Long> authorIds = book.getAuthors().stream()
                    .map(Auther::getAutherId)
                    .collect(Collectors.toSet());

            List<Auther> foundAuthors = autherRepository.findAllById(authorIds);
            Set<Long> foundAuthorIds = foundAuthors.stream()
                    .map(Auther::getAutherId)
                    .collect(Collectors.toSet());

            Set<Long> missingAuthors = new HashSet<>(authorIds);
            missingAuthors.removeAll(foundAuthorIds);
            if (!missingAuthors.isEmpty()) {
                throw new EntityNotFoundException("Authors not found with IDs: " + missingAuthors);
            }

            newBook.setAuthors(new HashSet<>(foundAuthors));
        }

        if (book.getCategories() != null && !book.getCategories().isEmpty()) {
            Set<Long> categoryIds = book.getCategories().stream()
                    .map(Category::getCategoryId)
                    .collect(Collectors.toSet());

            List<Category> foundCategories = categoryRepository.findAllById(categoryIds);
            Set<Long> foundCategoryIds = foundCategories.stream()
                    .map(Category::getCategoryId)
                    .collect(Collectors.toSet());

            Set<Long> missingCategories = new HashSet<>(categoryIds);
            missingCategories.removeAll(foundCategoryIds);
            if (!missingCategories.isEmpty()) {
                throw new EntityNotFoundException("Categories not found with IDs: " + missingCategories);
            }

            newBook.setCategories(new HashSet<>(foundCategories));
        }

        return bookRepository.save(newBook);
    }


    
    @Override
    public Book updateBook(Long id, Book book) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book not found"));

        existingBook.setIsbn(book.getIsbn());
        existingBook.setLanguage(book.getLanguage());
        existingBook.setCoverImage(book.getCoverImage());
        existingBook.setSummary(book.getSummary());
        existingBook.setEdition(book.getEdition());
        existingBook.setPublicationYear(book.getPublicationYear());

        if (book.getPublisher() != null) {
            existingBook.setPublisher(publisherRepository.findById(book.getPublisher().getPublisherId())
                    .orElseThrow(() -> new EntityNotFoundException("Publisher not found")));
        }

        existingBook.getAuthors().clear();
        if (book.getAuthors() != null) {
            book.getAuthors().forEach(author -> {
                existingBook.getAuthors().add(autherRepository.findById(author.getAutherId())
                        .orElseThrow(() -> new EntityNotFoundException("Author not found")));
            });
        }

        existingBook.getCategories().clear();
        if (book.getCategories() != null) {
            book.getCategories().forEach(category -> {
                existingBook.getCategories().add(categoryRepository.findById(category.getCategoryId())
                        .orElseThrow(() -> new EntityNotFoundException("Category not found")));
            });
        }

        return bookRepository.save(existingBook);
    }

    @Override
    public String deleteBook(Long id) {
        bookRepository.deleteById(id);
        return "deleteBook";
    }
}

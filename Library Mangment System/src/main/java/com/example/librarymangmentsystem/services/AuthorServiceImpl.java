package com.example.librarymangmentsystem.services;

import com.example.librarymangmentsystem.models.Author;
import com.example.librarymangmentsystem.models.Book;
import com.example.librarymangmentsystem.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService{
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Author createAuthor(Author author) {
        Author author1 =new Author();
        author1.setName(author.getName());
        authorRepository.save(author1);
        return author1;
    }

    @Override
    public Optional<Author> getAuthorById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author updateAuthor(Long id, Author author) {
        Author author1 =authorRepository.findById(id).get();
        author1.setName(author.getName());
        authorRepository.save(author1);
        return author1;
    }

    @Override
    public String deletAuthor(Long id) {
        authorRepository.deleteById(id);
        return "DELETED";
    }
}

package com.example.librarymanagementsystem.service.interfaces;

import com.example.librarymanagementsystem.model.Auther;

import java.util.List;
import java.util.Optional;

public interface AutherService {
    Auther createAuthor(Auther author);
    Optional<Auther> getAuthorById(Long id);
    List<Auther> getAllAuthors();
    Auther updateAuthor(Long id, Auther author);
    String deletAuthor(Long id);
}

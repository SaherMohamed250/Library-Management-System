package com.example.librarymanagementsystem.service.interfaces;

import com.example.librarymanagementsystem.model.Publisher;

import java.util.List;
import java.util.Optional;

public interface PublisherService {
    Publisher createPublisher(Publisher publisher);
    Optional<Publisher> getPublisherById(Long id);
    List<Publisher> getAllPublishers();
    Publisher updatePublisher(Long id, Publisher publisher);
    String deletePublisher(Long id);
}

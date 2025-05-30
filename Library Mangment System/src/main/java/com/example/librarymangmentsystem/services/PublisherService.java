package com.example.librarymangmentsystem.services;

import com.example.librarymangmentsystem.models.Publisher;

import java.util.List;
import java.util.Optional;

public interface PublisherService {
    Publisher createPublisher(Publisher publisher);
    Optional<Publisher> getPublisherById(Long id);
    List<Publisher> getAllPublishers();
    Publisher updatePublisher(Long id, Publisher publisher);
    String deletePublisher(Long id);
}

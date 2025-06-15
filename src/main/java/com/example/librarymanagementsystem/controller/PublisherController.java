package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.model.Publisher;
import com.example.librarymanagementsystem.service.interfaces.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/publisher")
public class PublisherController {
    @Autowired
    private PublisherService publisherService;

    @GetMapping
    public ResponseEntity<?> getAllPublisher() {
        List<Publisher> publisherList = publisherService.getAllPublishers();
        return new ResponseEntity<>(publisherList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createPublisher(@RequestBody Publisher publisher) {
        Publisher publisher1 = publisherService.createPublisher(publisher);
        return new ResponseEntity<>(publisher1, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editPublisher(@PathVariable long id,
                                        @RequestBody Publisher publisher) {
        Publisher publisher1 = publisherService.updatePublisher(id, publisher);
        return new ResponseEntity<>(publisher1, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePublisher(@PathVariable long id) {
        publisherService.deletePublisher(id);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.NO_CONTENT);
    }
}

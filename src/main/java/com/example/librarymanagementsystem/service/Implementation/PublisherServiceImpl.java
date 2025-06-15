package com.example.librarymanagementsystem.service.Implementation;

import com.example.librarymanagementsystem.model.Publisher;
import com.example.librarymanagementsystem.repository.PublisherRepository;
import com.example.librarymanagementsystem.service.interfaces.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherServiceImpl implements PublisherService {
    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public Publisher createPublisher(Publisher publisher) {
        Publisher publisher1 =new Publisher();
        publisher1.setName(publisher.getName());
        publisher1.setPhone(publisher.getPhone());
        publisher1.setAddress(publisher.getAddress());
        publisherRepository.save(publisher1);
        return publisher1;
    }

    @Override
    public Optional<Publisher> getPublisherById(Long id) {
        return publisherRepository.findById(id);
    }

    @Override
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher updatePublisher(Long id, Publisher publisher) {
        Publisher publisher1 =publisherRepository.findById(id).get();
        publisher1.setName(publisher.getName());
        publisher1.setPhone(publisher.getPhone());
        publisher1.setAddress(publisher.getAddress());
        publisherRepository.save(publisher1);
        return publisher1;
    }

    @Override
    public String deletePublisher(Long id) {
        publisherRepository.deleteById(id);
        return "deleted";
    }
}

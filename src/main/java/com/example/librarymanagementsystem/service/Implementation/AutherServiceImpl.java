package com.example.librarymanagementsystem.service.Implementation;

import com.example.librarymanagementsystem.model.Auther;
import com.example.librarymanagementsystem.repository.AutherRepository;
import com.example.librarymanagementsystem.service.interfaces.AutherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutherServiceImpl implements AutherService {

    @Autowired
    private AutherRepository autherRepository;

    @Override
    public Auther createAuthor(Auther auther) {
        Auther auther1 = new Auther();
        auther1.setName(auther.getName());
        autherRepository.save(auther1);
        return auther1;
    }

    @Override
    public Optional<Auther> getAuthorById(Long id) {
        return autherRepository.findById(id);
    }

    @Override
    public List<Auther> getAllAuthors() {
        return autherRepository.findAll();
    }

    @Override
    public Auther updateAuthor(Long id, Auther auther) {
        Auther auther1 = autherRepository.findById(id).get();
        auther1.setName(auther.getName());
        autherRepository.save(auther1);
        return auther1;
    }

    @Override
    public String deletAuthor(Long id) {
        autherRepository.deleteById(id);
        return "Delete Author";
    }
}

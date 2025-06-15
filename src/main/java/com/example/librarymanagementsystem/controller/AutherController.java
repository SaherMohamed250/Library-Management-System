package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.model.Auther;
import com.example.librarymanagementsystem.service.interfaces.AutherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/author")
public class AutherController {
    @Autowired
    private AutherService autherService;

    @GetMapping
    public ResponseEntity<?> getAllAuthors() {
        List<Auther> autherList = autherService.getAllAuthors();
        return new ResponseEntity<>(autherList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createAuther(@RequestBody Auther auther) {
        Auther auther1 = autherService.createAuthor(auther);
        return new ResponseEntity<>(auther1, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editAuther(@PathVariable long id,
                                      @RequestBody Auther auther) {
        Auther auther1 = autherService.updateAuthor(id, auther);
        return new ResponseEntity<>(auther1, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAuther(@PathVariable long id) {
        autherService.deletAuthor(id);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.NO_CONTENT);
    }

}

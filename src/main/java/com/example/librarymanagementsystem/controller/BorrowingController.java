package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.model.Borrowing;
import com.example.librarymanagementsystem.service.interfaces.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/librarian/borrowing")
public class BorrowingController {
    @Autowired
    private BorrowingService borrowingService;

    @PostMapping("/borrow")
    public ResponseEntity<Borrowing> borrowBooks(@RequestBody BorrowRequest request) {
        Borrowing borrowing = borrowingService.borrowBooks(request.getMemberId(), request.getBookIds());
        return ResponseEntity.ok(borrowing);
    }


    @PostMapping("/return/{borrowingId}")
    public ResponseEntity<Borrowing> returnBooks(@PathVariable Long borrowingId) {
        Borrowing borrowing = borrowingService.returnBooks(borrowingId);
        return ResponseEntity.ok(borrowing);
    }
}

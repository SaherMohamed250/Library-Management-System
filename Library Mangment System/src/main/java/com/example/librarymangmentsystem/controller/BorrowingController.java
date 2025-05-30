package com.example.librarymangmentsystem.controller;

import com.example.librarymangmentsystem.models.BorrowingTransactions;
import com.example.librarymangmentsystem.services.BorrowindServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff/Borrowing")
public class BorrowingController {
    @Autowired
    private BorrowindServiceImp borrowindService;

    @PostMapping("/borrow")
    public ResponseEntity<?> borrowBook(@RequestParam Long memberId, @RequestParam Long bookId) {
        try {
            BorrowingTransactions transaction = borrowindService.borrowBook(memberId, bookId);
            return new ResponseEntity<>(transaction, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Borrow failed: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/return/{transactionId}")
    public ResponseEntity<?> returnBook(@PathVariable Long transactionId) {
        try {
            BorrowingTransactions transaction = borrowindService.returnBook(transactionId);
            return new ResponseEntity<>(transaction, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Return failed: " + e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/history/{memberId}")
    public ResponseEntity<?> getBorrowHistory(@PathVariable Long memberId) {
        try {
            List<BorrowingTransactions> history = borrowindService.getBorrowHistoryForMember(memberId);
            return new ResponseEntity<>(history, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("No history found: " + e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}

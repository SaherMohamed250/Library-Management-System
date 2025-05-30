package com.example.librarymangmentsystem.services;

import com.example.librarymangmentsystem.models.BorrowingTransactions;

import java.util.List;

public interface BorrowingService {
    BorrowingTransactions borrowBook(Long memberId, Long bookId);
    BorrowingTransactions returnBook(Long transactionId);
    List<BorrowingTransactions> getBorrowHistoryForMember(Long memberId);
}

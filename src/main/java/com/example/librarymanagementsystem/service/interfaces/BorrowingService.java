package com.example.librarymanagementsystem.service.interfaces;

import com.example.librarymanagementsystem.model.Borrowing;

import java.util.Set;

public interface BorrowingService {
    Borrowing borrowBooks(Long memberId, Set<Long> bookIds);
    Borrowing returnBooks(Long borrowingId);
}

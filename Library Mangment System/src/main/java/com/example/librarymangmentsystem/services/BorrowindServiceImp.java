package com.example.librarymangmentsystem.services;

import com.example.librarymangmentsystem.models.Book;
import com.example.librarymangmentsystem.models.BorrowingTransactions;
import com.example.librarymangmentsystem.models.Member;
import com.example.librarymangmentsystem.repository.BookRepository;
import com.example.librarymangmentsystem.repository.BorrowingRepository;
import com.example.librarymangmentsystem.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;


@Service
public class BorrowindServiceImp implements BorrowingService{
    @Autowired
    private BorrowingRepository transactionRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private BookRepository bookRepository;

    @Override
    public BorrowingTransactions borrowBook(Long memberId, Long bookId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new NoSuchElementException("Member not found"));
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new NoSuchElementException("Book not found"));

        BorrowingTransactions transaction = new BorrowingTransactions();
        transaction.setMember(member);
        transaction.setBook(book);
        transaction.setBorrowDate(LocalDate.now());
        transaction.setReturned(false);

        return transactionRepository.save(transaction);
    }

    @Override
    public BorrowingTransactions returnBook(Long transactionId) {
        BorrowingTransactions transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new NoSuchElementException("Transaction not found"));

        transaction.setReturned(true);
        transaction.setReturnDate(LocalDate.now());

        return transactionRepository.save(transaction);
    }

    @Override
    public List<BorrowingTransactions> getBorrowHistoryForMember(Long memberId) {
        return transactionRepository.findByMemberMemberId(memberId);
    }
}

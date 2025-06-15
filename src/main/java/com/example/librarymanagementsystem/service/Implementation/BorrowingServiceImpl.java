package com.example.librarymanagementsystem.service.Implementation;

import com.example.librarymanagementsystem.model.Book;
import com.example.librarymanagementsystem.model.Borrowing;
import com.example.librarymanagementsystem.model.Member;
import com.example.librarymanagementsystem.repository.BookRepository;
import com.example.librarymanagementsystem.repository.BorrowingRepository;
import com.example.librarymanagementsystem.repository.MemberRepository;
import com.example.librarymanagementsystem.service.interfaces.BorrowingService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BorrowingServiceImpl implements BorrowingService {
    @Autowired
    private BorrowingRepository borrowingRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Borrowing borrowBooks(Long memberId, Set<Long> bookIds) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new EntityNotFoundException("Member not found"));

        List<Book> books = bookRepository.findAllById(bookIds);
        if (books.size() != bookIds.size()) {
            throw new EntityNotFoundException("One or more books not found");
        }

        Borrowing borrowing = new Borrowing();
        borrowing.setMember(member);
        borrowing.setBooks(new HashSet<>(books));
        borrowing.setBorrowDate(LocalDate.now());
        borrowing.setDueDate(LocalDate.now().plusWeeks(2));
        borrowing.setReturned(false);

        return borrowingRepository.save(borrowing);
    }

    @Override
    public Borrowing returnBooks(Long borrowingId) {
        Borrowing borrowing = borrowingRepository.findById(borrowingId)
                .orElseThrow(() -> new EntityNotFoundException("Borrowing record not found"));

        borrowing.setReturnDate(LocalDate.now());
        borrowing.setReturned(true);

        return borrowingRepository.save(borrowing);
    }
}

package com.example.librarymangmentsystem.repository;

import com.example.librarymangmentsystem.models.BorrowingTransactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowingRepository extends JpaRepository<BorrowingTransactions,Long> {
    List<BorrowingTransactions> findByMemberMemberId(Long memberId);
}

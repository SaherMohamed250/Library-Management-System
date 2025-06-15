package com.example.librarymanagementsystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.librarymanagementsystem.model.Member;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Borrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;
    @ManyToMany
    @JoinTable(
            name = "borrrowing_books",
            joinColumns = @JoinColumn(name = "borrowing_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private Set<Book> books;

    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

    private boolean returned;
}

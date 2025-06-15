package com.example.librarymanagementsystem.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowRequest {
    private Long memberId;
    private Set<Long> bookIds;
}

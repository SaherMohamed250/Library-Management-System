package com.example.librarymanagementsystem.repository;

import com.example.librarymanagementsystem.model.Auther;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutherRepository extends JpaRepository<Auther,Long> {
}

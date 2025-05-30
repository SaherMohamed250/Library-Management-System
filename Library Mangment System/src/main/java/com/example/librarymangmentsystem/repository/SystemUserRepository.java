package com.example.librarymangmentsystem.repository;

import com.example.librarymangmentsystem.models.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SystemUserRepository extends JpaRepository<SystemUser,Long> {
    Optional<SystemUser> findByUsername(String username);
}

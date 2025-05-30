package com.example.librarymangmentsystem.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;
    private String Name;
    private String phone;
    @JsonIgnore
    @OneToMany(mappedBy = "member")
    private Set<BorrowingTransactions> transactions = new HashSet<>();

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<BorrowingTransactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<BorrowingTransactions> transactions) {
        this.transactions = transactions;
    }
}

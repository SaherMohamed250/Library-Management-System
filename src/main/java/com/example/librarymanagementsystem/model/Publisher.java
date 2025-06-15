package com.example.librarymanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@Table(name = "publisher")
@AllArgsConstructor
@NoArgsConstructor
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id")
    private Long publisherId;
    private String name;
    private String address;
    private String phone;
    @JsonIgnore
    @OneToMany(mappedBy = "publisher")
    private Set<Book> books= new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Publisher)) return false;
        Publisher that = (Publisher) o;
        return Objects.equals(publisherId, that.publisherId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(publisherId);
    }
}

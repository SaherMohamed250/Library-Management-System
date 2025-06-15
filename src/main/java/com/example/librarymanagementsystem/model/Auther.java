package com.example.librarymanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@Table(name = "authors")
@AllArgsConstructor
@NoArgsConstructor
public class Auther {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auther_id")
    private Long autherId;
    private String name;
    @JsonIgnore
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books=new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Auther)) return false;
        Auther auther = (Auther) o;
        return Objects.equals(autherId, auther.autherId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(autherId);
    }
}

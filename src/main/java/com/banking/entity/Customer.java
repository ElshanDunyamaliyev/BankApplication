package com.banking.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public record Customer(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,
        String firstName,
        String lastName,
        @OneToMany(mappedBy = "customer",fetch = FetchType.LAZY)
        List<Account> accounts
) {
}

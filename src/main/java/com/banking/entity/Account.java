package com.banking.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public record Account(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,
        BigDecimal balance,
        LocalDateTime createdAt,
        @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
        @JoinColumn(name = "customer_id", nullable = false)
        Customer customer,
        @OneToMany(mappedBy = "account")
        Set<Transaction> transactions
        ) {
}

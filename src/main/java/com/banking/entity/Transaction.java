package com.banking.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Transaction(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,
        @Column(name = "transaction_status")
        TransactionType transactionType,
        BigDecimal amount,
        LocalDateTime transactionDate,
        @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
        @JoinColumn(name = "account_id", nullable = false)
        Account account
) {
}

enum TransactionType {
    INITIAL,TRANSFER;
}
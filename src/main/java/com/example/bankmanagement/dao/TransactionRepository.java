package com.example.bankmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.bankmanagement.bean.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	
}


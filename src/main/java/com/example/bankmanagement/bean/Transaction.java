package com.example.bankmanagement.bean;

import jakarta.persistence.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@Entity
@Table(name = "bank")
public class Transaction {
    @Id
    private Long id;
    @Column
    private String custName;
    @Column
    private int amount;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
    
    }

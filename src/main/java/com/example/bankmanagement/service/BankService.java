package com.example.bankmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bankmanagement.bean.Transaction;
import com.example.bankmanagement.dao.TransactionRepository;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BankService {
    @Autowired
    private TransactionRepository transactionRepository;

    private double balance = 0.0;
    
    
    
    
    

    @GetMapping("/credit")
    public String credit(Transaction t) {
        Optional<Transaction> opt = transactionRepository.findById(t.getId());
        
        if (opt.isPresent()) {
            Transaction existingTransaction = opt.get();
            
            System.out.println("Balance Amount: " + existingTransaction.getAmount());
            System.out.println("Passed Amount: " + t.getAmount());
            
            // Calculate new balance
            int newBalance = existingTransaction.getAmount() + t.getAmount()+t.getAmount();
            newBalance=newBalance-t.getAmount();
            existingTransaction.setAmount(newBalance);
            System.out.println("New Balance "+newBalance);
            // Save updated transaction
            transactionRepository.save(existingTransaction);

            return "Amount credited successfully. New Balance: " + newBalance;
        } else {
            return "ID not present";
        }
    }






	
	  public String debit(Transaction t) 
	  { Optional<Transaction> opt=transactionRepository.findById(t.getId());
      if(opt.isPresent())
      {
   	
   		
   		Transaction b1=(Transaction)opt.get();
   		System.out.println("Balance Amount "+b1.getAmount());
   		System.out.println("Passed amount "+t.getAmount());
      	balance=b1.getAmount()-t.getAmount();
   		//t.setAmount(accamount);
   		
   		//System.out.println("Total amount "+accamount);
   		b1.setAmount(t.getAmount()-b1.getAmount());
   		
   		//b1.setAmount(t.getAmount()+b1.getAmount());
   		transactionRepository.save(b1);	
   	System.exit(0);		
   	}
       
       
      else
      {
   	   return "ID not present";
      }
      return "Amount debited successfully.";
	  
	  }
	 
	  
	  
	  
	  
	  

	  public String findBalance(Long id) {
		    Optional<Transaction> opt = transactionRepository.findById(id);
		    if (opt.isPresent()) {
		        Transaction transaction = opt.get();
		        return "The current balance for ID " + id + " is: " + transaction.getAmount();
		    } else {
		        return "Customer ID not found.";
		    }
		}

    public ArrayList<Transaction> getTransactionHistory() {
        return  (ArrayList<Transaction>) transactionRepository.findAll();
    } 
}

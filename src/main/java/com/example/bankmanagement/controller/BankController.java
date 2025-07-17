package com.example.bankmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.bankmanagement.service.BankService;
import com.example.bankmanagement.bean.Transaction;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/bank")
public class BankController {
    @Autowired
    private BankService bankService;

    @GetMapping("/credit")
    public String credit(@ModelAttribute("b")Transaction b) {
    	System.out.println("Under Controller "+b.getAmount());
        return bankService.credit(b);
    }

	
	  @GetMapping("/debit") public String debit(@ModelAttribute("b")Transaction b)
	  { return bankService.debit(b); }
	 

	  @GetMapping("/findBalance")
	  public String findBalance(@RequestParam Long id) {
	      return bankService.findBalance(id);
	  }


    @GetMapping("/allUser")
    public List<Transaction> getTransactionHistory() {
        return bankService.getTransactionHistory();
    }
}

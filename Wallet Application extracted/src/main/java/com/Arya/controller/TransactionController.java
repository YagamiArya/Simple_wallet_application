package com.Arya.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Arya.model.Transaction;
import com.Arya.model.User;
import com.Arya.service.TransactionService;
import com.Arya.service.UserService;

@Controller
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService = new TransactionService();
	@Autowired
	private UserService userService = new UserService();
	
	
	@RequestMapping("transactions")
	public String showTransactions(@RequestParam("userId") String userId, ModelMap modelMap) {
		User user = userService.findUserById(userId);
		List<Transaction> transactions = transactionService.findTransactionUser(user);
		System.out.println(transactions);
		modelMap.addAttribute("transactions",transactions);
		modelMap.addAttribute("user",user);
		return "viewTransactionsPage";
	}
	
	

}

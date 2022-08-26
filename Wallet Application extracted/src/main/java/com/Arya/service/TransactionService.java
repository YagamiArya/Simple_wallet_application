package com.Arya.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Arya.model.Transaction;
import com.Arya.model.User;
import com.Arya.repo.TransactionRepo;

@Service
public class TransactionService {
	
	@Autowired
	private TransactionRepo transactionRepo;
	
	public Transaction addTransaction(Transaction transaction) {
		Transaction savedTransaction = transactionRepo.save(transaction);
		return savedTransaction;
	}
	
	public List<Transaction> findAllTransactions() {
		return transactionRepo.findAll();
	}

	public List<Transaction> findTransactionUser(User user) {
		String userId = user.getUserId();
		List<Transaction> allTransaction = findAllTransactions();
		List<Transaction> userTransactions = new ArrayList<Transaction>();
				
		for (Transaction transaction : allTransaction) {
			if(transaction.getUserId().equals(userId)) {
				userTransactions.add(transaction);
			}
		}
		return userTransactions;
	}

	
	
	
	

}

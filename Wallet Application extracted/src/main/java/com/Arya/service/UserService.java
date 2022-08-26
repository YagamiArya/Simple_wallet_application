package com.Arya.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Arya.model.User;
import com.Arya.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	public User addUser(User user) {
		User savedUser = userRepo.save(user);
		return savedUser;
	}
	
	public User findUser(User user) {
		String userId = user.getUserId();
		Optional<User> foundUser = userRepo.findById(userId);
		return foundUser.get();
	}
	
	public User findUserById(String userId) {
		Optional<User> foundUser = userRepo.findById(userId);
		return foundUser.get();
	}
	
	public User AddMoney(double addAmount, User user) {
		double balance = user.getBalance();
		double updatedBalance = balance + addAmount;
		userRepo.updateBalance(updatedBalance, user.getUserId());
		user.setBalance(updatedBalance);
		return user;
	}
	
	public User withdrawMoney(double addAmount, User user) {
		double balance = user.getBalance();
		double updatedBalance = balance - addAmount;
		userRepo.updateBalance(updatedBalance, user.getUserId());
		user.setBalance(updatedBalance);
		return user;
	}

	public boolean checkInsufficientBalance(double amount, User user) {
		double balance = user.getBalance();
		if(amount > balance)
			return true;
		else
			return false;
	}
	
	
	
	
	

}

package com.Arya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Arya.model.Transaction;
import com.Arya.model.User;
import com.Arya.service.TransactionService;
import com.Arya.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService = new UserService();
	
	@Autowired
	private TransactionService transactionService = new TransactionService();
	
	@RequestMapping("Home")
	public String showHomePage() {
		return "HomePage";
	}

	@RequestMapping("registerPage")
	public String showRegisterPage() {
		return "registerPage";
	}
	
	@RequestMapping("signInPage")
	public String showSignInPage() {
		return "signInPage";
	}
	
	@RequestMapping("dashboard")
	public String showDashboardPage(@RequestParam("userId") String userId,ModelMap modelMap) {
		User user = userService.findUserById(userId);
		modelMap.addAttribute(user);
		return "dashboardPage";
	}
	
	@RequestMapping("addMoney")
	public String showdepositPage(@RequestParam("userId") String userId, ModelMap modelMap) {
		User user = userService.findUserById(userId);
		modelMap.addAttribute("user",user);
		return "addMoney";
	}
	
	@RequestMapping("withdrawPage")
	public String withdrawPage(@RequestParam("userId") String userId, ModelMap modelMap) {
		User user = userService.findUserById(userId);
		modelMap.addAttribute("user",user);
		return "withdrawPage";
	}
	
	
	@RequestMapping("logout")
	public String logout(ModelMap modelmap) {
		String msg = "logout Successfully!";
		modelmap.addAttribute("msg", msg);
		return "HomePage";
	}
	
	@RequestMapping("registerUser")
	public String register(ModelMap modelmap, @ModelAttribute("user") User user) {
		
		System.out.println(user);
		userService.addUser(user);
		String msg = "user created successfully!"
				+ "<a class=\"btn btn-danger\" href=\"Home\">Return to Home</a>";
		modelmap.addAttribute("msg", msg);
		return "registerPage";
	}
	
	@RequestMapping("signIn")
	public String signIn(ModelMap modelmap, @ModelAttribute("user") User user) {
		
		System.out.println(user);
		User foundUser = null;
		try {
			foundUser = userService.findUser(user);
			}catch(Exception e) {
				
			}
		System.out.println(foundUser);
		if(foundUser==null) {
			String msg = "user not found!";
			msg = msg + "<br><a class=\"btn btn-danger\" href=\"Home\">Return to Home</a>";
			modelmap.addAttribute("msg", msg);
			return "signInPage";
		}
		else {
			if(foundUser.getPassword().equals(user.getPassword())) {
				modelmap.addAttribute("user", foundUser);
				return "dashboardPage";
			}
			else {
				String msg = "Incorrect Password!";
				msg = msg + "<a class=\"btn btn-danger\" href=\"Home\">Return to Home</a>";
				modelmap.addAttribute("msg", msg);
				return "signInPage";
			}
		}
		
		
	}
	
	@RequestMapping("addMoneyWallet")
	public String addMoney(ModelMap modelmap, @ModelAttribute("transaction") Transaction transaction,
			@RequestParam("userId") String userId) {
		System.out.println(transaction);
		User user = userService.findUserById(userId);
		double amount = transaction.getTransactionAmount();
		User updatedUser = userService.AddMoney(amount, user);
		transaction.setTransactionType("Debit");
		transactionService.addTransaction(transaction);
		modelmap.addAttribute("user", updatedUser);
		
		String msg = amount+" rupees added to your account <br>";
		modelmap.addAttribute("msg", msg);
		
		System.out.println(user);
		return "messagePage";
	}
	
	@RequestMapping("withdraw")
	public String withdrawMoney(ModelMap modelmap, @ModelAttribute("transaction") Transaction transaction,
			@RequestParam("userId") String userId) {
		System.out.println(transaction);
		User user = userService.findUserById(userId);
		double amount = transaction.getTransactionAmount();
		boolean insufficientBalance = userService.checkInsufficientBalance(amount, user);
		if(insufficientBalance) {
			String msg = amount+" is not available in your account <br> insufficent Balance!";
			modelmap.addAttribute("msg", msg);
			modelmap.addAttribute("user", user);
			
			System.out.println(user);
			return "messagePage";
		}
		User updatedUser = userService.withdrawMoney(amount, user);
		transaction.setTransactionType("Credit");
		transactionService.addTransaction(transaction);
		modelmap.addAttribute("user", updatedUser);
		
		String msg = amount+" rupees Credited from your account <br>";
		modelmap.addAttribute("msg", msg);
		
		System.out.println(user);
		return "messagePage";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

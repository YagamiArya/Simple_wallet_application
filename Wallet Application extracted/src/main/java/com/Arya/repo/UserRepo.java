package com.Arya.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Arya.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, String>{  

	@Transactional
	@Modifying
	@Query("update User u set u.balance = :balance where u.userId = :userId")
	void updateBalance(@Param("balance") double balance, @Param("userId") String UserId);
}

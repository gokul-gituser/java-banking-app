package com.bankproject.bank_app_project.service;

import com.bankproject.bank_app_project.dto.AccountDto;

public interface AccountService {
	AccountDto createAccount(AccountDto accountDto);
	
	AccountDto getAccountById(Long id);
	
	AccountDto deposit(Long id, double amount);
	
	AccountDto withdraw(Long id, double amount);

}

package com.bankproject.bank_app_project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankproject.bank_app_project.dto.AccountDto;
import com.bankproject.bank_app_project.entity.Account;
import com.bankproject.bank_app_project.mapper.AccountMapper;
import com.bankproject.bank_app_project.repository.AccountRepository;
import com.bankproject.bank_app_project.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	
	private AccountRepository accountRepository;
	
	
	@Autowired
	public AccountServiceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}



	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		// TODO Auto-generated method stub
		Account account = AccountMapper.mapToAccount(accountDto);
		Account savedAccount =  accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}



	@Override
	public AccountDto getAccountById(Long id) {
		// TODO Auto-generated method stub
		Account account = accountRepository.findById(id).orElseThrow(() -> new 
				RuntimeException("Account Does not Exist"));
		return AccountMapper.mapToAccountDto(account);
	}



	@Override
	public AccountDto deposit(Long id, double amount) {
		// TODO Auto-generated method stub
		Account account = accountRepository
				.findById(id)
				.orElseThrow(() -> new RuntimeException("Account Does not Exist"));
		double total = account.getBalance() + amount;
		account.setBalance(total);
		
		Account savedAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}



	@Override
	public AccountDto withdraw(Long id, double amount) {
		// TODO Auto-generated method stub
		Account account = accountRepository
				.findById(id)
				.orElseThrow(() -> new RuntimeException("Account Does not Exist"));
		
		if(account.getBalance() < amount) {
			throw new RuntimeException("insufficient Balance");
		}
		
		double total = account.getBalance() - amount;
		account.setBalance(total);
		Account savedAccount=  accountRepository.save(account);
		
		return AccountMapper.mapToAccountDto(savedAccount);
		
	}
	

}

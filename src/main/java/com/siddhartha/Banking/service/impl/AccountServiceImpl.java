package com.siddhartha.Banking.service.impl;

import com.siddhartha.Banking.dto.AccountDto;
import com.siddhartha.Banking.entity.Account;
import com.siddhartha.Banking.mapper.AccountMapper;
import com.siddhartha.Banking.repository.AccountRepository;
import com.siddhartha.Banking.service.AccountService;
import org.apache.catalina.authenticator.SavedRequest;
import org.springframework.stereotype.Service;

@Service
public class  AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;


    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {

        Account account =  accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exixt"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposite(Long id, double amount) {

        Account account =  accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exixt"));
        double total = account.getBalance() + amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }
}
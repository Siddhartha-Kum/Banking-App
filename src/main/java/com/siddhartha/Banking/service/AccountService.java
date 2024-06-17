package com.siddhartha.Banking.service;

import com.siddhartha.Banking.dto.AccountDto;


public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountById(Long Id);

    AccountDto deposite(Long id, double amount);

}

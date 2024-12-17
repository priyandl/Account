package com.banking.bankManagement.Service;


import com.banking.bankManagement.Model.Account;
import com.banking.bankManagement.Repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;



    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    public Account createAccount(Account account) {
        account.setBalance(BigDecimal.ZERO); // Initialize balance to 0
        account.setCreatedAt(LocalDateTime.now());
        account.setUpdatedAt(LocalDateTime.now());
        return accountRepository.save(account);
    }


    public Account getAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found."));
    }


    public List<Account> getAccountsByUserId(Long userId) {
        return accountRepository.findByUserId(userId);
    }


    public void deleteAccount(Long id) {
        Account account = getAccountById(id);
        accountRepository.delete(account);
    }
}
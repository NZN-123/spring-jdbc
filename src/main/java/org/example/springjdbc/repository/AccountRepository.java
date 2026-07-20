package org.example.springjdbc.repository;

import org.example.springjdbc.entity.Account;

import java.util.List;

public interface AccountRepository {
    void save(Account account); // C

    void update(Account account); // U

    List<Account> findAll(); // R (all)

    Account findById(long id); // R (one)

    void deleteById(long id); // D
}
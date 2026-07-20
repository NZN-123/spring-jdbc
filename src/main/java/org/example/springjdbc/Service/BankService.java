package org.example.springjdbc.Service;


import org.example.springjdbc.dto.AccountFormDTO;
import org.example.springjdbc.dto.AccountUpdateDTO;
import org.example.springjdbc.dto.AccountViewDTO;

import java.util.List;

public interface BankService {
    void makeAccount(AccountFormDTO dto);

    //    void changeAccount(AccountFormDTO dto);
    void changeAccount(AccountUpdateDTO dto);

    AccountViewDTO findAccount(long id);

    void deleteAccount(long id);

    AccountViewDTO findAll();

    List<AccountViewDTO> getAccounts();
}
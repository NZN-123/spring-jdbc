package org.example.springjdbc.Service;

import lombok.RequiredArgsConstructor;
import org.example.springjdbc.dto.AccountFormDTO;
import org.example.springjdbc.dto.AccountUpdateDTO;
import org.example.springjdbc.dto.AccountViewDTO;
import org.example.springjdbc.entity.Account;
import org.example.springjdbc.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// 클래스 또는 메서드 단위로 트랜잭션
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true) // 읽기 전용 트랜잭션
public class BankServiceImpl implements BankService {
    private final AccountRepository accountRepository;

    @Transactional // 쓰기 트랜잭션
    @Override
    public void makeAccount(AccountFormDTO dto) {
        System.out.println("BankServiceImpl.makeAccount");
        System.out.println("dto = " + dto);
        Account newAccount = Account.builder().name(dto.name()).build();
        accountRepository.save(newAccount);
//        throw new RuntimeException("DB에 생성한 다음 예외"); // 트랜잭션 롤백 확인용
    }

    @Transactional // 쓰기 트랜잭션
    @Override
    public void changeAccount(AccountUpdateDTO dto) {
        System.out.println("BankServiceImpl.changeAccount");
        System.out.println("dto = " + dto);
        Account account = accountRepository.findById(dto.id());
        account.setName(dto.name());
        accountRepository.update(account);

    }

    @Override
    public AccountViewDTO findAccount(long id) {
        return AccountViewDTO.fromEntity(accountRepository.findById(id));
    }

    @Transactional // 쓰기 트랜잭션
    @Override
    public void deleteAccount(long id) {
        accountRepository.deleteById(id);
    }

    @Override
    public AccountViewDTO findAll() {
        return null;
    }

    @Override
    public List<AccountViewDTO> getAccounts() {
        return accountRepository.findAll()
                .stream().map(
                        AccountViewDTO::fromEntity
                ).toList();
    }
}
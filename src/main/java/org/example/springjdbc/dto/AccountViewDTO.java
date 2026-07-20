package org.example.springjdbc.dto;

import org.example.springjdbc.entity.Account;

public record AccountViewDTO(
        Long id,
        String name,
        String createdAt
) {

    public static AccountViewDTO fromEntity(Account account) {
        return new AccountViewDTO(
                account.getId(),
                account.getName(),
                account.getCreatedAt());
    }

    // EL Parser (class에서 lombok getter로 처리)
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
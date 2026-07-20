package org.example.springjdbc.repository;

import lombok.RequiredArgsConstructor;
import org.example.springjdbc.entity.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor

public class SQLAccountRepository implements AccountRepository {
    private final JdbcTemplate jdbcTemplate;
    private static final RowMapper<Account> ROW_MAPPER = (rs, rowNum) -> Account.builder()
            .id(rs.getLong("id"))
            .name(rs.getString("name"))
            .createdAt(rs.getString("created_at"))
            .build();

    @Override
    public void save(Account account) {
        String query = "INSERT INTO accounts (name) VALUES (?)";
        jdbcTemplate.update(query, account.getName());
    }

    @Override
    public void update(Account account) {
        String query = "UPDATE accounts SET name = ? WHERE id = ?";
        jdbcTemplate.update(query, account.getName(), account.getId());
    }

    @Override
    public List<Account> findAll() {
        String query = "SELECT * FROM accounts";
        return jdbcTemplate.query(query, ROW_MAPPER);
    }

    @Override
    public Account findById(long id) {
        String query = "SELECT * FROM accounts WHERE id = ?";
        return jdbcTemplate.queryForObject(query, ROW_MAPPER, id);
    }

    @Override
    public void deleteById(long id) {
        String query = "DELETE FROM accounts WHERE id = ?";
        jdbcTemplate.update(query, id);
    }
}

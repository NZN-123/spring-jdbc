CREATE TABLE accounts (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(50) NOT NULL UNIQUE,
                          createAt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
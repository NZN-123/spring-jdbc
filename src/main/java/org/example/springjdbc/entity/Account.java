package org.example.springjdbc.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class Account {
    private long id;
    private String name;
    private String createdAt;
}

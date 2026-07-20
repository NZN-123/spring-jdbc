package org.example.springjdbc.dto;

public record AccountUpdateDTO(
        long id, // DB에 저장되어 있는 데이터를 수정 가능하게 하기 위해
        String name
) {
}

package com.upc.curso.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
public class AuthorDTO {
    private Long id;
    private String nameAuthor;
    private LocalDate birthDateAuthor;
    private String emailAuthor;

}

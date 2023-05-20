package com.upc.curso.entidades;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity //Agnóstica
@Table(name = "TBL_AUTHOR")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nameAuthor", length = 60, nullable = false)
    private String nameAuthor;
    @JsonFormat(pattern="yyyy-dd-MM")
    private LocalDate birthDateAuthor;
    @Column(name = "emailAuthor",length = 35,nullable = false)
    private String emailAuthor;
    private transient double total;

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Author() {
    }

    public Author(Long id, String nameAuthor, LocalDate birthDateAuthor, String emailAuthor) {
        this.id = id;
        this.nameAuthor = nameAuthor;
        this.birthDateAuthor = birthDateAuthor;
        this.emailAuthor = emailAuthor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long codigo) {
        this.id = codigo;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String descripcion) {
        this.nameAuthor = descripcion;
    }

    public LocalDate getBirthDateAuthor() {
        return birthDateAuthor;
    }

    public void setBirthDateAuthor(LocalDate birthDateAuthor) {
        this.birthDateAuthor = birthDateAuthor;
    }

    public String getEmailAuthor() {
        return emailAuthor;
    }

    public void setEmailAuthor(String emailAuthor) {
        this.emailAuthor = emailAuthor;
    }
}

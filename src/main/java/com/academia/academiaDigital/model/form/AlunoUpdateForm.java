package com.academia.academiaDigital.model.form;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AlunoUpdateForm {

    private String nome;

    private String bairro;

    private LocalDate dataDeNascimento;
}
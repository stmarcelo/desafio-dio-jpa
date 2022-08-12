package com.academia.academiaDigital.model.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MatriculaForm {

    @NotNull(message="Aluno é obrigatório")
    @Positive(message = "Aluno inválido")
    private Long alunoId;

}
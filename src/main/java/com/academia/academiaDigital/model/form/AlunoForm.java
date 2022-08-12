package com.academia.academiaDigital.model.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlunoForm {

    @NotBlank(message="Campo nome é obrigatório.")
    @Size(min=3,max=200,message="'${validatedValue}' precisa estar entre {mim} e {max} caracteres")
    private String nome;

    @NotBlank(message="Campo CPF é obrigatório")
    @CPF(message="CPF inválido")
    private String cpf;

    @NotBlank(message="Campo CPF é obrigatório")
    private String bairro;

    @NotNull(message="Campo CPF é obrigatório")
    @Past(message="Data de nascimento inválida")
    private LocalDate dataDeNascimento;
}
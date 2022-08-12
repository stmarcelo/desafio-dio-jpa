package com.academia.academiaDigital.model.repository;

import com.academia.academiaDigital.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    /**
     *
     * @param data
     * @return
     */
    List<Aluno> findByDataDeNascimento(LocalDate data);

    /**
     *
     * @param bairro
     * @return
     */
    List<Aluno> findByBairro(String bairro);
}

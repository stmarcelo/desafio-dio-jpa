package com.academia.academiaDigital.model.service;

import com.academia.academiaDigital.model.Matricula;
import com.academia.academiaDigital.model.form.MatriculaForm;
import com.academia.academiaDigital.model.repository.AlunoRepository;
import com.academia.academiaDigital.model.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaService implements IMatriculaService{

    @Autowired
    private MatriculaRepository repository;

    @Autowired
    private AlunoRepository aluno;

    @Override
    public Matricula create(MatriculaForm form) {
        Matricula model = new Matricula();
        model.setAluno(aluno.findById(form.getAlunoId()).get());
        return repository.save(model);
    }

    @Override
    public Matricula get(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Matricula> getAll(String bairro) {
        if(bairro == null){
            return repository.findAll();
        }else {
            return repository.findByAlunoBairro(bairro);
        }
    }

    @Override
    public void delete(Long id) {
        Matricula model = repository.findById(id).get();
        repository.delete(model);
    }
}

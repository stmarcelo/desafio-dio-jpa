package com.academia.academiaDigital.model.service;

import com.academia.academiaDigital.model.Aluno;
import com.academia.academiaDigital.model.AvaliacaoFisica;
import com.academia.academiaDigital.model.form.AvaliacaoFisicaForm;
import com.academia.academiaDigital.model.form.AvaliacaoFisicaUpdateForm;
import com.academia.academiaDigital.model.repository.AlunoRepository;
import com.academia.academiaDigital.model.repository.AvaliacaoFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvalicaoFisicaService implements IAvaliacaoFisicaService{

    @Autowired
    private AvaliacaoFisicaRepository repository;

    @Autowired
    private AlunoRepository aluno;

    @Override
    public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
        AvaliacaoFisica model = new AvaliacaoFisica();
        model.setAluno(aluno.findById(form.getAlunoId()).get());
        model.setPeso(form.getPeso());
        model.setAltura(form.getAltura());
        return repository.save(model);
    }

    @Override
    public AvaliacaoFisica get(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<AvaliacaoFisica> getAll() {
        return repository.findAll();
    }

    @Override
    public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
        AvaliacaoFisica model = repository.findById(id).get();
        model.setPeso(formUpdate.getPeso());
        model.setAltura(formUpdate.getAltura());
        return repository.save(model);
    }

    @Override
    public void delete(Long id) {
        AvaliacaoFisica model = repository.findById(id).get();
        repository.delete(model);
    }
}

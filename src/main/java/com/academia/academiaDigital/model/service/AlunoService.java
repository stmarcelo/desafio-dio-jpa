package com.academia.academiaDigital.model.service;

import com.academia.academiaDigital.infra.util.JavaTimeUtils;
import com.academia.academiaDigital.model.Aluno;
import com.academia.academiaDigital.model.AvaliacaoFisica;
import com.academia.academiaDigital.model.form.AlunoForm;
import com.academia.academiaDigital.model.form.AlunoUpdateForm;
import com.academia.academiaDigital.model.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AlunoService implements IAlunoService{

    @Autowired
    private AlunoRepository repository;

    @Override
    public Aluno create(AlunoForm form) {
        Aluno model = new Aluno();
        model.setNome(form.getNome());
        model.setCpf(form.getCpf());
        model.setBairro(form.getBairro());
        model.setDataDeNascimento(form.getDataDeNascimento());
        return repository.save(model);
    }

    @Override
    public Aluno get(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Aluno> getAll(String data) {
        if (data==null){
            return repository.findAll();
        }else{
            LocalDate dataNascimento = LocalDate.parse(data, JavaTimeUtils.LOCAL_DATE_FORMATTER);
            return repository.findByDataDeNascimento(dataNascimento);
        }
    }

    @Override
    public Aluno update(Long id, AlunoUpdateForm formUpdate) {
        Aluno model = repository.findById(id).get();
        if (formUpdate.getNome() != null ) model.setNome(formUpdate.getNome());
        if (formUpdate.getBairro() != null ) model.setBairro(formUpdate.getBairro());
        if (formUpdate.getDataDeNascimento() != null ) model.setDataDeNascimento(formUpdate.getDataDeNascimento());
        return repository.save(model);
    }

    @Override
    public void delete(Long id) {
        Aluno model = repository.findById(id).get();
        repository.delete(model);
    }

    @Override
    public List<AvaliacaoFisica> getAllAvaliacoes(Long id) {
        Aluno aluno = repository.findById(id).get();
        return aluno.getAvaliacoes();
    }

}

package com.academia.academiaDigital.controller;

import com.academia.academiaDigital.model.Aluno;
import com.academia.academiaDigital.model.AvaliacaoFisica;
import com.academia.academiaDigital.model.form.AlunoForm;
import com.academia.academiaDigital.model.form.AlunoUpdateForm;
import com.academia.academiaDigital.model.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService service;

    @GetMapping("/all")
    public List<Aluno> getAll(@RequestParam(value="data", required=false) String data){
        return service.getAll(data);
    }

    @PostMapping("/create")
    public Aluno create(@RequestBody @Valid AlunoForm model){
        return service.create(model);
    }

    @PostMapping("/edit/{id}")
    public Aluno edit(@RequestBody @Valid AlunoUpdateForm model, @PathVariable Long id){
        return service.update(id, model);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @GetMapping("/avaliacoes/{id}")
    public List<AvaliacaoFisica> getAvaliacoes(@PathVariable Long id){
        return service.getAllAvaliacoes(id);
    }

}

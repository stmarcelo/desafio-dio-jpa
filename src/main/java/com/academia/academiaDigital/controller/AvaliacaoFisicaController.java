package com.academia.academiaDigital.controller;

import com.academia.academiaDigital.model.Aluno;
import com.academia.academiaDigital.model.AvaliacaoFisica;
import com.academia.academiaDigital.model.form.AlunoForm;
import com.academia.academiaDigital.model.form.AlunoUpdateForm;
import com.academia.academiaDigital.model.form.AvaliacaoFisicaForm;
import com.academia.academiaDigital.model.form.AvaliacaoFisicaUpdateForm;
import com.academia.academiaDigital.model.service.AvalicaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

    @Autowired
    private AvalicaoFisicaService service;

    @GetMapping("/all")
    public List<AvaliacaoFisica> getAll(){
        return service.getAll();
    }

    @PostMapping("/create")
    public AvaliacaoFisica create(@RequestBody AvaliacaoFisicaForm model){
        return service.create(model);
    }

    @PostMapping("/edit/{id}")
    public AvaliacaoFisica edit(@RequestBody @Valid AvaliacaoFisicaUpdateForm model, @PathVariable Long id){
        return service.update(id, model);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}

package com.academia.academiaDigital.controller;

import com.academia.academiaDigital.model.Matricula;
import com.academia.academiaDigital.model.form.AlunoForm;
import com.academia.academiaDigital.model.form.MatriculaForm;
import com.academia.academiaDigital.model.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/matricula")
public class MatriculaController {

    @Autowired
    private MatriculaService service;

    @PostMapping("/create")
    public Matricula create(@RequestBody MatriculaForm model){
        return service.create(model);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @GetMapping("/all")
    public List<Matricula> getAll(@RequestParam(value="bairro", required = false) String bairro){
        return service.getAll(bairro);
    }

}

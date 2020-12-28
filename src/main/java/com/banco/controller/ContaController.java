package com.banco.controller;

import com.banco.dto.CreateContaDTO;
import com.banco.errors.ContaCreateException;
import com.banco.model.Conta;
import com.banco.services.ContaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/conta")
public class ContaController {
    @Autowired
    private ContaServices contaServices;

    @GetMapping
    public ResponseEntity<List<Conta>> list(){
        List<Conta> contas = contaServices.list();
        return ResponseEntity.ok(contas);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Conta> create(@RequestBody @Valid CreateContaDTO createContaDTO, UriComponentsBuilder uriBuilder) throws ContaCreateException {
        Conta newConta = contaServices.create(createContaDTO);
        URI uri = uriBuilder.path("/{id}").buildAndExpand(newConta.getId()).toUri();
        return ResponseEntity.created(uri).body(newConta);
    }
}

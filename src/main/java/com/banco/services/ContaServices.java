package com.banco.services;

import com.banco.dto.CreateContaDTO;
import com.banco.errors.ContaCreateException;
import com.banco.model.Conta;
import com.banco.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContaServices {
    @Autowired
    ContaRepository contaRepository;

    public List<Conta> list(){
        List<Conta> contas = contaRepository.findAll();
        return contas;
    }

    public Conta create(CreateContaDTO createContaDTO) throws ContaCreateException{
        Optional<Conta> conta = contaRepository.findByCpf(createContaDTO.getCpf());
        if(conta.isPresent()){
            throw new ContaCreateException("Falha ao criar conta: CPF já cadastrado no sistema.");
        }
        conta = contaRepository.findByEmail(createContaDTO.getEmail());
        if(conta.isPresent()){
            throw new ContaCreateException("Falha ao criar conta: Email já cadastrado no sistema.");
        }
        Conta newConta = new Conta(createContaDTO.getNome(), createContaDTO.getEmail(), createContaDTO.getCpf(), createContaDTO.getDataNascimento());
        contaRepository.save(newConta);

        return newConta;
    }
}

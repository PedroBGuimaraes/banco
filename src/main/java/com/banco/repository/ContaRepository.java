package com.banco.repository;

import com.banco.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ContaRepository extends JpaRepository<Conta, Long> {
    Optional<Conta> findByCpf(String cpf);
    Optional<Conta> findByEmail(String email);
}

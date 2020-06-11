package com.example.enel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.enel.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	Pessoa findById(long cpf);
}

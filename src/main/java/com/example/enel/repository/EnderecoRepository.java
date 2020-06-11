package com.example.enel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.enel.entity.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

	Endereco findById(long id);
}

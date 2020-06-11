package com.example.enel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.enel.repository.EnderecoRepository;
import com.example.enel.repository.PessoaRepository;

@Service
public class EnderecoService {

	@Autowired
	PessoaRepository pessoaRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;
}

package com.example.enel.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.enel.dto.PessoaDto;
import com.example.enel.entity.Pessoa;
import com.example.enel.repository.EnderecoRepository;
import com.example.enel.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;

	public PessoaDto cadastrar(PessoaDto pessoaDto, Date date) {
		Pessoa pessoa = Pessoa.builder().cpf(pessoaDto.getCpf()).dataAniversario(date)
				.nome(pessoaDto.getNome()).numeroCelular(pessoaDto.getNumeroCelular())
				.cpfOrigem(pessoaDto.getCpfOrigem()).build();
		pessoaRepository.save(pessoa);
		return pessoaDto;
	}

}

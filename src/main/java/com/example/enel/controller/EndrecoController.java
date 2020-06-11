package com.example.enel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.enel.service.EnderecoService;
import com.example.enel.service.PessoaService;

@RestController
public class EndrecoController {

	@Autowired
	PessoaService pessoaService;
	
	@Autowired
	EnderecoService enderecoService;
}

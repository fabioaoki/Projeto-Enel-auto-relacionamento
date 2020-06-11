package com.example.enel.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.enel.dto.PessoaDto;
import com.example.enel.service.EnderecoService;
import com.example.enel.service.PessoaService;

@RestController
public class PessoaController {

	@Autowired
	PessoaService pessoaService;
	
	@Autowired
	EnderecoService enderecoService;
	
	@RequestMapping(value = "/pessoa/cadastro", method = RequestMethod.POST)
	public ResponseEntity<PessoaDto> cadastro(@RequestBody PessoaDto pessoaDto) throws Exception{
		
		if(Objects.nonNull(pessoaDto)) {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(pessoaDto.getDataAniversario());  
			pessoaService.cadastrar(pessoaDto,date);
			return new ResponseEntity<PessoaDto>(pessoaDto, HttpStatus.CREATED);
		}
		return new ResponseEntity<PessoaDto>(HttpStatus.BAD_REQUEST);
	}
}

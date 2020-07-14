package com.example.enel.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.enel.dto.PessoaDto;
import com.example.enel.service.EnderecoService;
import com.example.enel.service.PessoaService;
import com.google.common.base.Strings;

@RestController
public class PessoaController {

	@Autowired
	PessoaService pessoaService;

	@Autowired
	EnderecoService enderecoService;

	@RequestMapping(value = "/pessoa/cadastro", method = RequestMethod.POST)
	public ResponseEntity<PessoaDto> cadastro(@RequestBody PessoaDto pessoaDto) throws Exception {

		if (Objects.nonNull(pessoaDto)) {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(pessoaDto.getDataAniversario());
			pessoaService.cadastrar(pessoaDto, date);
			return new ResponseEntity<PessoaDto>(pessoaDto, HttpStatus.CREATED);
		}
		return new ResponseEntity<PessoaDto>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/pessoa/deleta/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<PessoaDto> deletaPessoa(@PathVariable(value = "id") long id) {
		try {
			pessoaService.delete(id);
			return new ResponseEntity<PessoaDto>(HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/pessoa/busca/{id}", method = RequestMethod.GET)
	public ResponseEntity<PessoaDto> buscaDadosPessoa(@PathVariable(value = "id") long id) {
		PessoaDto pessoaDto = pessoaService.getById(id);
		if (!Objects.equals(pessoaDto.getCpf(), 0L)) {
			return new ResponseEntity<PessoaDto>(pessoaDto, HttpStatus.FOUND);
		}
		return new ResponseEntity<PessoaDto>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/pessoa/atualiza/{id}", method = RequestMethod.PUT)
	public ResponseEntity<PessoaDto> atualiza(@PathVariable(value = "id") long id,
			@RequestBody PessoaDto pessoaDto)
			throws Exception {
		PessoaDto dto = pessoaService.getById(id);
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dto.getDataAniversario());
		if (!Objects.equals(dto.getCpf(), 0L)) {
			pessoaDto.setCpf(dto.getCpf());
			if (Strings.isNullOrEmpty(pessoaDto.getNome())) {
				pessoaDto.setNome(dto.getNome());
			}
			if (Strings.isNullOrEmpty(pessoaDto.getNumeroCelular())) {
				pessoaDto.setNumeroCelular(dto.getNumeroCelular());
			}
			if (Strings.isNullOrEmpty(pessoaDto.getDataAniversario())) {
				pessoaDto.setDataAniversario(dto.getDataAniversario());
			}
			pessoaService.save(pessoaDto, date);
			return new ResponseEntity<PessoaDto>(HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<PessoaDto>(HttpStatus.BAD_REQUEST);
	}
}

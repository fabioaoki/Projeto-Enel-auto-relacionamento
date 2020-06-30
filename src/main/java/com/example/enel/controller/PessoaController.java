package com.example.enel.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import org.apache.logging.log4j.util.Strings;
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
	
	@RequestMapping(value = "/pessoa/busca/{id}", method = RequestMethod.GET)
	public ResponseEntity<PessoaDto> buscaDadosPessoa(@PathVariable(value = "id") long id){
		PessoaDto pessoaDto = pessoaService.getById(id);
		if(!Objects.equals(pessoaDto.getCpf(), 0L)) {
			return new ResponseEntity<PessoaDto>(pessoaDto, HttpStatus.FOUND);
		}
		return new ResponseEntity<PessoaDto>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/pessoa/atualiza/{id}", method = RequestMethod.PUT)
	public ResponseEntity<PessoaDto> atualiza(@PathVariable(value = "id") long id,
			@RequestBody PessoaDto pessoaDto){
		PessoaDto dto = pessoaService.getById(id);
		if(!Objects.equals(dto.getCpf(), 0L)) {
			pessoaDto.setCpf(id);
			if(Strings.isEmpty(pessoaDto.getNome())){
				pessoaDto.setNome(dto.getNome());
			}
			if(Strings.isEmpty(pessoaDto.getNumeroCelular())) {
				pessoaDto.setNumeroCelular(dto.getNumeroCelular());
			}
			pessoaService.save(dto);
		}
		
		return null;
	}
}



//@RequestMapping(value = "/weather/{id}",method = RequestMethod.PUT)
//public ResponseEntity<CityForecastDto> alterInformation(@PathVariable (value = "id") long id, 
//		@RequestBody CityForecastDto cityForecastDto){
//	
//	CityForecastDto dto = forecastService.verify(id);
//	if(Objects.nonNull(dto)){
//		cityForecastDto.setId(id);
//		if(Strings.isNullOrEmpty(cityForecastDto.getName())) {
//			cityForecastDto.setName(dto.getName());
//		}
//		if(Strings.isNullOrEmpty(cityForecastDto.getCity())) {
//			cityForecastDto.setCity(dto.getCity());
//		}
//		forecastService.save(cityForecastDto);
//		return new ResponseEntity<CityForecastDto>(cityForecastDto,HttpStatus.OK);
//	}
//	return new ResponseEntity<CityForecastDto>(HttpStatus.BAD_REQUEST);
//}
package com.example.enel.dto;

import java.io.Serializable;

import com.example.enel.entity.Pessoa;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PessoaDto implements Serializable {
	
	private static final long serialVersionUID = -966165954410480488L;

	private Long cpf;
	private String nome;
	private String dataAniversario;
	private String numeroCelular;
	private Pessoa cpfOrigem;

}

package com.example.enel.dto;

import java.io.Serializable;

import com.example.enel.entity.Pessoa;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EndrerecoDto implements Serializable  {

	private static final long serialVersionUID = -5844076427558246998L;

	private Long id;
	private String rua;
	private Long numero;
	private Long cep;
	private Pessoa cpfOrigem;
}

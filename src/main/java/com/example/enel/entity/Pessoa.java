package com.example.enel.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "pessoa_telefone")
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 6861446573345532533L;

	@Id
	@Column(name = "cpf")
	private Long cpf;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "data_aniversario")
	private Date dataAniversario;
	
	@Column(name = "numero_celular")
	private String numeroCelular;

	//	@OneToOne(optional=false)
	
	@OneToOne(optional=true)
	@JoinColumn(name = "cpf_origem", referencedColumnName = "cpf")
	private Pessoa cpfOrigem;
}

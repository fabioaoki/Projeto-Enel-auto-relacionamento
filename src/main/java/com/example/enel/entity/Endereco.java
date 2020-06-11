package com.example.enel.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "endereco")
public class Endereco implements Serializable {

	private static final long serialVersionUID = -7224668632453239924L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "rua")
	private String rua;
	
	@Column(name = "numero")
	private Long numero;
	
	@Column(name = "cep")
	private Long cep;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cpf")
	private Pessoa cpfOrigem;
	
}

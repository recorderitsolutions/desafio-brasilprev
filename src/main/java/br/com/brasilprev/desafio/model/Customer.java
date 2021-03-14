package br.com.brasilprev.desafio.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "name must be declared")
	private String name;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date birthDate;
	
	@NotEmpty(message = "CPF must be declared")
	@CPF(message = "CPF is invalid")
	private String cpf;
	
	@NotEmpty(message = "address must be declared")
	private String address;
	
	@NotNull(message = "number must be declared")
	private Integer number;
	
	@JsonInclude(Include.NON_NULL)
	private String complement;
	
	@NotEmpty(message = "district must be declared")
	private String district;
	
	@NotEmpty(message = "city must be declared")
	private String city;
	
	@NotEmpty(message = "state must be declared")
	private String state;
	
	@NotNull(message = "zipcode must be declared")
	private Integer zipcode;
	
	@JsonInclude(Include.NON_NULL)
	private Integer phone;
}

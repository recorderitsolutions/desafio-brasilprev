package br.com.brasilprev.desafio.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.brasilprev.desafio.model.Customer;
import br.com.brasilprev.desafio.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/api/v1/customers")
@Api(value = "BrasilPrev Challenger API Rest Customers")
@CrossOrigin(origins = "*")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@ApiOperation(value = "This operation find all customers", response = Customer[].class)
	@SuppressWarnings("rawtypes")
	@GetMapping
	public ResponseEntity findAll() {
		return ResponseEntity.ok(customerService.findAll());
	}
	
	@ApiOperation(value = "This operation find a specific customer", response = Customer.class)
	@SuppressWarnings("rawtypes")
	@GetMapping(path = "/{id}")
	public ResponseEntity getOne(@PathVariable Long id) {
		return ResponseEntity.ok(customerService.getOne(id));
	}
	
	@ApiOperation(value = "This operation receive a Customer and save it")
	@SuppressWarnings("rawtypes")
	@PostMapping
	public ResponseEntity save(@Valid @RequestBody Customer customer) {
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(customerService.save(customer).getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@ApiOperation(value = "This operation receive a Customer and its ID and update it")
	@SuppressWarnings("rawtypes")
	@PutMapping(path = "/{id}")
	public ResponseEntity update(@Valid @RequestBody Customer customer, @PathVariable Long id) {
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(customerService.update(customer, id).getId())
				.toUri();
		return ResponseEntity.noContent().location(uri).build();
	}
	
	@ApiOperation(value = "This operation receive an ID and delete it")
	@SuppressWarnings("rawtypes")
	@DeleteMapping(path = "/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		customerService.delete(id);
		return ResponseEntity.noContent().build();
	}
}

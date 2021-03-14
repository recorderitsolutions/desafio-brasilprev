package br.com.brasilprev.desafio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brasilprev.desafio.exception.CustomerConflictException;
import br.com.brasilprev.desafio.exception.CustomerNotFoundException;
import br.com.brasilprev.desafio.model.Customer;
import br.com.brasilprev.desafio.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> findAll() {
		List<Customer> customers = customerRepository.findAll();
		
		if (customers == null || customers.isEmpty()) throw new CustomerNotFoundException("Customers not found");
		
		return customers;
	}
	
	public Customer getOne(Long id) {
		if (id == null) throw new IllegalArgumentException("Invalid Id");
		
		Optional<Customer> customer = customerRepository.findById(id);
		
		if (!customer.isPresent()) throw new CustomerNotFoundException("Customer not found");
		
		return customer.get();
	}
	
	public Customer save(Customer customer) {
		if (customer == null) throw new IllegalArgumentException("Invalid customer");
		
		if (customer.getId() != null) {
			Optional<Customer> customerFound = customerRepository.findById(customer.getId());
			
			if (customerFound.isPresent()) throw new CustomerConflictException("Customer already exists");
		}
		
		customer.setId(null);
		customer = customerRepository.save(customer);
		return customer;
	}
	
	public Customer update(Customer customer, Long id) {
		if (customer == null) throw new IllegalArgumentException("Invalid customer");
		
		if (id == null) throw new IllegalArgumentException("Invalid Id");
		
		getOne(id);
		customer = customerRepository.save(customer);
		return customer;
	}
	
	public void delete(Long id) {
		if (id == null) throw new IllegalArgumentException("Invalid Id");
		
		Customer customer = getOne(id);
		customerRepository.delete(customer);
	}
}

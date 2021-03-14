package br.com.brasilprev.desafio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.brasilprev.desafio.exception.CustomerConflictException;
import br.com.brasilprev.desafio.exception.CustomerNotFoundException;
import br.com.brasilprev.desafio.model.Customer;
import br.com.brasilprev.desafio.repository.CustomerRepository;

@RunWith(SpringRunner.class)
public class CustomerServiceTest {
	@TestConfiguration
	static class CustomerServiceConfiguration {
		@Bean
		public CustomerService pedidoService() {
			return new CustomerService();
		}
	}
	
	@Autowired
	CustomerService customerService;
	
	@MockBean
	CustomerRepository customerRepository;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void findAll_comRetornoNuloIraFalhar() {
		Mockito
			.when(customerRepository.findAll())
			.thenReturn(null);
		
		exception.expect(CustomerNotFoundException.class);
		
		customerService.findAll();
	}
	
	@Test
	public void findAll_comRetornoValidoFinalizaraComSucesso() {
		Customer customer = new Customer();
		customer.setId(1l);
		customer.setName("Jose");
		customer.setCpf("99999999999");
		customer.setAddress("Rua 1");
		customer.setNumber(1);
		customer.setDistrict("Bairro 1");
		customer.setCity("Cidade 1");
		customer.setState("Estado 1");
		List<Customer> customers = new ArrayList<>();
		customers.add(customer);
		
		Mockito
			.when(customerRepository.findAll())
			.thenReturn(customers);
		
		List<Customer> returns = customerService.findAll();
		
		Assert.assertEquals(returns, customers);
	}
	
	@Test
	public void getOne_comRetornoNuloIraFalhar() {
		Optional<Customer> customer = Optional.empty();
		
		Mockito
			.when(customerRepository.findById(1l))
			.thenReturn(customer);
		
		exception.expect(CustomerNotFoundException.class);
		
		customerService.getOne(1l);
	}
	
	@Test
	public void getOne_comIdNuloIraFalhar() {
		exception.expect(IllegalArgumentException.class);
		customerService.getOne(null);
	}
	
	@Test
	public void getOne_comRetornoValidoFinalizaraComSucesso() {
		Customer customer = new Customer();
		customer.setId(1l);
		customer.setName("Jose");
		customer.setCpf("99999999999");
		customer.setAddress("Rua 1");
		customer.setNumber(1);
		customer.setDistrict("Bairro 1");
		customer.setCity("Cidade 1");
		customer.setState("Estado 1");
		
		Mockito
			.when(customerRepository.findById(1l))
			.thenReturn(Optional.of(customer));
		
		Customer returns = customerService.getOne(1l);
		
		Assert.assertEquals(returns, customer);
	}
	
	@Test
	public void update_comIdNuloIraFalhar() {
		exception.expect(IllegalArgumentException.class);
		customerService.update(new Customer(), null);
	}
	
	@Test
	public void update_comCustomerNuloIraFalhar() {
		exception.expect(IllegalArgumentException.class);
		customerService.update(null, 1l);
	}
	
	@Test
	public void update_comRetornoNuloIraFalhar() {
		Customer customer = new Customer();
		customer.setId(1l);
		customer.setName("Jose");
		customer.setCpf("99999999999");
		customer.setAddress("Rua 1");
		customer.setNumber(1);
		customer.setDistrict("Bairro 1");
		customer.setCity("Cidade 1");
		customer.setState("Estado 1");
		
		Mockito
			.when(customerRepository.findById(1l))
			.thenReturn(Optional.empty());
		
		exception.expect(CustomerNotFoundException.class);
		
		customerService.update(customer, 1l);
	}
	
	@Test
	public void update_comRetornoValidoFinalizaraComSucesso() {
		Customer customer = new Customer();
		customer.setId(1l);
		customer.setName("Jose");
		customer.setCpf("99999999999");
		customer.setAddress("Rua 1");
		customer.setNumber(1);
		customer.setDistrict("Bairro 1");
		customer.setCity("Cidade 1");
		customer.setState("Estado 1");
		
		Customer customerUpdated = new Customer();
		customerUpdated.setId(1l);
		customerUpdated.setName("Jose Antonio");
		customerUpdated.setCpf("99999999999");
		customerUpdated.setAddress("Rua 1");
		customerUpdated.setNumber(1);
		customerUpdated.setDistrict("Bairro 1");
		customerUpdated.setCity("Cidade 1");
		customerUpdated.setState("Estado 1");
		
		Mockito
			.when(customerRepository.findById(1l))
			.thenReturn(Optional.of(customer));
		
		Mockito
			.when(customerRepository.save(customerUpdated))
			.thenReturn(customerUpdated);		
		
		Customer customerExpected = customerService.update(customerUpdated, 1l);
		
		Assert.assertEquals(customerExpected, customerUpdated);
	}
	
	@Test
	public void delete_comIdNuloIraFalhar() {
		exception.expect(IllegalArgumentException.class);
		customerService.delete(null);
	}
	
	@Test
	public void delete_comRetornoNuloIraFalhar() {
		Customer customer = new Customer();
		customer.setId(1l);
		customer.setName("Jose");
		customer.setCpf("99999999999");
		customer.setAddress("Rua 1");
		customer.setNumber(1);
		customer.setDistrict("Bairro 1");
		customer.setCity("Cidade 1");
		customer.setState("Estado 1");
		
		Mockito
			.when(customerRepository.findById(1l))
			.thenReturn(Optional.empty());
		
		exception.expect(CustomerNotFoundException.class);
		
		customerService.update(customer, 1l);
	}
	
	@Test
	public void delete_comRetornoValidoFinalizaraComSucesso() {
		Customer customer = new Customer();
		customer.setId(1l);
		customer.setName("Jose");
		customer.setCpf("99999999999");
		customer.setAddress("Rua 1");
		customer.setNumber(1);
		customer.setDistrict("Bairro 1");
		customer.setCity("Cidade 1");
		customer.setState("Estado 1");
		
		Mockito
			.when(customerRepository.findById(1l))
			.thenReturn(Optional.of(customer));
		
		customerService.delete(1l);
		
		Mockito.verify(customerRepository, Mockito.times(1)).delete(customer);
	}
	
	@Test
	public void save_comCustomerNuloIraFalhar() {
		exception.expect(IllegalArgumentException.class);
		customerService.save(null);
	}
	
	@Test
	public void save_comRetornoValidoIraFalhar() {
		Customer customer = new Customer();
		customer.setId(1l);
		customer.setName("Jose");
		customer.setCpf("99999999999");
		customer.setAddress("Rua 1");
		customer.setNumber(1);
		customer.setDistrict("Bairro 1");
		customer.setCity("Cidade 1");
		customer.setState("Estado 1");
		
		Mockito
			.when(customerRepository.findById(customer.getId()))
			.thenReturn(Optional.of(customer));
		
		exception.expect(CustomerConflictException.class);
		
		customerService.save(customer);
	}
	
	@Test
	public void save_comIdNuloFinalizaraComSucesso() {
		Customer customer = new Customer();
		customer.setName("Jose");
		customer.setCpf("99999999999");
		customer.setAddress("Rua 1");
		customer.setNumber(1);
		customer.setDistrict("Bairro 1");
		customer.setCity("Cidade 1");
		customer.setState("Estado 1");
		
		Customer customerInserted = new Customer();
		customerInserted.setId(1l);
		customerInserted.setName("Jose");
		customerInserted.setCpf("99999999999");
		customerInserted.setAddress("Rua 1");
		customerInserted.setNumber(1);
		customerInserted.setDistrict("Bairro 1");
		customerInserted.setCity("Cidade 1");
		customerInserted.setState("Estado 1");
		
		Mockito
			.when(customerRepository.save(customer))
			.thenReturn(customerInserted);
		
		Customer returns = customerService.save(customer);
		
		Assert.assertEquals(returns, customerInserted);
	}
}

package br.com.brasilprev.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.brasilprev.desafio.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}

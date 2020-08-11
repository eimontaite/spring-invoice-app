package aiste.invoices.services;

import aiste.invoices.models.Customer;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Validated
public interface CustomerService {
	Iterable<Customer> getAllCustomers();

	Optional<Customer> getCustomerById(long customerId);

	Customer create(Customer customer);

	Customer update(Customer customer);


}

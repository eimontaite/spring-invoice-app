package aiste.invoices.services;

import aiste.invoices.models.Customer;
import aiste.invoices.repositories.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;

	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public Iterable<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Optional<Customer> getCustomerById(long customerId) {
		return customerRepository.findById(customerId);
	}

	@Override
	public Customer create(Customer customer) {
		return this.customerRepository.save(customer);
	}
}

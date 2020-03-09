package aiste.invoices.controllers;

import aiste.invoices.models.Customer;
import aiste.invoices.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CustomerController {
	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping("/customers")
	public @ResponseBody Iterable<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@GetMapping("/customer/{id}")
	public @ResponseBody
	Optional<Customer> getCustomerById(@PathVariable long id) {
		return customerRepository.findById(id);
	}

	@PostMapping("/customer")
	public @ResponseBody String addNewCustomer(
			@RequestParam String name,
			@RequestParam(required = false) String address,
			@RequestParam(required = false) String code,
			@RequestParam(required = false) boolean legalEntity
	) {
		Customer c = new Customer();
		c.setName(name);
		c.setAddress(address);
		c.setCode(code);
		c.setLegalEntity(legalEntity);
		customerRepository.save(c);
		return "Success!";
	}
}

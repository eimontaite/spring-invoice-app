package aiste.invoices.controllers;

import aiste.invoices.models.Customer;
import aiste.invoices.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CustomerController {

	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping("/customers")
	public @ResponseBody Iterable<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}

	@GetMapping("/customer/{id}")
	public @ResponseBody
	Optional<Customer> getCustomerById(@PathVariable long id) {
		return customerService.getCustomerById(id);
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
		customerService.create(c);
		return "Success!";
	}
}

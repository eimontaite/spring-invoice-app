package aiste.invoices.controllers;

import aiste.invoices.models.Customer;
import aiste.invoices.services.CustomerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	@GetMapping("/customers/{id}")
	public @ResponseBody
	Optional<Customer> getCustomerById(@PathVariable long id) {
		return customerService.getCustomerById(id);
	}

	@PostMapping("/customers/new")
	public ResponseEntity<Customer> create(@ModelAttribute CustomerController.CustomerInfoForm form) {
		System.out.println(form.address);
		Customer c = new Customer();
		c.setUserId(form.userId);
		c.setName(form.name);
		c.setAddress(form.address);
		c.setCode(form.code);
		c.setLegalEntity(form.legalEntity);
		c = this.customerService.create(c);
		HttpHeaders headers = new HttpHeaders();

		return new ResponseEntity<>(c, headers, HttpStatus.CREATED);
	}

	public static class CustomerInfoForm {

		private Long userId;

		private String name;

		private String address;

		private String code;

		private Boolean legalEntity;

		public void setUserId(Long userId) {
			this.userId = userId;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public void setLegalEntity(Boolean isLegalEntity) {
			this.legalEntity = isLegalEntity;
		}

	}
}

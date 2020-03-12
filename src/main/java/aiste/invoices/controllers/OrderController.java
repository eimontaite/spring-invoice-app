package aiste.invoices.controllers;

import aiste.invoices.models.Customer;
import aiste.invoices.models.Invoice;
import aiste.invoices.models.Order;
import aiste.invoices.repositories.CustomerRepository;
import aiste.invoices.repositories.InvoiceRepository;
import aiste.invoices.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private InvoiceRepository invoiceRepository;

	@GetMapping("/orders")
	public @ResponseBody Iterable<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	@GetMapping("/order/{invoiceId}")
	public @ResponseBody
	List<Order> getOrderByInvoiceId(@PathVariable long invoiceId) {
		return orderRepository.findByInvoiceId(invoiceId);
	}
}

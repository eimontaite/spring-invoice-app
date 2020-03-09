package aiste.invoices.controllers;

import aiste.invoices.models.Customer;
import aiste.invoices.models.Order;
import aiste.invoices.repositories.CustomerRepository;
import aiste.invoices.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class OrderController {
	@Autowired
	private OrderRepository orderRepository;

	@GetMapping("/orders")
	public @ResponseBody Iterable<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	@GetMapping("/order/{invoiceId}")
	public @ResponseBody
	List<Order> getOrderByInvoiceId(@PathVariable long invoiceId) {
		return orderRepository.findByInvoiceId(invoiceId);
	}

	@PostMapping("/order")
	public @ResponseBody String addNewOrder(
			@RequestParam Long invoiceId,
			@RequestParam Long typeId,
			@RequestParam Long quantity,
			@RequestParam Long price
	) {
		Order o = new Order();
		o.setInvoiceId(invoiceId);
		o.setTypeId(typeId);
		o.setQuantity(quantity);
		o.setPrice(price);
		orderRepository.save(o);
		return "Success!";
	}
}

package aiste.invoices.controllers;

import aiste.invoices.models.Order;
import aiste.invoices.services.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

	private OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@GetMapping("/orders")
	public @ResponseBody Iterable<Order> getAllOrders() {
		return orderService.getAllOrders();
	}

	@GetMapping("/order/{invoiceId}")
	public @ResponseBody
	List<Order> getOrderByInvoiceId(@PathVariable long invoiceId) {
		return orderService.getByInvoiceId(invoiceId);
	}
}

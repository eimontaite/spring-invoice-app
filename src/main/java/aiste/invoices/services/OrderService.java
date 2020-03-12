package aiste.invoices.services;

import aiste.invoices.models.Order;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface OrderService {

	Iterable<Order> getAllOrders();

	List<Order> getByInvoiceId(long invoiceId);

	Order create(Order order);
}

package aiste.invoices.services;

import aiste.invoices.models.Order;
import aiste.invoices.repositories.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	private OrderRepository orderRepository;

	public OrderServiceImpl(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@Override
	public Iterable<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	@Override
	public List<Order> getByInvoiceId(long invoiceId) {
		return orderRepository.findByInvoiceId(invoiceId);
	}

	@Override
	public Order create(Order order) {
		return this.orderRepository.save(order);
	}


}

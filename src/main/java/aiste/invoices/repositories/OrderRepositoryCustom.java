package aiste.invoices.repositories;

import aiste.invoices.models.Order;

import java.util.List;

public interface OrderRepositoryCustom {

	List<Order> findByInvoiceId(long invoiceId);

}
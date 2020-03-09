package aiste.invoices.repositories;

import aiste.invoices.models.Invoice;
import aiste.invoices.models.Order;

import java.util.List;

public interface OrderRepositoryCustom {

	public List<Order> findByInvoiceId(Long invoiceId);

}
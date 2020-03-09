package aiste.invoices.repositories;

import aiste.invoices.models.Invoice;

import java.util.List;

public interface InvoiceRepositoryCustom {

	public List<Invoice> findByCustomerId(Long customerId);

}
package aiste.invoices.repositories;

import aiste.invoices.models.Invoice;

import java.util.List;

public interface InvoiceRepositoryCustom {

	List<Invoice> findByCustomerId(Long customerId);

}
package aiste.invoices.services;

import aiste.invoices.models.Invoice;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface InvoiceService {
	Iterable<Invoice> getAllInvoices();

	List<Invoice> getInvoicesByCustomerId(long invoiceId);

	Invoice create(Invoice invoice);
}

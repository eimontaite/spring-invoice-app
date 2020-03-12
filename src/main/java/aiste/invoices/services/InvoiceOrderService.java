package aiste.invoices.services;

import aiste.invoices.models.InvoiceOrder;
import org.springframework.validation.annotation.Validated;

@Validated
public interface InvoiceOrderService {

	InvoiceOrder create(InvoiceOrder invoiceOrder);

}

package aiste.invoices.services;

import aiste.invoices.models.Invoice;
import aiste.invoices.repositories.InvoiceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {

	private InvoiceRepository invoiceRepository;

	public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
		this.invoiceRepository = invoiceRepository;
	}

	@Override
	public Iterable<Invoice> getAllInvoices() {
		return invoiceRepository.findAll();
	}

	@Override
	public List<Invoice> getInvoicesByCustomerId(long customerId) {
		return invoiceRepository.findByCustomerId(customerId);
	}

	@Override
	public Invoice create(Invoice invoice) {
		return this.invoiceRepository.save(invoice);
	}
}

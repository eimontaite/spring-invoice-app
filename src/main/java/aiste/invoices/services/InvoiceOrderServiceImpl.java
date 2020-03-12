package aiste.invoices.services;

import aiste.invoices.models.InvoiceOrder;
import aiste.invoices.repositories.InvoiceOrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InvoiceOrderServiceImpl implements InvoiceOrderService {

	private InvoiceOrderRepository invoiceOrderRepository;

	public InvoiceOrderServiceImpl(InvoiceOrderRepository invoiceOrderRepository) {
		this.invoiceOrderRepository = invoiceOrderRepository;
	}

	@Override
	public InvoiceOrder create(InvoiceOrder invoiceOrder) {
		return this.invoiceOrderRepository.save(invoiceOrder);
	}

}

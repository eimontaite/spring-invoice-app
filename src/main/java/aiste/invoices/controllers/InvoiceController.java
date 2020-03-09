package aiste.invoices.controllers;

import aiste.invoices.models.Invoice;
import aiste.invoices.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;

@RestController
public class InvoiceController {

	@Autowired
	private InvoiceRepository invoiceRepository;

	@PostMapping("/invoice")
	public @ResponseBody
	String addNewInvoice(
			@RequestParam Long customerId
	) {
		Invoice i = new Invoice();
		i.setCustomerId(customerId);
		i.setDateTime(OffsetDateTime.now());
		invoiceRepository.save(i);
		return "Invoice created successfully!";
	}

	@GetMapping("/invoices")
	public @ResponseBody Iterable<Invoice> getAllInvoices() {
		return invoiceRepository.findAll();
	}

	@GetMapping("/invoices/{customerId}")
	public @ResponseBody Iterable<Invoice> getInvoicesByCustomerId(@PathVariable Long customerId) {
		return invoiceRepository.findByCustomerId(customerId);
	}
}

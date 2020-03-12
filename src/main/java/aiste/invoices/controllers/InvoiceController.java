package aiste.invoices.controllers;

import aiste.invoices.models.Invoice;
import aiste.invoices.models.InvoiceOrder;
import aiste.invoices.repositories.InvoiceOrderRepository;
import aiste.invoices.repositories.InvoiceRepository;
import aiste.invoices.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class InvoiceController {

	@Autowired
	private InvoiceRepository invoiceRepository;

	@Autowired
	private InvoiceOrderRepository invoiceOrderRepository;

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

	@PostMapping("/invoices")
	public ResponseEntity<Invoice> create(@RequestBody InvoiceForm form) {
		List<InvoiceOrder> formDtos = form.getOrders();
		Invoice invoice = new Invoice();
		invoice.setCustomerId(form.customerId);
		invoice.setDateTime(OffsetDateTime.now());

		invoice.setOrders(form.orders);


		invoice = this.invoiceRepository.save(invoice);

		List<InvoiceOrder> orders = new ArrayList<>();
		for (InvoiceOrder dto : formDtos) {
			orders.add(invoiceOrderRepository.save(new InvoiceOrder(invoice, dto)));
		}

		// fixme returns invoiceId as null
		HttpHeaders headers = new HttpHeaders();

		return new ResponseEntity<>(invoice, headers, HttpStatus.CREATED);
	}

		@GetMapping("/invoices")
		public @ResponseBody Iterable<Invoice> getAllInvoices () {
			return invoiceRepository.findAll();
		}

		@GetMapping("/invoices/{customerId}")
		public @ResponseBody Iterable<Invoice> getInvoicesByCustomerId (@PathVariable Long customerId){
			return invoiceRepository.findByCustomerId(customerId);
		}

		public static class InvoiceForm {

			private Long customerId;

			private OffsetDateTime dateTime;

			private List<InvoiceOrder> orders;

			public List<InvoiceOrder> getOrders() {
				return orders;
			}

			public void setCustomerId(Long customerId) {
				this.customerId = customerId;
			}

			public void setDateTime() {
				this.dateTime = OffsetDateTime.now();
			}
			public void setOrders(List<InvoiceOrder> orders) {
				this.orders = orders;
			}
		}
}

package aiste.invoices.controllers;

import aiste.invoices.models.Invoice;
import aiste.invoices.models.InvoiceOrder;
import aiste.invoices.services.InvoiceOrderService;
import aiste.invoices.services.InvoiceService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;

@RestController
public class InvoiceController {

	private InvoiceService invoiceService;

	private InvoiceOrderService invoiceOrderService;

	public InvoiceController(InvoiceService invoiceService, InvoiceOrderService invoiceOrderService) {
		this.invoiceService = invoiceService;
		this.invoiceOrderService = invoiceOrderService;
	}

	@PostMapping("/invoices/new")
	public @ResponseBody
	String addNewInvoice(
			@RequestParam Long customerId
	) {
		Invoice i = new Invoice();
		i.setCustomerId(customerId);
		i.setDateTime(OffsetDateTime.now());
		invoiceService.create(i);
		return "Invoice created successfully!";
	}

	@PostMapping("/invoices")
	public ResponseEntity<Invoice> create(@RequestBody InvoiceForm form) {
//		List<InvoiceOrder> formDtos = form.getOrders();
		Invoice invoice = new Invoice();
		invoice.setCustomerId(form.customerId);
		invoice.setDateTime(OffsetDateTime.now());

//		invoice.setOrders(form.orders);


		invoice = this.invoiceService.create(invoice);

//		List<InvoiceOrder> orders = new ArrayList<>();
//		for (InvoiceOrder dto : formDtos) {
//			orders.add(invoiceOrderService.create(new InvoiceOrder(invoice, dto)));
//		}

		// fixme returns invoiceId as null
		HttpHeaders headers = new HttpHeaders();

		return new ResponseEntity<>(invoice, headers, HttpStatus.CREATED);
	}

		@GetMapping("/invoices")
		public @ResponseBody Iterable<Invoice> getAllInvoices () {
			return invoiceService.getAllInvoices();
		}

		@GetMapping("/invoices/{customerId}")
		public @ResponseBody Iterable<Invoice> getInvoicesByCustomerId (@PathVariable Long customerId){
			return invoiceService.getInvoicesByCustomerId(customerId);
		}

		public static class InvoiceForm {

			private Long customerId;

			private OffsetDateTime dateTime;

//			private List<InvoiceOrder> orders;
//
//			public List<InvoiceOrder> getOrders() {
//				return orders;
//			}

			public void setCustomerId(Long customerId) {
				this.customerId = customerId;
			}

			public void setDateTime() {
				this.dateTime = OffsetDateTime.now();
			}
//			public void setOrders(List<InvoiceOrder> orders) {
//				this.orders = orders;
//			}

		}
}

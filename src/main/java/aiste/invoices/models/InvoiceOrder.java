package aiste.invoices.models;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class InvoiceOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "type_id")
	private Long typeId;

	@Column(name = "quantity")
	private Long quantity;

	@Column(name = "price")
	private Long price;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "invoice_id", nullable = false)
	private Invoice invoice;

	public Order() {
	}

	public Order(Invoice i, InvoiceOrder o) {
		this.invoice = i;
		this.typeId = o.typeId;
		this.quantity = o.quantity;
		this.price = o.price;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}
//
//	public Invoice getInvoice() {
//		return invoice;
//	}
//
//	public void setInvoice(Invoice invoice) {
//		this.invoice = invoice;
//	}
}

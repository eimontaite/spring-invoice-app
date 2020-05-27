package aiste.invoices.models;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "item_name")
	private String itemName;

	@Column(name = "type_id")
	private Long typeId;

	@Column(name = "quantity")
	private Long quantity;

	@Column(name = "price")
	private Long price;

	@Column(name = "invoice_id")
	private Long invoiceId;

	public Order() {
	}

	public Order(Invoice i, Order o) {
		this.invoiceId = i.getId();
		this.itemName = o.itemName;
		this.typeId = o.typeId;
		this.quantity = o.quantity;
		this.price = o.price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String name) {
		this.itemName = itemName;
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

	public Long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(long invoiceId) {
		this.invoiceId = invoiceId;
	}
}

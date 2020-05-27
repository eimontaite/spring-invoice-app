package aiste.invoices.models;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class InvoiceOrder {
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "invoice_id", nullable = false)
	private Invoice invoice;

	public InvoiceOrder() {
	}

	public InvoiceOrder(Invoice i, InvoiceOrder o) {
		this.typeId = o.typeId;
		this.itemName = o.itemName;
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

	public void setItemName(String itemName) {
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
}

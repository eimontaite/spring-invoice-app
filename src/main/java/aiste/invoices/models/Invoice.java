package aiste.invoices.models;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "invoices")
public class Invoice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@OneToMany(cascade = CascadeType.ALL,
			fetch = FetchType.LAZY,
			mappedBy = "invoice")
	private List<Order> orders = new ArrayList<>();

	@Column(name = "customer_id")
	private Long customerId;

	@Column(name = "date_time")
	private OffsetDateTime dateTime;

	public Long getId() {
		return id;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public OffsetDateTime getDateTime() {
		return dateTime;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public void setDateTime(OffsetDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
}

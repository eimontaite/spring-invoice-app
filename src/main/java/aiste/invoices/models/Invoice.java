package aiste.invoices.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.OffsetDateTime;

@Entity
public class Invoice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long customerId;
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
}

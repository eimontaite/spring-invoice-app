package aiste.invoices.models;


import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "address")
	private String address;

	@Column(name = "code")
	private String code;

	@Column(name = "legal_entity")
	private boolean legalEntity;

	@Column(name = "user_id")
	private long userId;

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getCode() {
		return code;
	}

	public boolean isLegalEntity() {
		return legalEntity;
	}

	public long getUserId() {
		return userId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setLegalEntity(boolean legalEntity) {
		this.legalEntity = legalEntity;
	}

	public void setUserId(long userId) {
		this.userId = userId
	}
}

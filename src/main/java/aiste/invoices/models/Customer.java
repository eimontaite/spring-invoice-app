package aiste.invoices.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String address;
	private String code;
	private boolean legalEntity;

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

}

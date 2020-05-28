package aiste.invoices.models;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "contact_details")
public class ContactDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "name")
	private String name;

	@Column(name = "surname")
	private String surname;

	@Column(name = "personal_number")
	private Long personalNumber;

	@Column(name = "business_licence_no")
	private String businessLicenceNo;

	@Column(name = "address")
	private String address;

	@Column(name = "email")
	private String email;

	@Column(name = "phone")
	private String phone;

	@Column(name = "bank_account")
	private String bankAccount;

	@Column(name = "bank")
	private String bank;

	@Column(name = "create_date_time")
	private OffsetDateTime createDateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Long getPersonalNumber() {
		return personalNumber;
	}

	public void setPersonalNumber(Long personalNumber) {
		this.personalNumber = personalNumber;
	}

	public String getBusinessLicenceNo() {
		return businessLicenceNo;
	}

	public void setBusinessLicenceNo(String businessLicenceNo) {
		this.businessLicenceNo = businessLicenceNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public OffsetDateTime getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(OffsetDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}
}

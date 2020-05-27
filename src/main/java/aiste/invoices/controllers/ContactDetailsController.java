package aiste.invoices.controllers;

import aiste.invoices.models.ContactDetails;
import aiste.invoices.services.ContactDetailsService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContactDetailsController {

	private ContactDetailsService contactDetailsService;

	public ContactDetailsController(ContactDetailsService contactDetailsService) {
		this.contactDetailsService = contactDetailsService;
	}

	@GetMapping("/contact-details/{userId}")
	public @ResponseBody
	Iterable<ContactDetails> getContactDetails(
			@PathVariable Long userId
	) {
		return contactDetailsService.getByUserId(userId);
	}

	@PostMapping("/contact-details/new")
	public ResponseEntity<ContactDetails> create(@RequestBody ContactDetailsController.ContactDetailsForm form) {
		{
			ContactDetails cd = new ContactDetails();
			cd.setUserId(form.userId);
			cd.setName(form.name);
			cd.setPersonalNumber(form.personalNumber);
			cd.setBusinessLicenceNo(form.businessLicenceNo);
			cd.setAddress(form.address);
			cd.setPhone(form.phone);
			cd.setBankAccount(form.bankAccount);
			cd.setBank(form.bank);
			cd = this.contactDetailsService.create(cd);

			HttpHeaders headers = new HttpHeaders();

			return new ResponseEntity<>(cd, headers, HttpStatus.CREATED);
		}
	}

	public static class ContactDetailsForm {

		private Long userId;

		private String name;

		private String surname;

		private Long personalNumber;

		private String businessLicenceNo;

		private String address;

		private String phone;

		private String bankAccount;

		private String bank;

		public void setUserId(Long userId) {
			this.userId = userId;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setSurname(String surname) {
			this.surname = surname;
		}
		public void setPersonalNumber(Long personalNumber) {
			this.personalNumber = personalNumber;
		}

		public void setBusinessLicenceNo(String businessLicenceNo) {
			this.businessLicenceNo = businessLicenceNo;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public void setBankAccount(String bankAccount) {
			this.bankAccount = bankAccount;
		}

		public void setBank(String bank) {
			this.bank = bank;
		}

	}
}

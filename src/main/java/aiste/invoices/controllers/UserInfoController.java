package aiste.invoices.controllers;

import aiste.invoices.models.UserInfo;
import aiste.invoices.services.UserInfoService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;

@RestController
public class UserInfoController {

	private UserInfoService userInfoService;

	public UserInfoController(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	@GetMapping("/user-info/{userId}")
	public @ResponseBody
	Iterable<UserInfo> getContactDetails(
			@PathVariable Long userId
	) {
		return userInfoService.getByUserId(userId);
	}

	@PostMapping("/user-info/new")
	public ResponseEntity<UserInfo> create(@ModelAttribute UserInfoController.UserInfoForm form) {
		{
			UserInfo cd = new UserInfo();
			cd.setUserId(form.userId);
			cd.setName(form.name);
			cd.setSurname(form.surname);
			cd.setPersonalNumber(form.personalNumber);
			cd.setBusinessLicenceNo(form.businessLicenceNo);
			cd.setAddress(form.address);
			cd.setEmail(form.email);
			cd.setPhone(form.phone);
			cd.setBankAccount(form.bankAccount);
			cd.setBank(form.bank);
			cd.setCreateDateTime(OffsetDateTime.now());
			cd = this.userInfoService.create(cd);

			HttpHeaders headers = new HttpHeaders();

			return new ResponseEntity<>(cd, headers, HttpStatus.CREATED);
		}
	}

	public static class UserInfoForm {

		private Long userId;

		private String name;

		private String surname;

		private Long personalNumber;

		private String businessLicenceNo;

		private String address;

		private String email;

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

		public void setEmail(String email) {
			this.email = email;
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

package aiste.invoices.services;

import aiste.invoices.models.ContactDetails;
import org.springframework.validation.annotation.Validated;

@Validated
public interface ContactDetailsService {
	Iterable<ContactDetails> getByUserId(long userId);

	ContactDetails create(ContactDetails contactDetails);

}

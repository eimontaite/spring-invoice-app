package aiste.invoices.services;

import aiste.invoices.models.ContactDetails;
import aiste.invoices.repositories.ContactDetailsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ContactDetailsServiceImpl implements ContactDetailsService {

	private ContactDetailsRepository contactDetailsRepository;

	public ContactDetailsServiceImpl(ContactDetailsRepository contactDetailsRepository) {
		this.contactDetailsRepository = contactDetailsRepository;
	}

	@Override
	public Iterable<ContactDetails> getByUserId(long userId) {
		return contactDetailsRepository.findByUserId(userId);
	}

	@Override
	public ContactDetails create(ContactDetails contactDetails) {
		return this.contactDetailsRepository.save(contactDetails);
	}
}

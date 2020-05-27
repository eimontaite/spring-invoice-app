package aiste.invoices.repositories;

import aiste.invoices.models.ContactDetails;

import java.util.List;

public interface ContactDetailsRepositoryCustom {

	List<ContactDetails> findByUserId(Long userId);

}
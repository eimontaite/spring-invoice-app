package aiste.invoices.repositories;

import aiste.invoices.models.ContactDetails;
import org.springframework.data.repository.CrudRepository;

public interface ContactDetailsRepository extends CrudRepository<ContactDetails, Long>, ContactDetailsRepositoryCustom {

}

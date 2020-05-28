package aiste.invoices.repositories;

import aiste.invoices.models.UserInfo;
import org.springframework.data.repository.CrudRepository;

public interface ContactDetailsRepository extends CrudRepository<UserInfo, Long>, ContactDetailsRepositoryCustom {

}

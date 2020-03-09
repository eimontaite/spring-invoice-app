package aiste.invoices.repositories;

import aiste.invoices.models.Invoice;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceRepository extends CrudRepository<Invoice, Long>, InvoiceRepositoryCustom {

}

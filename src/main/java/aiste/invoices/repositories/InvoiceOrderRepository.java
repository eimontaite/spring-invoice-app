package aiste.invoices.repositories;

import aiste.invoices.models.InvoiceOrder;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceOrderRepository extends CrudRepository<InvoiceOrder, Long> {

}

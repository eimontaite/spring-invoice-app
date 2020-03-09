package aiste.invoices.repositories;

import aiste.invoices.models.Customer;
import aiste.invoices.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long>, OrderRepositoryCustom {

}

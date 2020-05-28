package aiste.invoices.repositories;

import aiste.invoices.models.UserInfo;

import java.util.List;

public interface ContactDetailsRepositoryCustom {

	List<UserInfo> findByUserId(Long userId);

}
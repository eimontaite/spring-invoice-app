package aiste.invoices.services;

import aiste.invoices.models.UserInfo;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Validated
public interface UserInfoService {
	Iterable<UserInfo> getByUserId(long userId);

	Optional<UserInfo> getById(long id);

	UserInfo create(UserInfo userInfo);

	UserInfo update(UserInfo userInfo);


}

package aiste.invoices.services;

import aiste.invoices.models.UserInfo;
import org.springframework.validation.annotation.Validated;

@Validated
public interface UserInfoService {
	Iterable<UserInfo> getByUserId(long userId);

	UserInfo create(UserInfo userInfo);

}

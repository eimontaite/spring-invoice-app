package aiste.invoices.services;

import aiste.invoices.models.UserInfo;
import aiste.invoices.repositories.ContactDetailsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

	private ContactDetailsRepository contactDetailsRepository;

	public UserInfoServiceImpl(ContactDetailsRepository contactDetailsRepository) {
		this.contactDetailsRepository = contactDetailsRepository;
	}

	@Override
	public Iterable<UserInfo> getByUserId(long userId) {
		return contactDetailsRepository.findByUserId(userId);
	}

	@Override
	public UserInfo create(UserInfo userInfo) {
		return this.contactDetailsRepository.save(userInfo);
	}
}

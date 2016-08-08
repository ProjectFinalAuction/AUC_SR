package org.khmeracademy.auction.services.impl;

import java.util.ArrayList;

import org.khmeracademy.auction.entities.UserCreditHistory;
import org.khmeracademy.auction.repositories.UserCreditHistoryRepository;
import org.khmeracademy.auction.services.UserCreditHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCreditHistoryServiceImpl implements UserCreditHistoryService {
	@Autowired
	private UserCreditHistoryRepository userCreditHistoryRepository;

	@Override
	public ArrayList<UserCreditHistory> findAllUserCreditHistory() {
		return userCreditHistoryRepository.findAllUserCreditHistory();
	}

	@Override
	public ArrayList<UserCreditHistory> findUserCreditHistoryByUserName(String user_name) {
		return userCreditHistoryRepository.findUserCreditHistoryByUserName(user_name);
	}

	@Override
	public boolean addUserCreditHistory(UserCreditHistory uch) {
		return userCreditHistoryRepository.addUserCreditHistory(uch);
	}

	@Override
	public boolean updateUserCreditHistory(UserCreditHistory uch) {
		return userCreditHistoryRepository.updateUserCreditHistory(uch);
	}

	@Override
	public boolean deleteUserCreditHistory(int credit_id) {
		return userCreditHistoryRepository.deleteUserCreditHistory(credit_id);
	}
	
	
}
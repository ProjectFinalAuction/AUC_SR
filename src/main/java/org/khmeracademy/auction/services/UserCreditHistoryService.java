package org.khmeracademy.auction.services;

import java.util.ArrayList;

import org.khmeracademy.auction.entities.UserCreditHistory;

public interface UserCreditHistoryService {
	public ArrayList<UserCreditHistory> findAllUserCreditHistory();
	public ArrayList<UserCreditHistory> findUserCreditHistoryByUserName(String user_name);
	public boolean addUserCreditHistory(UserCreditHistory uch);
	public boolean updateUserCreditHistory(UserCreditHistory uch);
	public boolean deleteUserCreditHistory(int credit_id);	
}

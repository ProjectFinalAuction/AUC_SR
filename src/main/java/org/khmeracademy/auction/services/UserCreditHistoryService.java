package org.khmeracademy.auction.services;

import java.util.ArrayList;

import org.khmeracademy.auction.entities.UserCreditHistory;
import org.khmeracademy.auction.entities.UserCreditHistoryInputUpdate;

public interface UserCreditHistoryService {
	public ArrayList<UserCreditHistory> findAllUserCreditHistory();
	public ArrayList<UserCreditHistory> findUserCreditHistoryByUserName(String user_name);
	public boolean addUserCreditHistory(UserCreditHistoryInputUpdate uch);
	public boolean updateUserCreditHistory(UserCreditHistoryInputUpdate uch);
	public boolean deleteUserCreditHistory(int credit_id);	
	public UserCreditHistory checkEndingAmound(int userId);
}

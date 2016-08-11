package org.khmeracademy.auction.repositories;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.khmeracademy.auction.entities.UserCreditHistory;
import org.khmeracademy.auction.entities.UserCreditHistoryInputUpdate;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCreditHistoryRepository {
	final String FIND_ALL_USER_CREDIT_HISTORY="SELECT * FROM v_find_all_user_credit_history";
	@Select(FIND_ALL_USER_CREDIT_HISTORY)
	public ArrayList<UserCreditHistory> findAllUserCreditHistory();
	
	final String FIND_USER_CREDIT_HISTORY_BY_USER_NAME=
					" SELECT * FROM v_find_all_user_credit_history WHERE u.user_name = #{user_name}	";
	@Select(FIND_USER_CREDIT_HISTORY_BY_USER_NAME)
	public ArrayList<UserCreditHistory> findUserCreditHistoryByUserName(String user_name);
	
	
	final String ADD_USER_CREDIT_HISTORY=
					"	INSERT INTO auc_user_credit_history(	"+
					"	credit_date,	"+
					"	user_id,	"+
					"	beginning_amount,	"+
					"	transaction_type,	"+
					"	amount,	"+
					"	ending_amount)	"+
					"	VALUES (	"+
					"	#{credit_date},	"+
					"	#{user_id},	"+
					"	#{beginning_amount},	"+
					"	#{transaction_type},	"+
					"	#{amount},	"+
					"	#{ending_amount})	";
	@Insert(ADD_USER_CREDIT_HISTORY)
	public boolean addUserCreditHistory(UserCreditHistoryInputUpdate uch);
	
	final String UPDATE_USER_CREDIT_HISTORY=
					"	UPDATE auc_user_credit_history	"+
					"	SET credit_date = #{credit_date},	"+
					"	user_id = #{user_id},	"+
					"	beginning_amount = #{beginning_amount},	"+
					"	transaction_type = #{transaction_type},	"+
					"	amount = #{amount},	"+
					"	ending_amount = #{ending_amount}	"+
					"	WHERE credit_id = #{credit_id}	";
	@Update(UPDATE_USER_CREDIT_HISTORY)
	public boolean updateUserCreditHistory(UserCreditHistoryInputUpdate uch);
	
	final String DELETE_USER_CREDIT_HISTORY="DELETE FROM auc_user_credit_history WHERE credit_id = #{credit_id}";
	@Delete(DELETE_USER_CREDIT_HISTORY)
	public boolean deleteUserCreditHistory(int credit_id);	

}

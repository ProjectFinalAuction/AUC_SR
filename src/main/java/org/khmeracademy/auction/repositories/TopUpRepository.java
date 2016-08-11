package org.khmeracademy.auction.repositories;

import java.sql.Date;
import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.khmeracademy.auction.entities.TopUp;
import org.khmeracademy.auction.entities.TopUpInputUpdate;
import org.springframework.stereotype.Repository;

@Repository
public interface TopUpRepository {
	final String FIND_ALL_TOP_UP="SELECT * FROM v_find_all_top_up";
	@Select(FIND_ALL_TOP_UP)
	public ArrayList<TopUp> findAllTopUp();
	
	final String FIND_TOP_UP_BY_CURRENCY="SELECT * FROM v_find_all_top_up WHERE currency = #{currency}";
	@Select(FIND_TOP_UP_BY_CURRENCY)
	public ArrayList<TopUp> findTopUpByCurrency(String currency);

	final String FIND_TOP_UP_BY_USER_NAME=
						"	SELECT * FROM v_find_all_top_up WHERE user_name = #{user_name}	";
	@Select(FIND_TOP_UP_BY_USER_NAME)
	public ArrayList<TopUp> findTopUpByUserName(String user_name);

	final String FIND_TOP_UP_BY_DATE="SELECT * FROM v_find_all_top_up WHERE top_up_date = #{top_up_date}";
	@Select(FIND_TOP_UP_BY_DATE)
	public ArrayList<TopUp> findTopUpByDate(Date top_up_date);
	
	final String ADD_TOP_UP=
			" INSERT INTO auc_top_up(user_id,currency,amount,top_up_date,payment_method_id) "+
			" VALUES(#{user_id},#{currency},#{amount},#{top_up_date},#{payment_method_id}) ";
	@Insert(ADD_TOP_UP)
	public boolean addTopUp(TopUpInputUpdate t);
	
	final String UPDATE_TOP_UP=
					"	UPDATE auc_top_up	"+
					"	SET user_id = #{ user_id }, 	"+
					"	currency = #{ currency }, 	"+
					"	amount = #{ amount }, 	"+
					"	top_up_date = #{ top_up_date }, 	"+
					"	payment_method_id = #{ payment_method_id }	"+
					"	WHERE	"+
					"	top_up_id = #{ top_up_id }	";
	@Update(UPDATE_TOP_UP)
	public boolean updateTopUp(TopUpInputUpdate t);
	
	final String DELETE_TOP_UP="DELETE FROM auc_top_up WHERE top_up_id = #{top_up_id}";
	@Delete(DELETE_TOP_UP)
	public boolean deleteTopUp(int top_up_id);

	
}

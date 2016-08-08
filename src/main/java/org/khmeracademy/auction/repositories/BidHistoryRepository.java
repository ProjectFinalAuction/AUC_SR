package org.khmeracademy.auction.repositories;

import java.sql.Date;
import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.khmeracademy.auction.entities.BidHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface BidHistoryRepository {
	final String FIND_ALL_BID_HISTORY = "SELECT * FROM auc_bid_history";
	@Select(FIND_ALL_BID_HISTORY)
	public ArrayList<BidHistory> findAllBidHistory();

	final String FIND_BID_HISTORY_BY_AUCTION_ID="SELECT * FROM auc_bid_history WHERE auction_id = #{auction_id}";
	@Select(FIND_BID_HISTORY_BY_AUCTION_ID)
	public ArrayList<BidHistory> findBidHistoryByAuctionId(int auction_id);
	
	final String FIND_BID_HISTORY_BY_USER_NAME=
					"	SELECT "+
					"	b.bid_id, "+
					"	b.auction_id, "+
					"	b.user_id, "+
					"	b.current_price, "+
					"	b.bid_date "+
					"	FROM "+
					"	auc_bid_history b "+
					"	INNER JOIN auc_user u ON u.user_id = b.user_id "+
					"	WHERE	 "+
					"	u.user_name = #{user_name} ";
	@Select(FIND_BID_HISTORY_BY_USER_NAME)
	public ArrayList<BidHistory> findBidHistoryByUserName(String user_name);

	final String FIND_BID_HISTORY_BY_DATE="SELECT * FROM auc_bid_history WHERE bid_date = #{bid_date}";
	@Select(FIND_BID_HISTORY_BY_DATE)
	public ArrayList<BidHistory> findBidHistoryByDate(Date bid_date);

	final String ADD_BID_HISTORY="INSERT INTO auc_bid_history(auction_id,user_id,current_price,bid_date) "+
								"VALUES(#{auction_id},#{user_id},#{current_price},#{bid_date})";
	@Insert(ADD_BID_HISTORY)
	public boolean addBidHistory(BidHistory b);
	
	final String UPDATE_BID_HISTORY=
					"	UPDATE auc_bid_history	 "+
					"	SET auction_id = #{auction_id},	 "+
					"	user_id = #{user_id},	 "+
					"	current_price = #{current_price},	 "+
					"	bid_date=#{bid_date}	 "+
					"	WHERE bid_id = #{bid_id}	 ";
	@Update(UPDATE_BID_HISTORY)
	public boolean updateBidHistory(BidHistory b);


	final String DELETE_BID_HISTORY="DELETE FROM auc_bid_history WHERE bid_id = #{bid_id}";
	@Delete(DELETE_BID_HISTORY)
	public boolean deleteBidHistory(int bid_id);	

}

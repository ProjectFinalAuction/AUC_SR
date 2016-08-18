package org.khmeracademy.auction.repositories;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.khmeracademy.auction.entities.Auction;
import org.khmeracademy.auction.entities.BidHistory;
import org.khmeracademy.auction.entities.BidHistoryInputUpdate;
import org.springframework.stereotype.Repository;

@Repository
public interface BidHistoryRepository {
	final String FIND_ALL_BID_HISTORY = "SELECT * FROM v_find_all_bid_history";
	@Select(FIND_ALL_BID_HISTORY)
	@Results(value={
			// user
			@Result(property="user.user_id", column="user_id"),
			@Result(property="user.user_name", column="user_name"),
			@Result(property="user.first_name", column="first_name"),
			@Result(property="user.last_name", column="last_name"),			
			@Result(property="user.gender", column="gender"),
			@Result(property="user.dob", column="dob"),
			@Result(property="user.email", column="email"),
			@Result(property="user.photo", column="photo"),
			@Result(property="user.type", column="type"),
			@Result(property="user.status", column="status"),
			
			// auction
			@Result(property="auction.auction_id", column="auction_id"),
			@Result(property="auction.product.product_id", column="product_id"),
			@Result(property="auction.product_condition", column="product_condition"),
			@Result(property="auction.start_price", column="start_price"),
			@Result(property="auction.buy_price", column="buy_price"),
			@Result(property="auction.increment_price", column="increment_price"),
			@Result(property="auction.current_price", column="auction_current_price"),
			@Result(property="auction.start_date", column="start_date"),
			@Result(property="auction.end_date", column="end_date"),
			
			// product
			@Result(property="auction.product.product_name", column="product_name"),
			@Result(property="auction.product.product_description", column="product_description")
						
	})
	public ArrayList<BidHistory> findAllBidHistory();

	final String FIND_BID_HISTORY_BY_AUCTION_ID="SELECT * FROM v_find_all_bid_history WHERE auction_id = #{auction_id}";
	@Select(FIND_BID_HISTORY_BY_AUCTION_ID)
	@Results(value={
			// user
			@Result(property="user.user_id", column="user_id"),
			@Result(property="user.user_name", column="user_name"),
			@Result(property="user.first_name", column="first_name"),
			@Result(property="user.last_name", column="last_name"),			
			@Result(property="user.gender", column="gender"),
			@Result(property="user.dob", column="dob"),
			@Result(property="user.email", column="email"),
			@Result(property="user.photo", column="photo"),
			@Result(property="user.type", column="type"),
			@Result(property="user.status", column="status"),
			
			// auction
			@Result(property="auction.auction_id", column="auction_id"),
			@Result(property="auction.product.product_id", column="product_id"),
			@Result(property="auction.product_condition", column="product_condition"),
			@Result(property="auction.start_price", column="start_price"),
			@Result(property="auction.buy_price", column="buy_price"),
			@Result(property="auction.increment_price", column="increment_price"),
			@Result(property="auction.current_price", column="auction_current_price"),
			@Result(property="auction.start_date", column="start_date"),
			@Result(property="auction.end_date", column="end_date"),
			
			// product
			@Result(property="auction.product.product_name", column="product_name"),
			@Result(property="auction.product.product_description", column="product_description")
						
	})
	public ArrayList<BidHistory> findBidHistoryByAuctionId(int auction_id);
	
	final String FIND_BID_HISTORY_BY_USER_NAME="SELECT * FROM v_find_all_bid_history WHERE u.user_name = #{user_name} ";
	@Select(FIND_BID_HISTORY_BY_USER_NAME)
	@Results(value={
			// user
			@Result(property="user.user_id", column="user_id"),
			@Result(property="user.user_name", column="user_name"),
			@Result(property="user.first_name", column="first_name"),
			@Result(property="user.last_name", column="last_name"),			
			@Result(property="user.gender", column="gender"),
			@Result(property="user.dob", column="dob"),
			@Result(property="user.email", column="email"),
			@Result(property="user.photo", column="photo"),
			@Result(property="user.type", column="type"),
			@Result(property="user.status", column="status"),
			
			// auction
			@Result(property="auction.auction_id", column="auction_id"),
			@Result(property="auction.product.product_id", column="product_id"),
			@Result(property="auction.product_condition", column="product_condition"),
			@Result(property="auction.start_price", column="start_price"),
			@Result(property="auction.buy_price", column="buy_price"),
			@Result(property="auction.increment_price", column="increment_price"),
			@Result(property="auction.current_price", column="auction_current_price"),
			@Result(property="auction.start_date", column="start_date"),
			@Result(property="auction.end_date", column="end_date"),
			
			// product
			@Result(property="auction.product.product_name", column="product_name"),
			@Result(property="auction.product.product_description", column="product_description")
						
	})
	public ArrayList<BidHistory> findBidHistoryByUserName(String user_name);

	final String FIND_BID_HISTORY_BY_DATE="SELECT * FROM v_find_all_bid_history WHERE bid_date::TEXT = #{bid_date}";
	@Select(FIND_BID_HISTORY_BY_DATE)
	@Results(value={
			// user
			@Result(property="user.user_id", column="user_id"),
			@Result(property="user.user_name", column="user_name"),
			@Result(property="user.first_name", column="first_name"),
			@Result(property="user.last_name", column="last_name"),			
			@Result(property="user.gender", column="gender"),
			@Result(property="user.dob", column="dob"),
			@Result(property="user.email", column="email"),
			@Result(property="user.photo", column="photo"),
			@Result(property="user.type", column="type"),
			@Result(property="user.status", column="status"),
			
			// auction
			@Result(property="auction.auction_id", column="auction_id"),
			@Result(property="auction.product.product_id", column="product_id"),
			@Result(property="auction.product_condition", column="product_condition"),
			@Result(property="auction.start_price", column="start_price"),
			@Result(property="auction.buy_price", column="buy_price"),
			@Result(property="auction.increment_price", column="increment_price"),
			@Result(property="auction.current_price", column="auction_current_price"),
			@Result(property="auction.start_date", column="start_date"),
			@Result(property="auction.end_date", column="end_date"),
			
			// product
			@Result(property="auction.product.product_name", column="product_name"),
			@Result(property="auction.product.product_description", column="product_description")
						
	})
	public ArrayList<BidHistory> findBidHistoryByDate(String bid_date);

	final String ADD_BID_HISTORY="INSERT INTO auc_bid_history(auction_id,user_id,current_price,bid_date) "+
								"VALUES(#{auction_id},#{user_id},#{current_price},#{bid_date})";
	@Insert(ADD_BID_HISTORY)
	public boolean addBidHistory(BidHistoryInputUpdate b);
	
	final String UPDATE_BID_HISTORY=
					"	UPDATE auc_bid_history	 "+
					"	SET auction_id = #{auction_id},	 "+
					"	user_id = #{user_id},	 "+
					"	current_price = #{current_price},	 "+
					"	bid_date=#{bid_date}	 "+
					"	WHERE bid_id = #{bid_id}	 ";
	@Update(UPDATE_BID_HISTORY)
	public boolean updateBidHistory(BidHistoryInputUpdate b);


	final String DELETE_BID_HISTORY="DELETE FROM auc_bid_history WHERE bid_id = #{bid_id}";
	@Delete(DELETE_BID_HISTORY)
	public boolean deleteBidHistory(int bid_id);	

	
	

	//==== Additional functions
	final String FIND_BID_WINNER = "select * from pr_find_bid_winner(#{auction_id})";
	@Select(FIND_BID_WINNER)
	@Results(value={
			// auction
			@Result(property="auction.auction_id", column="auction_id"),
			@Result(property="auction.product_condition", column="product_condition"),
			@Result(property="auction.start_price", column="start_price"),
			@Result(property="auction.buy_price", column="buy_price"),
			@Result(property="auction.increment_price", column="increment_price"),
			@Result(property="auction.current_price", column="auction_current_price"),
			@Result(property="auction.start_date", column="start_date"),
			@Result(property="auction.end_date", column="end_date"),
			@Result(property="auction.status", column="auction_status"),
			
			// product
			@Result(property="auction.product.product_id", column="product_id"),
			@Result(property="auction.product.product_description", column="product_description"),
			@Result(property="auction.product.qty", column="qty"),
			@Result(property="auction.product.status", column="product_status"),
			
			// user
			@Result(property="user.user_id", column="user_id"),
			@Result(property="user.user_name", column="user_name"),
			@Result(property="user.first_name", column="first_name"),
			@Result(property="user.last_name", column="last_name"),
			@Result(property="user.gender", column="gender"),
			@Result(property="user.dob", column="dob"),
			@Result(property="user.address", column="address"),
			@Result(property="user.email", column="email"),
			@Result(property="user.contact", column="contact"),
			@Result(property="user.photo", column="photo"),
			@Result(property="user.type", column="type"),
			@Result(property="user.status", column="user_status"),
			
			// category
			@Result(property="auction.product.category.category_id", column="category_id"),
			@Result(property="auction.product.category.category_name", column="category_name"),
			@Result(property="auction.product.category.category_description", column="category_description"),
			
			// supplier
			@Result(property="auction.product.supplier.supplier_id", column="supplier_id"),
			@Result(property="auction.product.supplier.contact_name", column="contact_name"),
			@Result(property="auction.product.supplier.address", column="supplier_address"),
			@Result(property="auction.product.supplier.email", column="supplier_email"),
			@Result(property="auction.product.supplier.phone", column="supplier_phone"),
			
			// brand
			@Result(property="auction.product.brand.brand_id", column="brand_id"),
			@Result(property="auction.product.brand.brand_name", column="brand_name"),
			@Result(property="auction.product.brand.brand_description", column="brand_description"),
			@Result(property="auction.product.brand.status", column="brand_status")
	})
		
	public BidHistory findBidWinner(int auction_id);
}

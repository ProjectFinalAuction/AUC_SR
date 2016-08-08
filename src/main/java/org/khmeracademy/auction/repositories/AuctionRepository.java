package org.khmeracademy.auction.repositories;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.khmeracademy.auction.entities.Auction;
import org.springframework.stereotype.Repository;

@Repository
public interface AuctionRepository {
	final String FIND_ALL_AUCTIONS = "SELECT * FROM auc_auction";
	@Select(FIND_ALL_AUCTIONS)
	public ArrayList<Auction> findAllAuctions();
	
	final String FIND_AUCTION_BY_PRODUCT_NAME = 
			" SELECT A .* " + 
			" FROM auc_auction A INNER JOIN auc_product P ON P .product_id = A .product_id "+
			" WHERE P .product_name = #{product_name}";
	@Select(FIND_AUCTION_BY_PRODUCT_NAME)
	public ArrayList<Auction> findAuctionByProductName(String product_name);
	
	final String FIND_AUCTION_BY_DATE= "SELECT * FROM auc_auction WHERE start_date = #{trans_date} OR end_date = #{trans_date}";
	@Select(FIND_AUCTION_BY_DATE)
	public ArrayList<Auction> findAuctionByDate(String trans_date);
	
	
	final String ADD_AUCTION= 
					"	INSERT INTO auc_auction(	"+
					"	product_id,	"+
					"	product_condition,	"+
					"	start_price,	"+
					"	buy_price,	"+
					"	increment_price,	"+
					"	current_price,	"+
					"	start_date,	"+
					"	end_date,	"+
					"	status,	"+
					"	created_by,	"+
					"	created_date,	"+
					"	comment)	"+
					"	VALUES (	"+
					"	#{product_id},	"+
					"	#{product_condition},	"+
					"	#{start_price},	"+
					"	#{buy_price},	"+
					"	#{increment_price},	"+
					"	#{current_price},	"+
					"	#{start_date},	"+
					"	#{end_date},	"+
					"	#{status},	"+
					"	#{created_by},	"+
					"	#{created_date},	"+
					"	#{comment}	"+
					"	)	";
	@Insert(ADD_AUCTION)
	public boolean addAuction(Auction a);	
	
	
	final String UPDATE_AUCTION= 
					"	UPDATE auc_auction	"+
					"	SET product_id = #{product_id},	"+
					"	product_condition = #{product_condition},	"+
					"	start_price = #{start_price},	"+
					"	buy_price = #{buy_price},	"+
					"	increment_price = #{increment_price},	"+
					"	current_price = #{current_price},	"+
					"	start_date = #{start_date},	"+
					"	end_date = #{end_date},	"+
					"	status = #{status},	"+
					"	comment = #{comment}	"+
					"	WHERE auction_id = #{auction_id}	";
	public boolean updateAuction(Auction a);

	final String DELETE_AUCTION= "UPDATE auc_auction SET status = false WHERE auction_id = #{auction_id}";
	public boolean deleteAuction(int auction_id);	

}

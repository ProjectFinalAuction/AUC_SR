package org.khmeracademy.auction.repositories;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.khmeracademy.auction.entities.Auction;
import org.springframework.stereotype.Repository;

@Repository
public interface AuctionRepository {
	final String FIND_ALL_AUCTIONS = "SELECT a.*, p.product_name, p.product_description, p.status, b.brand_name, b.brand_description, "
			+ "b.status, c.category_description, c.status, c.category_name, s.contact_name, s.address, s.phone, s.email "
			+ "FROM "
			+ "auc_auction a" 
			+ "inner join auc_product p "
			+ "on a.product_id=p.product_id inner join auc_supplier s on s.supplier_id=p.supplier_id "
			+ "inner join auc_brand b on b.brand_id=p.brand_id "
			+ "inner join auc_category c on c.category_id=p.category_id";
	@Select(FIND_ALL_AUCTIONS)
	@Results(value={
			@Result(property="product.product_id", column="product_id"),
			@Result(property="product.product_name", column="product_name"),
			@Result(property="product.product_description", column="product_description"),
			@Result(property="product.status", column="status"),
			@Result(property="product.status", column="status"),
	})
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

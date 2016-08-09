package org.khmeracademy.auction.repositories;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.khmeracademy.auction.entities.Auction;
import org.khmeracademy.auction.entities.AuctionInputUpdate;
import org.springframework.stereotype.Repository;

@Repository
public interface AuctionRepository {
	final String FIND_ALL_AUCTIONS = "SELECT * FROM v_find_all_auctions ";
	@Select(FIND_ALL_AUCTIONS)
	@Results(value={
			// Product
			@Result(property="product.product_id", column="product_id"),
			@Result(property="product.product_name", column="product_name"),
			@Result(property="product.product_description", column="product_description"),
			@Result(property="product.status", column="product_status"),
			
			// Brand
			@Result(property="brand.brand_id", column="brand_id"),
			@Result(property="brand.brand_name", column="brand_name"),
			@Result(property="brand.brand_description", column="brand_description"),
			@Result(property="brand.status", column="brand_status"),
			
			//Category
			@Result(property="category.category_id", column="category_id"),
			@Result(property="category.category_name", column="category_name"),
			@Result(property="category.category_description", column="category_description"),
			
			//Supplier
			@Result(property="supplier.supplier_id", column="supplier_id"),
			@Result(property="supplier.contact_name", column="contact_name"),
			@Result(property="supplier.address", column="address"),
			@Result(property="supplier.phone", column="phone"),
			@Result(property="supplier.email", column="email")
			
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
					"	SELECT pr_add_auction (	"+
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
	public boolean addAuction(AuctionInputUpdate a);	
	
	
	final String UPDATE_AUCTION= 
					"	SELECT pr_update_auction (	"+
					"	#{product_id},	"+
					"	#{product_condition},	"+
					"	#{start_price},	"+
					"	#{buy_price},	"+
					"	#{increment_price},	"+
					"	#{current_price},	"+
					"	#{start_date},	"+
					"	#{end_date},	"+
					"	#{status},	"+
					"	#{comment}	)";
					
	public boolean updateAuction(AuctionInputUpdate a);

	final String DELETE_AUCTION= "UPDATE auc_auction SET status = false WHERE auction_id = #{auction_id}";
	public boolean deleteAuction(int auction_id);	

}

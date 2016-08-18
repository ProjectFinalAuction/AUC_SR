package org.khmeracademy.auction.repositories;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.khmeracademy.auction.entities.Auction;
import org.khmeracademy.auction.entities.AuctionInputUpdate;
import org.khmeracademy.auction.entities.BiddingAuction;
import org.khmeracademy.auction.filtering.AuctionFilter;
import org.khmeracademy.auction.utils.Pagination;
import org.springframework.stereotype.Repository;

@Repository
public interface AuctionRepository {
	final String FIND_ALL_AUCTIONS = "SELECT * "
								   + "FROM v_find_all_auctions "
								   + "WHERE LOWER(product_name) LIKE LOWER('%' || #{filter.productName} || '%')"
								   + "ORDER BY auction_id DESC "
								   + "LIMIT #{pagination.limit} "
								   + "OFFSET #{pagination.offset} ";

	@Select(FIND_ALL_AUCTIONS)
	@Results(value = {
			// Product
			@Result(property = "product.product_id", column = "product_id"),
			@Result(property = "product.product_name", column = "product_name"),
			@Result(property = "product.product_description", column = "product_description"),
			@Result(property = "product.status", column = "product_status"),

			// Brand
			@Result(property = "product.brand.brand_id", column = "brand_id"),
			@Result(property = "product.brand.brand_name", column = "brand_name"),
			@Result(property = "product.brand.brand_description", column = "brand_description"),
			@Result(property = "product.brand.status", column = "brand_status"),

			// Category
			@Result(property = "product.category.category_id", column = "category_id"),
			@Result(property = "product.category.category_name", column = "category_name"),
			@Result(property = "product.category.category_description", column = "category_description"),

			// Supplier
			@Result(property = "product.supplier.supplier_id", column = "supplier_id"),
			@Result(property = "product.supplier.contact_name", column = "contact_name"),
			@Result(property = "product.supplier.address", column = "address"),
			@Result(property = "product.supplier.phone", column = "phone"),
			@Result(property = "product.supplier.email", column = "email")

	})
	public ArrayList<Auction> findAllAuctions(@Param("filter") AuctionFilter filter, @Param("pagination") Pagination pagination);

	final String FIND_AUCTION_BY_ID = " SELECT * FROM v_find_all_auctions WHERE auction_id = #{auction_id}";

	@Select(FIND_AUCTION_BY_ID)
	@Results(value = {
			// Product
			@Result(property = "product.product_id", column = "product_id"),
			@Result(property = "product.product_name", column = "product_name"),
			@Result(property = "product.product_description", column = "product_description"),
			@Result(property = "product.status", column = "product_status"),

			// Brand
			@Result(property = "product.brand.brand_id", column = "brand_id"),
			@Result(property = "product.brand.brand_name", column = "brand_name"),
			@Result(property = "product.brand.brand_description", column = "brand_description"),
			@Result(property = "product.brand.status", column = "brand_status"),

			// Category
			@Result(property = "product.category.category_id", column = "category_id"),
			@Result(property = "product.category.category_name", column = "category_name"),
			@Result(property = "product.category.category_description", column = "category_description"),

			// Supplier
			@Result(property = "product.supplier.supplier_id", column = "supplier_id"),
			@Result(property = "product.supplier.contact_name", column = "contact_name"),
			@Result(property = "product.supplier.address", column = "address"),
			@Result(property = "product.supplier.phone", column = "phone"),
			@Result(property = "product.supplier.email", column = "email") })
	public Auction getAuctionByID(int id);

	final String FIND_AUCTION_BY_PRODUCT_NAME = " SELECT * FROM v_find_all_auctions WHERE product_name = #{product_name}";

	@Select(FIND_AUCTION_BY_PRODUCT_NAME)
	@Results(value = {
			// Product
			@Result(property = "product.product_id", column = "product_id"),
			@Result(property = "product.product_name", column = "product_name"),
			@Result(property = "product.product_description", column = "product_description"),
			@Result(property = "product.status", column = "product_status"),

			// Brand
			@Result(property = "product.brand.brand_id", column = "brand_id"),
			@Result(property = "product.brand.brand_name", column = "brand_name"),
			@Result(property = "product.brand.brand_description", column = "brand_description"),
			@Result(property = "product.brand.status", column = "brand_status"),

			// Category
			@Result(property = "product.category.category_id", column = "category_id"),
			@Result(property = "product.category.category_name", column = "category_name"),
			@Result(property = "product.category.category_description", column = "category_description"),

			// Supplier
			@Result(property = "product.supplier.supplier_id", column = "supplier_id"),
			@Result(property = "product.supplier.contact_name", column = "contact_name"),
			@Result(property = "product.supplier.address", column = "address"),
			@Result(property = "product.supplier.phone", column = "phone"),
			@Result(property = "product.supplier.email", column = "email")

	})
	public ArrayList<Auction> findAuctionByProductName(String product_name);

	final String FIND_AUCTION_BY_DATE = "SELECT * FROM v_find_all_auctions WHERE start_date:: TEXT = #{trans_date} OR end_date :: TEXT = #{trans_date}";

	@Select(FIND_AUCTION_BY_DATE)
	@Results(value = {
			// Product
			@Result(property = "product.product_id", column = "product_id"),
			@Result(property = "product.product_name", column = "product_name"),
			@Result(property = "product.product_description", column = "product_description"),
			@Result(property = "product.status", column = "product_status"),

			// Brand
			@Result(property = "product.brand.brand_id", column = "brand_id"),
			@Result(property = "product.brand.brand_name", column = "brand_name"),
			@Result(property = "product.brand.brand_description", column = "brand_description"),
			@Result(property = "product.brand.status", column = "brand_status"),

			// Category
			@Result(property = "product.category.category_id", column = "category_id"),
			@Result(property = "product.category.category_name", column = "category_name"),
			@Result(property = "product.category.category_description", column = "category_description"),

			// Supplier
			@Result(property = "product.supplier.supplier_id", column = "supplier_id"),
			@Result(property = "product.supplier.contact_name", column = "contact_name"),
			@Result(property = "product.supplier.address", column = "address"),
			@Result(property = "product.supplier.phone", column = "phone"),
			@Result(property = "product.supplier.email", column = "email")

	})
	public ArrayList<Auction> findAuctionByDate(String trans_date);
	
	final String FIND_AUCTION_PRODUCT_BY_CATEGORY="	SELECT * "+
//			"	auc_product.product_name,	"+
//			"	auc_product.product_description,	"+
//			"	auc_category.category_name,	"+
//			"	auc_category.status,	"+
//		
//			"	auc_category.category_description,	"+
//			"	auc_product.qty,	"+
//			"	auc_brand.brand_name,	"+
//			"	auc_supplier.contact_name	"+
			"	FROM	"+
			"	((auc_auction AS au	"+
			"	JOIN auc_product ON ((auc_product.product_id = au.product_id)))	"+
			"	JOIN auc_category ON ((auc_category.category_id = auc_product.category_id)))	"+
			"	INNER JOIN auc_brand ON auc_brand.brand_id = auc_product.brand_id	"+
			"	INNER JOIN auc_supplier ON auc_supplier.supplier_id = auc_product.supplier_id	"+
			"	WHERE	"+
			"	(auc_category.category_id = #{category_id})	";

	@Select(FIND_AUCTION_PRODUCT_BY_CATEGORY)
	@Results(value={
			
			@Result(property = "product.product_name", column = "product_name"),
			@Result(property = "product.product_description", column = "product_description"),
			
			@Result(property = "product.category.category_name", column = "category_name"),
			@Result(property = "product.category.status", column = "status"),
		
			@Result(property = "product.category.category_description", column = "category_description"),
			
			@Result(property = "product.qty", column = "qty"),
			@Result(property = "product.brand.brand_name", column = "brand_name"),
			@Result(property = "product.supplier.contact_name", column = "contact_name")
	})
	public ArrayList<Auction> findAuctionProductByCategory(int category_id);
	
	final String ADD_AUCTION = "	INSERT INTO auc_auction(	" + "	product_id,	" + "	product_condition,	"
			+ "	start_price,	" + "	buy_price,	" + "	increment_price,	" + "	current_price,	"
			+ "	start_date,	" + "	end_date,	" + "	status,	" + "	created_by,	" + "	created_date,	"
			+ "	comment)	" + "	VALUES (	" + "	#{product_id},	" + "	#{product_condition},	"
			+ "	#{start_price},	" + "	#{buy_price},	" + "	#{increment_price},	" + "	#{current_price},	"
			+ "	#{start_date},	" + "	#{end_date},	" + "	#{status},	" + "	#{created_by},	"
			+ "	#{created_date},	" + "	#{comment}	" + "	)	";

	@Insert(ADD_AUCTION)
	public boolean addAuction(AuctionInputUpdate a);

	final String UPDATE_AUCTION = "	UPDATE auc_auction	" + "	SET product_id = #{product_id},	"
			+ "	product_condition = #{product_condition},	" + "	start_price = #{start_price},	"
			+ "	buy_price = #{buy_price},	" + "	increment_price = #{increment_price},	"
			+ "	current_price = #{current_price},	" + "	start_date = #{start_date},	"
			+ "	end_date = #{end_date},	" + "	status = #{status},	" + "	comment = #{comment}	"
			+ "	WHERE auction_id = #{auction_id}	";

	@Update(UPDATE_AUCTION)
	public boolean updateAuction(AuctionInputUpdate a);

	final String DELETE_AUCTION = "UPDATE auc_auction SET status = false WHERE auction_id = #{auction_id}";

	@Delete(DELETE_AUCTION)
	public boolean deleteAuction(int auction_id);
	
	@Select("SELECT COUNT(auction_id) FROM v_find_all_auctions WHERE LOWER(product_name) LIKE LOWER('%' || #{filter.productName} || '%')")
	public Long count(@Param("filter") AuctionFilter filter);
	
	// ==== Additional function

		final String FIND_BIDDING_AUCTION_BY_AUCTION_ID = "SELECT * FROM v_auction_and_bid where auction_id=#{auction_id}";
				

		@Select(FIND_ALL_AUCTIONS)
		@Results(value = {
				// Product
				@Result(property = "product.product_id", column = "product_id"),
				@Result(property = "product.product_name", column = "product_name"),
				@Result(property = "product.product_description", column = "product_description"),
				@Result(property = "product.status", column = "product_status"),

				// Brand
				@Result(property = "product.brand.brand_id", column = "brand_id"),
				@Result(property = "product.brand.brand_name", column = "brand_name"),
				@Result(property = "product.brand.brand_description", column = "brand_description"),
				@Result(property = "product.brand.status", column = "brand_status"),

				// Category
				@Result(property = "product.category.category_id", column = "category_id"),
				@Result(property = "product.category.category_name", column = "category_name"),
				@Result(property = "product.category.category_description", column = "category_description"),

				// Supplier
				@Result(property = "product.supplier.supplier_id", column = "supplier_id"),
				@Result(property = "product.supplier.contact_name", column = "contact_name"),
				@Result(property = "product.supplier.address", column = "address"),
				@Result(property = "product.supplier.phone", column = "phone"),
				@Result(property = "product.supplier.email", column = "email")
				
				// num_bid and bid_current_parent are matched automatically

		})
		public BiddingAuction findBiddingAuctionByAuctionId(int auction_id);


}

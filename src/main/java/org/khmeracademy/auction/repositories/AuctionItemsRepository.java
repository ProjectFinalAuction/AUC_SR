package org.khmeracademy.auction.repositories;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.khmeracademy.auction.entities.AuctionItems;
import org.springframework.stereotype.Repository;

@Repository
public interface AuctionItemsRepository {
	String R_AUCTION_ITEMS = "SELECT * FROM auc_auction_items";
	String C_AUCTION_ITEM = "INSERT INTO auc_auction_items("
			+ "	user_id,"
			+ "	auction_item_description,"
			+ "	auction_start_date,"
			+ "	auction_actual_close_date,"
			+ "	auction_planned_close_date,"
			+ "	auction_item_actual_selling_price,"
			+ "	auction_item_reserve_price,"
			+ "	auction_itme_payment_amount,"
			+ "	auction_item_payment_date,"
			+ "	auction_item_sucessful_bidder,"
			+ "	auction_item_comments,"
			+ "	auction_item_image,"
			+ "	auction_item_is_deleted)"
			+ "VALUES("
			+ "	#{user_id},"
			+ "	#{auction_item_description},"
			+ "	#{auction_start_date},"
			+ "	#{auction_actual_close_date},"
			+ "	#{auction_planned_close_date},"
			+ "	#{auction_item_actual_selling_price},"
			+ "	#{auction_item_reserve_price},"
			+ "	#{auction_itme_payment_amount},"
			+ "	#{auction_item_payment_date},"
			+ "	#{auction_item_sucessful_bidder},"
			+ "	#{auction_item_comments},"
			+ "	#{auction_item_image},"
			+ "	#{auction_item_is_deleted})";
	String D_AUCTION_ITEM = "UPDATE auc_auction_items SET"
			+ " auction_item_is_deleted = 1";
	String U_AUCTION_ITEM = "UPDATE auc_auction_items SET"
			+ "	auction_item_description = #{auction_item_description},"
			+ " auction_start_date = #{auction_start_date},"
			+ "	auction_actual_close_date = #{auction_actual_close_date},"
			+ "	auction_planned_close_date = #{auction_planned_close_date},"
			+ "	auction_item_actual_selling_price = #{auction_item_actual_selling_price},"
			+ "	auction_item_reserve_price = #{auction_item_reserve_price}"
			+ "	auction_itme_payment_amount = #{auction_itme_payment_amount},"
			+ "	auction_item_payment_date = #{auction_item_payment_date},"
			+ "	auction_item_sucessful_bidder = #{auction_item_sucessful_bidder},"
			+ "	auction_item_comments = #{auction_item_comments}"
			+ "	auction_item_image = #{auction_item_image},"
			+ "	auction_item_is_deleted = #{auction_item_is_deleted}"
			+ "WHERE user_id = #{user_id}";
	
	@Select(R_AUCTION_ITEMS)
	public ArrayList<AuctionItems> getAllAuctionItems();
	
	@Insert(C_AUCTION_ITEM)
	public boolean addAuctionItem(AuctionItems auctionItem);
	
	@Delete(D_AUCTION_ITEM)
	public boolean deleteActionItem(AuctionItems auctionItem);
	
	@Update(U_AUCTION_ITEM)
	public boolean updateActionItem(AuctionItems aucitonItem);
}

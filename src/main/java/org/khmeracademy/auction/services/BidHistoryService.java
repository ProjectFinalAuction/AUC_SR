package org.khmeracademy.auction.services;

import java.sql.Date;
import java.util.ArrayList;

import org.khmeracademy.auction.entities.BidHistory;

public interface BidHistoryService {
	public ArrayList<BidHistory> findAllBidHistory();
	public ArrayList<BidHistory> findBidHistoryByAuctionId(int auction_id);
	public ArrayList<BidHistory> findBidHistoryByUserName(String user_name);
	public ArrayList<BidHistory> findBidHistoryByDate(Date bid_date);
	public boolean addBidHistory(BidHistory b);
	public boolean updateBidHistory(BidHistory b);
	public boolean deleteBidHistory(int bid_id);
}

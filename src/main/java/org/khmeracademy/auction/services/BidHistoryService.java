package org.khmeracademy.auction.services;


import java.util.ArrayList;

import org.khmeracademy.auction.entities.BidHistory;
import org.khmeracademy.auction.entities.BidHistoryInputUpdate;

public interface BidHistoryService {
	public ArrayList<BidHistory> findAllBidHistory();
	public ArrayList<BidHistory> findBidHistoryByAuctionId(int auction_id);
	public ArrayList<BidHistory> findBidHistoryByUserName(String user_name);
	public ArrayList<BidHistory> findBidHistoryByDate(String bid_date);
	public boolean addBidHistory(BidHistoryInputUpdate b);
	public boolean updateBidHistory(BidHistoryInputUpdate b);
	public boolean deleteBidHistory(int bid_id);
	public BidHistory findBidWinner(int auction_id);
}

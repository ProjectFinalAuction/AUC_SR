package org.khmeracademy.auction.services.impl;


import java.sql.Date;
import java.util.ArrayList;

import org.khmeracademy.auction.entities.BidHistory;
import org.khmeracademy.auction.entities.BidHistoryInputUpdate;
import org.khmeracademy.auction.entities.BidHistoryWithFirstProductImage;
import org.khmeracademy.auction.entities.BiddingAuction;
import org.khmeracademy.auction.repositories.BidHistoryRepository;
import org.khmeracademy.auction.services.BidHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BidHistoryServiceImpl implements BidHistoryService{
	@Autowired
	private BidHistoryRepository bidHistoryRepository;

	@Override
	public ArrayList<BidHistory> findAllBidHistory() {
		return bidHistoryRepository.findAllBidHistory();
	}

	@Override
	public ArrayList<BidHistory> findBidHistoryByAuctionId(int auction_id) {
		return bidHistoryRepository.findBidHistoryByAuctionId(auction_id);
	}

	@Override
	public ArrayList<BidHistory> findBidHistoryByUserName(String user_name) {
		return bidHistoryRepository.findBidHistoryByUserName(user_name);
	}

	@Override
	public ArrayList<BidHistory> findBidHistoryByDate(String bid_date) {
		return bidHistoryRepository.findBidHistoryByDate(bid_date);
	}

	@Override
	public boolean addBidHistory(BidHistoryInputUpdate b) {
		return bidHistoryRepository.addBidHistory(b);
	}

	@Override
	public boolean updateBidHistory(BidHistoryInputUpdate b) {
		return bidHistoryRepository.updateBidHistory(b);
	}

	@Override
	public boolean deleteBidHistory(int bid_id) {
		return bidHistoryRepository.deleteBidHistory(bid_id);
	}

	@Override
	public ArrayList<BidHistory> findAllBidWinner() {
		return bidHistoryRepository.findAllBidWinner();
	}
	
	

	@Override
	public ArrayList<BidHistory> findAllBidWinnerRealTime() {
		// TODO Auto-generated method stub
		return bidHistoryRepository.findAllBidWinnerRealTime();
	}

	@Override
	public ArrayList<BidHistoryWithFirstProductImage> findBidHistoryAndImageByUserName(String user_name) {
		// TODO Auto-generated method stub
		return bidHistoryRepository.findBidHistoryAndImageByUserName(user_name);
	}
	
	
	
}

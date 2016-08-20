package org.khmeracademy.auction.entities;

import java.sql.Date;

public class BidHistory {
	private int bid_id;
	private Auction auction;  // Auction Object
	private User user;		  // User Object
	private double current_price;
	private Date bid_date;
	public int getBid_id() {
		return bid_id;
	}
	public void setBid_id(int bid_id) {
		this.bid_id = bid_id;
	}
	public Auction getAuction() {
		return auction;
	}
	public void setAuction(Auction auction) {
		this.auction = auction;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public double getCurrent_price() {
		return current_price;
	}
	public void setCurrent_price(double current_price) {
		this.current_price = current_price;
	}
	public Date getBid_date() {
		return bid_date;
	}
	public void setBid_date(Date bid_date) {
		this.bid_date = bid_date;
	}
	@Override
	public String toString() {
		return "BidHistory [bid_id=" + bid_id + ", auction=" + auction + ", user=" + user + ", current_price="
				+ current_price + ", bid_date=" + bid_date + "]";
	}
	
	
}

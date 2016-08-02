package org.khmeracademy.auction.entities;

public class AuctionItems {
	private int auction_item_id;
	private int user_id;
	private String auction_item_description;
	private String auction_start_date;
	private String auction_actual_close_date;
	private String auction_planned_close_date;
	private double auction_item_actual_selling_price;
	private double auction_item_reserve_price;
	private double auction_itme_payment_amount;
	private String auction_item_payment_date;
	private int auction_item_sucessful_bidder;
	private String auction_item_comments;
	private String auction_item_image;
	private int auction_item_is_deleted;
	
	public int getAuction_item_id() {
		return auction_item_id;
	}
	public void setAuction_item_id(int auction_item_id) {
		this.auction_item_id = auction_item_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getAuction_item_description() {
		return auction_item_description;
	}
	public void setAuction_item_description(String auction_item_description) {
		this.auction_item_description = auction_item_description;
	}
	public String getAuction_start_date() {
		return auction_start_date;
	}
	public void setAuction_start_date(String auction_start_date) {
		this.auction_start_date = auction_start_date;
	}
	public String getAuction_actual_close_date() {
		return auction_actual_close_date;
	}
	public void setAuction_actual_close_date(String auction_actual_close_date) {
		this.auction_actual_close_date = auction_actual_close_date;
	}
	public String getAuction_planned_close_date() {
		return auction_planned_close_date;
	}
	public void setAuction_planned_close_date(String auction_planned_close_date) {
		this.auction_planned_close_date = auction_planned_close_date;
	}
	public double getAuction_item_actual_selling_price() {
		return auction_item_actual_selling_price;
	}
	public void setAuction_item_actual_selling_price(double auction_item_actual_selling_price) {
		this.auction_item_actual_selling_price = auction_item_actual_selling_price;
	}
	public double getAuction_item_reserve_price() {
		return auction_item_reserve_price;
	}
	public void setAuction_item_reserve_price(double auction_item_reserve_price) {
		this.auction_item_reserve_price = auction_item_reserve_price;
	}
	public double getAuction_itme_payment_amount() {
		return auction_itme_payment_amount;
	}
	public void setAuction_itme_payment_amount(double auction_itme_payment_amount) {
		this.auction_itme_payment_amount = auction_itme_payment_amount;
	}
	public String getAuction_item_payment_date() {
		return auction_item_payment_date;
	}
	public void setAuction_item_payment_date(String auction_item_payment_date) {
		this.auction_item_payment_date = auction_item_payment_date;
	}
	public int getAuction_item_sucessful_bidder() {
		return auction_item_sucessful_bidder;
	}
	public void setAuction_item_sucessful_bidder(int auction_item_sucessful_bidder) {
		this.auction_item_sucessful_bidder = auction_item_sucessful_bidder;
	}
	public String getAuction_item_comments() {
		return auction_item_comments;
	}
	public void setAuction_item_comments(String auction_item_comments) {
		this.auction_item_comments = auction_item_comments;
	}
	public String getAuction_item_image() {
		return auction_item_image;
	}
	public void setAuction_item_image(String auction_item_image) {
		this.auction_item_image = auction_item_image;
	}
	public int getAuction_item_is_deleted() {
		return auction_item_is_deleted;
	}
	public void setAuction_item_is_deleted(int auction_item_is_deleted) {
		this.auction_item_is_deleted = auction_item_is_deleted;
	}
	
}

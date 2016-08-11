package org.khmeracademy.auction.entities;

import java.sql.Date;

public class UserCreditHistory {
	private int credit_id;
	private Date credit_date;
	private User user; // user object
	private double beginning_amount;
	private String transaction_type;
	private double amount;
	private double ending_amount;
	public int getCredit_id() {
		return credit_id;
	}
	public void setCredit_id(int credit_id) {
		this.credit_id = credit_id;
	}
	public Date getCredit_date() {
		return credit_date;
	}
	public void setCredit_date(Date credit_date) {
		this.credit_date = credit_date;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public double getBeginning_amount() {
		return beginning_amount;
	}
	public void setBeginning_amount(double beginning_amount) {
		this.beginning_amount = beginning_amount;
	}
	public String getTransaction_type() {
		return transaction_type;
	}
	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getEnding_amount() {
		return ending_amount;
	}
	public void setEnding_amount(double ending_amount) {
		this.ending_amount = ending_amount;
	}
	
	
	

}

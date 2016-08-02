package org.khmeracademy.auction.entities;

public class Categories {
	private int category_id;
	private String category_name;
	private int is_sub_of_category;
	
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public int getIs_sub_of_category() {
		return is_sub_of_category;
	}
	public void setIs_sub_of_category(int is_sub_of_category) {
		this.is_sub_of_category = is_sub_of_category;
	}
	
	
}

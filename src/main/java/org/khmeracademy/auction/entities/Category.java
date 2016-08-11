package org.khmeracademy.auction.entities;

import java.util.List;

public class Category {
	private int category_id;
	private String category_name;
	private String category_description;
	private Category parentCategory;
	private List<Category> subCategories;
	private boolean status;
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
	public String getCategory_description() {
		return category_description;
	}
	public void setCategory_description(String category_description) {
		this.category_description = category_description;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Category getParentCategory() {
		return parentCategory;
	}
	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}
//	public Category(int category_id, String category_name, String category_description, Category parentCategory,
//			List<Category> subCategories, boolean status) {
//		super();
//		this.category_id = category_id;
//		this.category_name = category_name;
//		this.category_description = category_description;
//		this.parentCategory = parentCategory;
//		this.subCategories = subCategories;
//		this.status = status;
//	}
	
	public List<Category> getSubCategories() {
		return subCategories;
	}
	public void setSubCategories(List<Category> subCategories) {
		this.subCategories = subCategories;
	}
	
	@Override
	public String toString() {
		return "Category [category_id=" + category_id + ", "
				+ (category_name != null ? "category_name=" + category_name + ", " : "")
				+ (category_description != null ? "category_description=" + category_description + ", " : "")
				+ (parentCategory != null ? "parentCategory=" + parentCategory + ", " : "") + "status=" + status + "]";
	}
	
}

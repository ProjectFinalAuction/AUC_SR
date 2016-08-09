package org.khmeracademy.auction.entities;

public class Product {
	private int product_id;
	private String product_name;
	private String product_description;
	private Supplier supplier;
	private Category category;
	private int qty;
	private Brand brand;
	private boolean status;
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_description() {
		return product_description;
	}
	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", "
				+ (product_name != null ? "product_name=" + product_name + ", " : "")
				+ (product_description != null ? "product_description=" + product_description + ", " : "")
				+ (supplier != null ? "supplier=" + supplier + ", " : "")
				+ (category != null ? "category=" + category + ", " : "") + "qty=" + qty + ", "
				+ (brand != null ? "brand=" + brand + ", " : "") + "status=" + status + "]";
	}
	
}

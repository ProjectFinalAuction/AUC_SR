package org.khmeracademy.auction.entities;

import java.util.List;

public class GalleryInputUpdate {
	private int image_id;
	private int product_id;
	private List<String> image_path;
	
	
	
	public GalleryInputUpdate(int product_id, List<String> image_path) {
		super();
		this.product_id = product_id;
		this.image_path = image_path;
	}
	public int getImage_id() {
		return image_id;
	}
	public void setImage_id(int image_id) {
		this.image_id = image_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public List<String> getImage_path() {
		return image_path;
	}
	public void setImage_path(List<String> image_path) {
		this.image_path = image_path;
	}

		
}

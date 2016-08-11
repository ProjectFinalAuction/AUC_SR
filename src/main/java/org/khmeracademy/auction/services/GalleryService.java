package org.khmeracademy.auction.services;

import java.util.ArrayList;

import org.khmeracademy.auction.entities.Gallery;

public interface GalleryService {

	public ArrayList<Gallery> findImageByProductName(String product_name);

	public boolean addImage(Gallery g);

	public boolean updateImagePath(Gallery g);

	public boolean deleteImage(int image_id);
}

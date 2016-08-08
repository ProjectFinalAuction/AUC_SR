package org.khmeracademy.auction.services.impl;

import java.util.ArrayList;

import org.khmeracademy.auction.entities.Gallery;
import org.khmeracademy.auction.repositories.GalleryRepository;
import org.khmeracademy.auction.services.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GalleryServiceImpl implements GalleryService {

	@Autowired
	GalleryRepository gr;
	@Override
	public ArrayList<Gallery> findImageByProductName(String supplier_name) {
		// TODO Auto-generated method stub
		return gr.findImageByProductName(supplier_name);
	}

	@Override
	public boolean addImage(Gallery g) {
		// TODO Auto-generated method stub
		return gr.addImage(g);
	}

	@Override
	public boolean updateImagePath(Gallery g) {
		// TODO Auto-generated method stub
		return gr.updateImagePath(g);
	}

	@Override
	public boolean deleteImage(int image_id) {
		// TODO Auto-generated method stub
		return gr.deleteImage(image_id);
	}

}

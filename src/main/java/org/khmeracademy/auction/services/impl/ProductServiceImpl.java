package org.khmeracademy.auction.services.impl;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.khmeracademy.auction.entities.GalleryInputUpdate;
import org.khmeracademy.auction.entities.Product;
import org.khmeracademy.auction.entities.ProductInputUpdate;
import org.khmeracademy.auction.entities.UploadedFileInfo;
import org.khmeracademy.auction.repositories.GalleryRepository;
import org.khmeracademy.auction.repositories.ProductRepository;
import org.khmeracademy.auction.services.FileUploadService;
import org.khmeracademy.auction.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository pr;
	
	@Autowired
	GalleryRepository galleryrepository;
	
	@Autowired
	FileUploadService fileUploadService;
	
	
	@Override
	public ArrayList<Product> findAllProducts() {
		// TODO Auto-generated method stub
		return pr.findAllProducts();
	}

	@Override
	public ArrayList<Product> findProductByName(String product_name) {
		// TODO Auto-generated method stub
		return pr.findProductByName(product_name);
	}

	@Override
	public ArrayList<Product> findProductBySupplier(String supplier_name) {
		// TODO Auto-generated method stub
		return pr.findProductBySupplier(supplier_name);
	}

	@Override
	public ArrayList<Product> findProductByCategory(String category_name) {
		// TODO Auto-generated method stub
		return pr.findProductByCategory(category_name);
	}

	@Override
	public int addProduct(ProductInputUpdate p, HttpServletRequest request) {
		
		int result = pr.addProduct(p);
		int productId = p.getProduct_id(); 
		
		UploadedFileInfo gallery;
		gallery = fileUploadService.upload(p.getImages(), "gallery",request);
		GalleryInputUpdate g = new GalleryInputUpdate(productId, gallery.getNames());
		if(galleryrepository.addImage(g))
			return 1;
		return 0;
	}

	@Override
	public boolean updateProduct(ProductInputUpdate p) {
		// TODO Auto-generated method stub
		return pr.updateProduct(p);
	}

	@Override
	public boolean deleteProduct(int product_id) {
		// TODO Auto-generated method stub
		return pr.deleteProduct(product_id);
	}

}

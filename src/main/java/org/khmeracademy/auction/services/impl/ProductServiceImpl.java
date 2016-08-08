package org.khmeracademy.auction.services.impl;

import java.util.ArrayList;

import org.khmeracademy.auction.entities.Product;
import org.khmeracademy.auction.repositories.ProductRepository;
import org.khmeracademy.auction.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository pr;
	
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
	public boolean addProduct(Product p) {
		// TODO Auto-generated method stub
		return pr.addProduct(p);
	}

	@Override
	public boolean updateProduct(Product p) {
		// TODO Auto-generated method stub
		return pr.updateProduct(p);
	}

	@Override
	public boolean deleteProduct(int product_id) {
		// TODO Auto-generated method stub
		return pr.deleteProduct(product_id);
	}

}
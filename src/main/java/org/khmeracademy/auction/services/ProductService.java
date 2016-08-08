package org.khmeracademy.auction.services;

import java.util.ArrayList;

import org.khmeracademy.auction.entities.Product;

public interface ProductService {

	public ArrayList<Product> findAllProducts();

	public ArrayList<Product> findProductByName(String product_name);

	public ArrayList<Product> findProductBySupplier(String supplier_name);
 
	public ArrayList<Product> findProductByCategory(String category_name );

	public boolean addProduct(Product p);

	public boolean updateProduct(Product p);

	public boolean deleteProduct(int  product_id);
}

package org.khmeracademy.auction.services;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.khmeracademy.auction.entities.Product;
import org.khmeracademy.auction.entities.ProductInputUpdate;


public interface ProductService {

	public ArrayList<Product> findAllProducts();

	public ArrayList<Product> findProductByName(String product_name);

	public ArrayList<Product> findProductBySupplier(String supplier_name);
 
	public ArrayList<Product> findProductByCategory(String category_name );

	public int addProduct(ProductInputUpdate p, HttpServletRequest request);

	public boolean updateProduct(ProductInputUpdate p);

	public boolean deleteProduct(int  product_id);
}

package org.khmeracademy.auction.services;

import java.util.ArrayList;

import org.khmeracademy.auction.entities.Brand;

public interface BrandService {

	public ArrayList<Brand> findAllBrands();

	public ArrayList<Brand> findBrandByName(String brand_name);

	public ArrayList<Brand> findBrandByAnyField (String str_search);

	public boolean addBrand(Brand b);

	public boolean updateBrand(Brand b);
	
	public boolean deleteBrand(int brand_id);
}

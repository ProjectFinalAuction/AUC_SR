package org.khmeracademy.auction.services;

import java.util.ArrayList;

import org.khmeracademy.auction.entities.Categories;

public interface CategoriesService {
	
	public ArrayList<Categories> getCategories();
	
	public boolean addCategories(Categories cate);
	
	public ArrayList<Categories> findCategoriesById(int category_id);
	
	public boolean updateCategories(Categories cate);
	
	public boolean deleteCatedories(int category_id);
}

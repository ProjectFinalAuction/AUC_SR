package org.khmeracademy.auction.services;

import java.util.ArrayList;

import org.khmeracademy.auction.entities.Category;



public interface CategoryService {
	public ArrayList<Category> findAllCategories();
	
	public ArrayList<Category> findCategoryByName(String category_name); 
	
	public ArrayList<Category> findCategoryByParentCategory(String parent_name); 
 
	public ArrayList<Category> findCategoryByAnyField(String str_search);
	
	public boolean addCategory(Category c);
	
	public boolean updateCategory(Category c); 
	
	public boolean deleteCategory(int category_id);
}

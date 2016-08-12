package org.khmeracademy.auction.services;

import java.util.ArrayList;

import org.khmeracademy.auction.entities.Category;
import org.khmeracademy.auction.entities.CategoryInputUpdate;



public interface CategoryService {
	public ArrayList<CategoryInputUpdate> findAllCategories();
	
	public ArrayList<Category> findMainCategories();
	
	public ArrayList<Category> findCategoryByName(String category_name); 
	
	public ArrayList<Category> findCategoryByParentCategory(String parent_name); 
 
	public ArrayList<Category> findCategoryByAnyField(String str_search);
	
	public boolean addCategory(CategoryInputUpdate c);
	
	public boolean updateCategory(CategoryInputUpdate c); 
	
	public boolean deleteCategory(int category_id);
}

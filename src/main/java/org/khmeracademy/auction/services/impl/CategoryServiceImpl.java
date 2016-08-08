package org.khmeracademy.auction.services.impl;

import java.util.ArrayList;

import org.khmeracademy.auction.entities.Category;
import org.khmeracademy.auction.repositories.CategoryRepository;
import org.khmeracademy.auction.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository cat;
	
	@Override
	public ArrayList<Category> findAllCategories() {
		// TODO Auto-generated method stub
		return cat.findAllCategories();
	}

	@Override
	public ArrayList<Category> findCategoryByName(String category_name) {
		// TODO Auto-generated method stub
		return cat.findCategoryByName(category_name);
	}

	@Override
	public ArrayList<Category> findCategoryByParentCategory(String parent_name) {
		// TODO Auto-generated method stub
		return cat.findCategoryByParentCategory(parent_name);
	}

	@Override
	public ArrayList<Category> findCategoryByAnyField(String str_search) {
		// TODO Auto-generated method stub
		return cat.findCategoryByAnyField(str_search);
	}

	@Override
	public boolean addCategory(Category c) {
		// TODO Auto-generated method stub
		return cat.addCategory(c);
	}

	@Override
	public boolean updateCategory(Category c) {
		// TODO Auto-generated method stub
		return cat.updateCategory(c);
	}

	@Override
	public boolean deleteCategory(int category_id) {
		// TODO Auto-generated method stub
		return cat.deleteCategory(category_id);
	}
	
}

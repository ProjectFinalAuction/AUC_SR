package org.khmeracademy.auction.services.impl;

import java.util.ArrayList;

import org.khmeracademy.auction.entities.Categories;
import org.khmeracademy.auction.repositories.CategoriesRepository;
import org.khmeracademy.auction.services.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriesServiceImpl implements CategoriesService{

	@Autowired
	CategoriesRepository cateRepo;
	
	@Override
	public ArrayList<Categories> getCategories() {
		return cateRepo.getCategories();
	}

	@Override
	public boolean addCategories(Categories cate) {
		return cateRepo.addCategories(cate);
	}

	@Override
	public boolean updateCategories(Categories cate) {
		return cateRepo.updateCategories(cate);
	}

	@Override
	public boolean deleteCatedories(int category_id) {
		return cateRepo.deleteCatedories(category_id);
	}

	@Override
	public ArrayList<Categories> findCategoriesById(int category_id) {
		return cateRepo.findCategoriesById(category_id);
	}


}

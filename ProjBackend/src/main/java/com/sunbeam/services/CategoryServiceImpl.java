package com.sunbeam.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.DAO.CategoryDao;
import com.sunbeam.entities.Category;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryDao categoryDao;
	
	
	
	
	
	
	public String addCategory(String name) {
		
		Category category = new Category();
		category.setName(name);
		
		categoryDao.save(category);
		
		return "category added";
	}

}

package net.robin.shoppingbackend.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import net.robin.shoppingbackend.dto.Category;

@Service
public interface CategoryDAO {

	
	
	Category get(int id);
	List<Category> list();
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);
	
	
}

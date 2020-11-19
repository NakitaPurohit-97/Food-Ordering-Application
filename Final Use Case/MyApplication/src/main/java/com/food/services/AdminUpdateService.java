package com.food.services;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.food.model.Menu_Table;
import com.food.repository.AdminUpdateRepo;
@Service
public class AdminUpdateService {
	@Autowired
	AdminUpdateRepo adminUpdateRepo;
	public void saveDetails(Menu_Table adminUpdate) {
		// DATETIME - format: YYYY-MM-DD HH:MI:SS
		LocalDate date = LocalDate.now(); 
	    System.out.println(date);
	    String d = date.toString();
		adminUpdate.setDateOfUpdation(d);
		adminUpdateRepo.save(adminUpdate);
	}
	public List<Menu_Table> menuList() {
		List<Menu_Table> menu = (List<Menu_Table>) adminUpdateRepo.findAll();
		return menu;
	}
	public void deletedish(String dishName) {
		adminUpdateRepo.deleteById(dishName);
	}
	public void saveDish(Menu_Table dish) {
		LocalDate date = LocalDate.now(); 
	    String d = date.toString();
		dish.setDateOfUpdation(d);
		adminUpdateRepo.save(dish);
	}
}


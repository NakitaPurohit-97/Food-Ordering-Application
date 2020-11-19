package com.food.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.model.Menu_Table;
import com.food.model.Order_Table;
import com.food.repository.AdminUpdateRepo;
import com.food.repository.OrderTableRepository;
@Service
@Transactional
public class UserService {
	@Autowired
	AdminUpdateRepo adminUpdateRepo;
	@Autowired
	OrderTableRepository orderTableRepo;
	public List<Menu_Table> searchList(String search_dish) {
		List<Menu_Table> menu = (List<Menu_Table>) adminUpdateRepo.findAll();
		List<Menu_Table> searchRes = new ArrayList<Menu_Table>();
		for(var li : menu)	
		{
			if(li.getDishName().contains(search_dish))
				searchRes.add(li);
		}
		return searchRes;
	}
	public List<Order_Table> searchOrderList(String search_order,int id) {
		List<Order_Table> menu = (List<Order_Table>) orderTableRepo.findAll();
		List<Order_Table> searchRes = new ArrayList<Order_Table>();
		for(var li : menu)	
		{
			System.out.println(Integer.toString(li.getOrder_id()));
			if((search_order.contains(Integer.toString(li.getOrder_id())) || 
					(Integer.toString(li.getOrder_id()).contains(search_order))||
					 search_order.equalsIgnoreCase("ORD"))&&(li.getUser_id()==id))
				searchRes.add(li);
		}
		return searchRes;
	}
	
}

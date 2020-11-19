package com.food.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import com.food.model.Menu_Table;
import com.food.model.Order_Table;
import com.food.model.User_Table;
import com.food.services.AdminUpdateService;
import com.food.services.UserService;
@Controller
@RequestMapping("/user")
public class UserDaoController {
	@Autowired
	AdminUpdateService adminUpdateService;
	@Autowired
	UserService userService;
	public List TodaysMenu() {
		LocalDate date = LocalDate.now();
		List<Menu_Table> menu = adminUpdateService.menuList();	
		List<Menu_Table> todays_menu = new ArrayList<Menu_Table>();
		System.out.println(menu);
		for(var l : menu) {
			if(l.getDateOfUpdation().equals(date.toString())&&(l.getAvailableQuantity()>0))	
				todays_menu.add(l);
			System.out.println(todays_menu);
			}
		return todays_menu;
	}
	@RequestMapping("/userHomePage")
	public ModelAndView userHomePage() {
		ModelAndView model = new ModelAndView("userhomepage");
		model.addObject("todays_menu",TodaysMenu());
		model.addObject("msg",null);
	
		return model;
	}
	@RequestMapping("/addToCart")
	public String addToCart(Menu_Table Item) {
		System.out.println(Item);
		return "first";
	}
	@RequestMapping("/searchDish")
	public ModelAndView searchDish(@SessionAttribute("user")User_Table user) {
		ModelAndView mv = new ModelAndView("searchDish1");
		if(user.getUser_id()==0)	
			mv.addObject("msg",null);
		return mv;
	}
	@RequestMapping("/searchDishOpr")
	public ModelAndView searchDishOpr(String search_dish,@SessionAttribute("user")User_Table user) {
		List<Menu_Table> res = userService.searchList(search_dish);	
		ModelAndView mv = new ModelAndView("searchDish");
		mv.addObject("SearchRes",res);
		mv.addObject("search_key", search_dish);
		if(user.getUser_id()!=0)	
			mv.addObject("msg1","notNull");
		else 
			mv.addObject("msg1", null);
		if(res.isEmpty())
		{
			mv.addObject("msg", "No Result Found for Search ");
		}
		return mv;
	}
	@RequestMapping("/searchOrder")
	public String searchOrder() {
		return "searchOrder1";
	}
	@RequestMapping("/searchOrderOpr")
	public ModelAndView searchOrderOpr(@SessionAttribute("user")User_Table user, String search_order) {
		System.out.println("Session user value :"+user);
		List<Order_Table> res = userService.searchOrderList(search_order,user.getUser_id());
		System.out.println(res);
		ModelAndView mv = new ModelAndView("searchOrder");
		mv.addObject("SearchRes",res);
		mv.addObject("search_key", search_order);
		if(res.isEmpty())
		{
			mv.addObject("msg", "No Result Found for Search ");
		}
		return mv;
	}
}
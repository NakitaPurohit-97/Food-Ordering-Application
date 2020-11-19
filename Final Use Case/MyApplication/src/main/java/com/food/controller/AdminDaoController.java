package com.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.food.model.Image;
import com.food.model.Menu_Table;
import com.food.model.User_Table;
import com.food.repository.AdminUpdateRepo;
import com.food.services.AdminUpdateService;
@Controller
public class AdminDaoController {
		@Autowired
		AdminUpdateService adminUpdateService;
		@Autowired
		AdminUpdateRepo adminRepo;
		Image image = new Image();
		@RequestMapping("/updateAdminpage")
		public String UpdateAdminPage() {
			return "UpdateAdmin";
		}
		@RequestMapping(value = "/UpdateAdmin")
		public ModelAndView postAdminUpdate (Menu_Table  adminUpdate) {
			ModelAndView mv = new ModelAndView("AdminInterface");
			List<String> img = image.imageList();
			for(var i : img)
			{
				System.out.println(i);
				System.out.println(adminUpdate.getDish_Name());
				if(i.contains(adminUpdate.getDish_Name()) || i.equalsIgnoreCase(adminUpdate.getDish_Name())) {
					System.out.println("entered");
					String s = i+".jpg";
					adminUpdate.setDish_img(s);
					break;
				}
				else
					adminUpdate.setDish_img("Default.jpg");	
			}
			System.out.println(adminUpdate);
			adminUpdateService.saveDetails(adminUpdate);
			mv.addObject(adminUpdate);
			mv.addObject("path", "Images/");
			return mv;
		}
		@RequestMapping(value="/updatedItemsDetails")
		public String displayAdminUpates(ModelMap modelMap) {
			modelMap.put("Items",adminRepo.findAll());
			modelMap.put("path", "Images/");
			return "index";
		}
		@RequestMapping("/AdminInterfacePage")
		public String AdminInterfacePage() {	
			return "AdminInterface";
		}
		@RequestMapping("/delete/{dishName}")
		public ModelAndView deletePage(@PathVariable("dishName") String dishName) {	
			System.out.println(dishName);
			adminUpdateService.deletedish(dishName);
			ModelAndView m = new ModelAndView("index");
			m.addObject("Items", adminRepo.findAll());
			m.addObject("path", "../Images/");
			return m;
		}
		@RequestMapping("/edit/{dishName}/{availableQuantity}/{price}/{ingredients}")
		public ModelAndView editPage(@PathVariable("dishName") String dishName,@PathVariable("availableQuantity")int availableQuantity,
				@PathVariable("price")float price,@PathVariable("ingredients")String ingredients) {
			Menu_Table dish = new Menu_Table(dishName,availableQuantity,price,ingredients);
			adminUpdateService.saveDish(dish);
			ModelAndView m = new ModelAndView("UpdateAdmin");
			m.addObject("Items", adminRepo.findAll());
			return m;
		}
}
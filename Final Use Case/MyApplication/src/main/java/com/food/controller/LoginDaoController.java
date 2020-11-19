package com.food.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.food.model.Menu_Table;
import com.food.model.User_Table;
import com.food.services.UserTableService;

@Controller
@SessionAttributes("user")
public class LoginDaoController {	
	public int USER_ID;
	@Autowired
	UserTableService userService;	
	@Autowired
	UserDaoController userDaoController;
	@ModelAttribute("user")
	public User_Table setUpUserForm() {
	    return new User_Table();
	}

	@RequestMapping("/")
	public String home() {
		return "login";
	}
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	@RequestMapping("/welcome")
	public String welcome() {
		return "welcomepage";
	}
	@RequestMapping("/register")
	public String registration() {
		return "registerpage";
	}
	@PostMapping("/save-user")
	public ModelAndView registerUser(User_Table user_table) {
		User_Table u = userService.saveMyUser(user_table);
		String msg = "Not registered.. Try Again!!";
		if(u!=null)
		{
			List<User_Table> l = userService.FetchMyUser();
			for(var l1:l)
			{
				if((l1.getUser_name().equals(user_table.getUser_name())) && (l1.getAddress().equals(user_table.getAddress()))
					&& (l1.getEmail().equals(user_table.getEmail())) && (l1.getPassword().equals(user_table.getPassword()))&&
					 (l1.getPh_number() == user_table.getPh_number()))
						msg ="Successfull Registered for User Id :  "+l1.getUser_id();
			}
		}
		ModelAndView model = new ModelAndView("login");
	    model.addObject("message",msg);
		return model;
	}
	@PostMapping("/validateuser")
	public ModelAndView ValidateUser(@ModelAttribute("user") User_Table user_table, Model model) {
		 List<User_Table> l = userService.FetchMyUser();
		 String ret = "login";
		 String menuInfo = null;
		 List<Menu_Table> todays_menu = null;
		 for(var l1:l)
		 {
			 if(l1.getUser_id()==user_table.getUser_id())
			 {
				User_Table u = userService.validateMyUser(user_table);
				if((u.getUser_id()==user_table.getUser_id())&&(u.getPassword().equals(user_table.getPassword())&&(u.getRole().equals("user"))))
				{
					todays_menu = userDaoController.TodaysMenu();
					ret = "userhomepage";
				}
				else if((u.getUser_id()==user_table.getUser_id())&&(u.getPassword().equals(user_table.getPassword())&&(u.getRole().equals("admin"))))
					ret = "AdminInterface";
			 } 
		 }	
		ModelAndView model1 = new ModelAndView(ret);
	    model1.addObject("message","Enter Valid Credentials");
	    model1.addObject("todays_menu",todays_menu);
	    model1.addObject("msg", "USER");
		return model1;
	}

}

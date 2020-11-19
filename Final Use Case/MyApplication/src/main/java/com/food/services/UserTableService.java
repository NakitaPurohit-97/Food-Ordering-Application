package com.food.services;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.food.model.User_Table;
import com.food.repository.UserTableRepository;

@Service
@Transactional
public class UserTableService {
	private final UserTableRepository userTableRepository;
	
	public UserTableService(UserTableRepository userRepository) {
		this.userTableRepository=userRepository;
	}
	public User_Table saveMyUser(User_Table user_Table ) {
		user_Table.setRole("user");
		 User_Table u = userTableRepository.save(user_Table);
		return u;
	}
	public User_Table validateMyUser(User_Table user_table ) {
		User_Table u = userTableRepository.findById(user_table.getUser_id()).get();
		return u;
	}
	public List<User_Table> FetchMyUser() {
		List<User_Table> u =  (List<User_Table>) userTableRepository.findAll();
		return u;
	}
}

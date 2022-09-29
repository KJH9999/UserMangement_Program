package com.spring.ex.service;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.spring.ex.dto.UserDTO;

@Repository 
public interface UserService {

	public void insertUser(Model model);
	public int loginUser(Model model);
	public int idCk(String email);
	public List<UserDTO> findname(String id);
	public List<UserDTO> userlist();
	
}

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
	public void delete(String id);
	public void updatePw(Model model);
	public void updateNameOk(Model model);
	public void updateNumberOk(Model model);
	public List<UserDTO> information(String id);
	
}

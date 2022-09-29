package com.spring.ex.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.ex.dto.UserDTO;


@Repository
public interface UserDAO {
	public void insertUser(String id, String pw, String name, String number);
	public int loginUser(String id, String pw);
	public int idCk(String id);
	public List<UserDTO> findname(String id);
	public List<UserDTO> userlist();
}

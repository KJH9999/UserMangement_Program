package com.spring.ex.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.spring.ex.dao.UserDAO;
import com.spring.ex.dto.UserDTO;

@Service
public class UserServiceImp implements UserService{

	@Inject
	UserDAO userDAO;
	
	@Override
	public void insertUser(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String number = request.getParameter("number");

		
		System.out.println("S"+id+pw+name+number);
		
		userDAO.insertUser(id,pw,name,number);
	}

	@Override
	public int loginUser(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		System.out.println("SER: "+id+pw);
		
		return userDAO.loginUser(id,pw);
	}

	@Override
	public int idCk(String id) {
		System.out.println("S = " + id);
		int result = userDAO.idCk(id);
		return result;
	}

	@Override
	public List<UserDTO> findname(String id) {
		return userDAO.findname(id);
	}
	
	@Override
	public List<UserDTO> userlist() {
		return userDAO.userlist();
	}

	@Override
	public void delete(String id) {
		userDAO.deleteUser(id);
	}

	@Override
	public void updatePw(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
	   
	    System.out.println("s : " + id + " "+ pw);

		userDAO.updatePw(id,pw);
		
	}

	@Override
	public void updateNameOk(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String id = request.getParameter("id");	
		String name = request.getParameter("name");	
		
		System.out.println("s : " + id + " "+ name);
		  
		userDAO.updateName(id,name);
	}

	@Override
	public void updateNumberOk(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String id = request.getParameter("id");	
		String number = request.getParameter("number");	
		
		System.out.println("s : " + id + " "+ number);
		  
		userDAO.updateNumber(id,number);
		
	}

	@Override
	public List<UserDTO> information(String id) {
		System.out.println("s : " + id );
		return userDAO.information(id);
	}

	@Override
	public void approve(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String id = request.getParameter("id");	
		
		System.out.println("s : " + id );
		  
		userDAO.approve(id);
	}

}

package com.spring.ex.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.ex.dto.UserDTO;

@Repository
public class UserDAOImp implements UserDAO {

	@Inject
	SqlSession sqlSession;

	@Override
	public void insertUser(String id, String pw, String name, String number) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pw", pw);
		map.put("name", name);
		map.put("number", number);

		System.out.println("DAO" + id + pw + name + number);

		sqlSession.insert("user.insertUser", map);
	}

	@Override
	public int loginUser(String id, String pw) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pw", pw);

		System.out.println("DAO : " + id + pw);

		sqlSession.selectList("user.login", map);
		if (sqlSession.selectList("user.login", map).equals(sqlSession.selectList("user.forlogin"))) {
			System.out.println(sqlSession.selectList("user.login", map));
			System.out.println(sqlSession.selectList("user.forlogin"));
			System.out.println("O");
			return 1;
		} else {
			System.out.println(sqlSession.selectList("user.login", map));
			System.out.println(sqlSession.selectList("user.forlogin"));
			System.out.println("X");
			return 0;
		}

	}

	@Override
	public int idCk(String id) {
		System.out.println("dao1");
		int result = sqlSession.selectOne("user.idCk", id);
		System.out.println("D" + sqlSession.selectOne("user.idCk", id));
		return result;
	}

	@Override
	public List<UserDTO> findname(String id) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		
		System.out.println(id);
		return sqlSession.selectList("user.findname",map);
	}

	@Override
	public List<UserDTO> userlist() {
		return sqlSession.selectList("user.userList");
	}

	@Override
	public void deleteUser(String id) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);	
		
		sqlSession.delete("user.deleteUser", map);
	}

	@Override
	public void updatePw(String id, String pw) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);		
		map.put("pw", pw);		
		
		System.out.println(id +pw);
		sqlSession.update("user.updatePw", map);
	}

	@Override
	public void updateName(String id, String name) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);		
		map.put("name", name);		
		
		System.out.println("DAO : " + id +name);
		sqlSession.update("user.updateName", map);
	}

	@Override
	public void updateNumber(String id, String number) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);		
		map.put("number", number);		
		
		System.out.println("DAO : " + id +number);
		sqlSession.update("user.updateNumber", map);		
	}

	@Override
	public List<UserDTO> information(String id) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);	
		System.out.println("D : " + id );
		return sqlSession.selectList("user.findname",map);
	}

	@Override
	public void approve(String id) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);		
		
		System.out.println("DAO : " + id );
		sqlSession.update("user.approve", map);	
	}

}

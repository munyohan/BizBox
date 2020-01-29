package com.bizbox.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bizbox.dao.UserServiceDAO;
import com.bizbox.utils.SHA256Util;
import com.bizbox.vo.User;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserServiceDAO dao;
	
	@Autowired
	SHA256Util shaUtil;
	
	public User Singin(String name, String email) {
		return new User(name, email);
	}

	@Override
	public int singupUser(User user) {
		String salt = shaUtil.generateSalt();
		String pw = user.getPw();
		pw = shaUtil.getEncrypt(pw, salt);
		
		user.setPw(pw);
		return dao.singupUser(user);
	}

	@Override
	public User loginUser(User user) {
		
		return dao.loginUser(user);
	}
}
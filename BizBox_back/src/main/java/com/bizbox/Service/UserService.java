package com.bizbox.Service;

import com.bizbox.vo.User;

public interface UserService {
	int singupUser(User user);
	User loginUser(User user);
}
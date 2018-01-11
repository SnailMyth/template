package cn.myth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.myth.base.BaseException;
import cn.myth.base.Errors;
import cn.myth.base.ResultData;
import cn.myth.data.User;
import cn.myth.repositories.UserDao;


@Service
@Transactional
public class LoginService {

	@Autowired
	public UserDao dao;

	public User getUser(int id) {
		User user = dao.findOne(id);
		return user;
	}

	public User getUserByName(String username) {
		User user = dao.getUserByName(username);
		return user;
	}
	
	
	public ResultData<User> login(User u) {
		ResultData<User> result = new ResultData<>();
		User user = getUserByName(u.getUsername());
		if (user != null) {
			if (!user.getPasswd().equals(user.getPasswd())) {
				result.setException(BaseException.create(Errors.Login_FAIL, "password is wrong"));
			}else {
				result.setData(user);
			}
		} else {
			result.setException(BaseException.create(Errors.Login_FAIL, "user not exsist"));
		}
		return result;
	}
}

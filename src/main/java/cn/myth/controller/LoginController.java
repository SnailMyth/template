/**
 * 
 */
/**
 * @author myth_hai
 *
 */
package cn.myth.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.myth.base.ApiModel;
import cn.myth.base.ResultData;
import cn.myth.data.User;
import cn.myth.service.LoginService;


/**
 * 
 * @author myth_hai
 * @group Login
 */
@Controller
public class LoginController {
    
	@Autowired
	LoginService service;
	
	@RequestMapping(value = { "/", "/loginView" })
	public String loginView() {
		return "loginView";
	}
	
	@RequestMapping(value = { "/login" })
	@ResponseBody
	public ApiModel login(User user, HttpServletRequest req, HttpServletResponse resp) {
		ApiModel m = new ApiModel();
		ResultData<User> result = service.login(user);
		System.out.println(user);
		if (result.isSuccess()) {
			User loginUser = result.getData();
			req.getSession().setAttribute("user", loginUser);
			m.setData("login success!");
		} else {
			m.setError(result.getException());
		}
		return m;
	}
}
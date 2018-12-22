package com.shoppingcart.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shoppingcart.cartDAO.UserDAO;
import com.shoppingcart.model.User;

public class LoginService {
	@Autowired
	UserDAO userdao;

	/*=new UserDAO();*/

	public UserDAO getUserdao() {
		return userdao;
	}


	public void setUserdao(UserDAO userdao) {
		this.userdao = userdao;
	}


	public boolean isValid(String username,String password){
		boolean status=false;
		List<User> users=userdao.getAllUsers();
	for(User u:users){
		if(u.getUserName().equals(username) && u.getPassword().equals(password))
			status=true;	
	}
		return status;
	}
	
	
	public int addUser(User user){
	/*return userdao.addUser(u.getUserId(), u.getUserName(), u.getPassword(),u.getEmailId(),u.getMobileNo());*/
		
		return userdao.addUser(user);
	}
/*	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("Bean.xml");
		LoginService userService=context.getBean(LoginService.class);
		System.out.println(userService.isValid("mallika", "mal"));
		System.out.println(userService.isValid("chaitali", "cha"));
		System.out.println(userService.addUser(new User(104, "abhay", "abh", "abh@gmail.com", 43144988)));
		
	}
	*/
}

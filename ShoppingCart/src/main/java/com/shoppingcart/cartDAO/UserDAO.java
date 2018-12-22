package com.shoppingcart.cartDAO;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.shoppingcart.mapper.UserMapper;
import com.shoppingcart.model.User;


@Component
public class UserDAO {
private JdbcTemplate jdbcTemplate;
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	


	public List<User> getUser(int userId) {
		
		String sql=null;
		
		sql="select * from userTable1 where userId="+userId;
		List <User> users = jdbcTemplate.query(sql, new UserMapper());
		
		return users;
	}


	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		String sql;
		sql="select * from userTable1";
		List <User> users = jdbcTemplate.query(sql, new UserMapper());
		
		return users;
	}

/*	@Override
	public int addUser(int userId, String userName, String password, String emailId, long mobileNo) {
		String sqlInsert=null;
		//"insert into userTable values(101,'vidhya','vid','cvs@gmail.com',87444762);
		sqlInsert="insert into userTable1 values("+userId+",'"+userName+"','"+password+"','"+emailId+"',"+mobileNo+")";
		return jdbcTemplate.update(sqlInsert);
	}*/
	
	
	public int addUser(User user) {
		String sql;
		sql="insert into userTable1 values("+user.getUserId()+",'"+user.getUserName()+"','"
		+user.getPassword()+"','"+user.getEmailId()+"',"+user.getMobileNo()+")";
		
		return jdbcTemplate.update(sql); 
		
	}


	public int remove(int userId) {
		String sql=null;
		//delete from userTable1 where userId=10;
		sql="delete from userTable1 where userId="+userId;
		return jdbcTemplate.update(sql);
	}

	
	public int update(int userId,String password) {
		
		String sql=null;
		sql="update userTable1 set password='"+password+"' where userId="+userId;
		return jdbcTemplate.update(sql);
	}

	
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("springjdbc.xml");
		UserDAO dao=context.getBean(UserDAO.class);
		System.out.println(dao.addUser(new User(101, "vidhya", "vid", "cvs@gmail.com", 87444762)));
		/*System.out.println(dao.addUser(102,"mallika","mal","mal@gmail.com",762436));
		System.out.println(dao.addUser(103,"chaitali","cha","cha@gmail.com",8128536));*/
		//System.out.println(dao.remove(101));
		//System.out.println(dao.getUser(102));
		//System.out.println(dao.getAllUsers());
		System.out.println(dao.update(101, "hello"));
	}

	
	
}

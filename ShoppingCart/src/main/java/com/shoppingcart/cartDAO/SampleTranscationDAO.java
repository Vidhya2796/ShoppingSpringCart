package com.shoppingcart.cartDAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.shoppingcart.mapper.CartMapper;
import com.shoppingcart.model.Cart;
import com.shoppingcart.model.User;

public class SampleTranscationDAO {

private JdbcTemplate jdbcTemplate;
@Autowired
private User user; 
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	} 
	public JdbcTemplate getJdbcTemplate() {  
	   return  jdbcTemplate;  
	} 
	

	public List<Cart> getCartUser(int uid){  
	    String query="select * from cart where userId="+user.getUserId();  
	 
		List <Cart> cart = jdbcTemplate.query(query, new CartMapper());
		
		return cart;
	   
	   
	} 
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("Bean.xml");
		SampleTranscationDAO sampleTranscationDAO=context.getBean(SampleTranscationDAO.class);
		sampleTranscationDAO.getCartUser(1);
	}
	
}

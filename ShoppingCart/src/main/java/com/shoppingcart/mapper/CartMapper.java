package com.shoppingcart.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.shoppingcart.model.Cart;

public class CartMapper implements RowMapper<Cart> {
	public Cart mapRow(ResultSet rs, int arg1) throws SQLException {
		   Cart cart = new Cart();
		
		  
		   cart.setProductId(rs.getInt("productId"));
		   cart.setUserId(rs.getInt("userId"));
		   cart.setProductPrice(rs.getInt("productPrice"));
		   cart.setQuantity(rs.getInt("quantity"));
		   cart.setTotalAmount(rs.getInt("totalAmount"));
		   cart.setProductName((rs.getString("productName")));
		   
		   
	      return cart;
	
	}
}

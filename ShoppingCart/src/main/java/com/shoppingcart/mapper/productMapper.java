package com.shoppingcart.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.shoppingcart.model.Product;

public class productMapper implements RowMapper<Product> {

	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		   Product product = new Product();

		   product.setProductId(rs.getInt("productId"));
		   product.setProductName((rs.getString("productName")));
		   product.setProductPrice(rs.getInt("productPrice"));
	      return product;
	
	}

}

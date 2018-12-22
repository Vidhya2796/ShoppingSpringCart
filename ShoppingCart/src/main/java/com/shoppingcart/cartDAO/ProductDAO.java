package com.shoppingcart.cartDAO;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.shoppingcart.mapper.productMapper;
import com.shoppingcart.model.Product;
@Component
public class ProductDAO {

	private JdbcTemplate jdbcTemplate;  
	  
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	} 
	public JdbcTemplate getJdbcTemplate() {  
	   return  jdbcTemplate;  
	}  
	
	public List<Product> getProduct(int  id){  
	    String query="select * from product where productId="+id;  
	 
		List <Product> product = jdbcTemplate.query(query, new productMapper());
		
		return product;
	   
	   
	} 
	public List<Product> getAll(){  
	    String query="select * from product";  
	    List <Product> product = jdbcTemplate.query(query, new productMapper());
		
		return product;
	} 
	
	public boolean isContain(){ 
		Boolean status=false;
	   String query="select * from product";  
	    List <Product> product  = jdbcTemplate.query(query,new productMapper());
		/*ProductDAO dao=new ProductDAO();
		List <Product> product=dao.getAll();*/
	    int value=product.size();
	    System.out.println(value);
	    if(value>0)
	    	status=true;
	    return status;
	} 

	public int add(Product p){  
	    String query="insert into product values("+p.getProductId()+",'"+p.getProductName()+"',"+p.getProductPrice()+")";  
	    return jdbcTemplate.update(query);  
	}  
	public int update(int id,Product p){ 
		String query="update product set productname='"+p.getProductName()+"',productPrice="+p.getProductPrice()+" where productId="+p.getProductId();
	   // String query="update product set name='"+p.getProductName()+"',productId="+p.getProductId()+","+p.getProductPrice()+"where id="+id ;  
	    return jdbcTemplate.update(query);  
	}  
	public int delete(int id){  
	    String query="delete from product where productid="+id;  
	    return jdbcTemplate.update(query);  
	} 
	
	
	
	
	
}

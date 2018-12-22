package com.shoppingcart.cartDAO;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.shoppingcart.mapper.CartMapper;
import com.shoppingcart.model.Cart;
@Component
public class UserTransactionDAO {
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	} 
	public JdbcTemplate getJdbcTemplate() {  
	   return  jdbcTemplate;  
	}  
	
	public List<Cart> getCartProduct(int  uid,int pid){  
	    String query="select * from cart where userId="+uid+" and productid="+pid;  
	 
		List <Cart> cart = jdbcTemplate.query(query, new CartMapper());
		
		return cart;
	   
	   
	} 
	
	
	public List<Cart> getCartUser(int  uid){  
	    String query="select * from cart where userId="+uid;  
	 
		List <Cart> cart = jdbcTemplate.query(query, new CartMapper());
		
		return cart;
	   
	   
	} 
	
	public List<Cart> getAll(int uid){  
	    String query="select * from cart where userId="+uid;  
List <Cart> cart = jdbcTemplate.query(query, new CartMapper());
		
		return cart;
	} 
	public boolean isContain(){ 
		Boolean status=false;
	    String query="select * from cart";  
	    List <Cart> cart  = jdbcTemplate.query(query,new CartMapper()); 
	    int value=cart.size();
	    System.out.println(value);
	    if(value>0)
	    	status=true;
	    return status;
	} 

	
	   /*cart.setProductId(rs.getInt("productId"));
	   cart.setUserId(rs.getInt("userId"));
	   cart.setProductPrice(rs.getInt("productPrice"));
	   cart.setQuantity(rs.getInt("quantity"));
	   cart.setTotalAmount(rs.getInt("totalAmount"));
	   cart.setProductName((rs.getString("productName")));*/
	
	public int add(Cart c){  
	    String query="insert into cart values("+c.getProductId()+","+c.getUserId()+","+c.getProductPrice()+","+c.getQuantity()+","+c.getTotalAmount()+",'"+c.getProductName()+"')";  
	    return jdbcTemplate.update(query);  
	}  
	
	
	//total amount shld get updated-->PENDING
	/*public int update(int uid,int pid,int qty){ 
		String query="update cart set quantity="+qty+",totalamount = (qty*) where productId="+pid+" and userId="+uid;

	   // String query="update product set name='"+p.getProductName()+"',productId="+p.getProductId()+","+p.getProductPrice()+"where id="+id ;  
	    return jdbcTemplate.update(query);  
	} */ 
	public int update(int qty,Cart cart){ 
		String query="update cart set quantity="+qty+",totalamount ="+qty*cart.getProductPrice()+" where productId="+cart.getProductId()+" and userId="+cart.getUserId();

	   // String query="update product set name='"+p.getProductName()+"',productId="+p.getProductId()+","+p.getProductPrice()+"where id="+id ;  
	    return jdbcTemplate.update(query);  
	} 
	public int delete(int uid,int pid){  
	    String query="delete from cart where userid="+uid+" and productid="+pid;  
	    return jdbcTemplate.update(query);  
	}
	public int deleteAll(int uid) {
		 String query="delete from cart where userid="+uid;
		 return jdbcTemplate.update(query);  
		
	} 
}

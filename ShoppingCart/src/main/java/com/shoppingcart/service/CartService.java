package com.shoppingcart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shoppingcart.cartDAO.UserTransactionDAO;
import com.shoppingcart.model.Cart;

public class CartService {
	@Autowired
	UserTransactionDAO utdao;

	
	
	public UserTransactionDAO getUtdao() {
		return utdao;
	}

	public void setUtdao(UserTransactionDAO utdao) {
		this.utdao = utdao;
	}

	public int addProductToCart(Cart p){
		return utdao.add(p);
	}

	public List<Cart> showcart(int uid){
		return utdao.getAll(uid);
	}

	/*public int updateQuantity(int uid,int pid,int quantity){
		return utdao.update(uid, pid, quantity);
		
	}*/

	public int updateQuantity(int quantity,Cart c){
		return utdao.update(quantity,c);
		
	}
	public int removeProduct(int uid,int pid){
		return utdao.delete(uid, pid);
	}

	public int removeAll(int uid){
		return utdao.deleteAll (uid);
	}

/*public static void main(String[] args) {
	
	ApplicationContext context=new ClassPathXmlApplicationContext("Bean.xml");
	CartService cartService=context.getBean(CartService.class);
	//System.out.println(cartService.addProductToCart(new Cart(4, 2, 10000, 3, 30000, "laptop")));
//	System.out.println(cartService.showcart(1));
	//System.out.println(cartService.updateQuantity(1, 5, 10));
	//System.out.println(cartService.removeProduct(1, 2));
	
	System.out.println(cartService.addProductToCart(new Cart(5, 3, 10000, 3, 30000, "laptop")));
	System.out.println(cartService.addProductToCart(new Cart(6, 3, 10000, 3, 30000, "laptop")));
	System.out.println(cartService.addProductToCart(new Cart(7, 3, 10000, 3, 30000, "laptop")));
	//System.out.println(cartService.removeAll(3));
	//System.out.println(cartService.updateQuantity(3, new ));
}*/
}

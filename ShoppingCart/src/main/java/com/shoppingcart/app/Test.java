package com.shoppingcart.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shoppingcart.cartDAO.ProductDAO;
import com.shoppingcart.cartDAO.UserTransactionDAO;
import com.shoppingcart.model.Cart;
import com.shoppingcart.model.Product;
import com.shoppingcart.model.User;
import com.shoppingcart.service.CartService;
import com.shoppingcart.service.LoginService;
import com.shoppingcart.service.ProductService;

public class Test {

	public static void main(String[] args) {

	
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("Bean.xml");
		ProductService productService=(ProductService) applicationContext.getBean("ProductService");
		LoginService loginService =applicationContext.getBean(LoginService.class);
		CartService cartService=applicationContext.getBean(CartService.class);
		
		
		System.out.println(loginService.isValid("mallika", "mal"));
		System.out.println(loginService.isValid("chaitali", "cha"));
		System.out.println(loginService.addUser(new User(104, "abhay", "abh", "abh@gmail.com", 43144988)));
		
		
		System.out.println(productService.getAllProducts());
		System.out.println(productService.getProduct(2));
		
		
		
		System.out.println(cartService.addProductToCart(new Cart(4, 2, 10000, 3, 30000, "laptop")));
		System.out.println(cartService.showcart(1));

		System.out.println(cartService.removeProduct(1, 2));
		
		System.out.println(cartService.addProductToCart(new Cart(5, 3, 10000, 3, 30000, "laptop")));
		System.out.println(cartService.addProductToCart(new Cart(6, 3, 10000, 3, 30000, "laptop")));
		System.out.println(cartService.addProductToCart(new Cart(7, 3, 10000, 3, 30000, "laptop")));
		//System.out.println(cartService.removeAll(3));
		//System.out.println(cartService.updateQuantity(3, new ));
		
		
		/*System.out.println(productService.getAllProducts());*/
		//System.out.println(productService.getProduct(2));
	}
		//ProductDAO dao =context.getBean(ProductDAO.class);
		//int status = dao.delete(1);
		/*dao.add(new Product(1, "product1",35000.0));
		dao.add(new Product( 2,"product2", 25000.0));
		dao.add(new Product( 3,"product3", 45000.0));*/
		/*List<Product> status0 = dao.getProduct(1);
		System.out.println(status0);*/
	/*	List<Product> status1 = dao.getAll();
		System.out.println(status1);*/
		//dao.add(new Product( 1,"product1", 35000.0));
		//System.out.println(dao.isContain());
		//dao.update(2, new Product( 2,"product4",75000.0));/*
		
		/*List<Product> status11 = dao.getAll();
		System.out.println(status11);/*
		dao.delete(1);
		dao.delete(2);
		dao.delete(3);
		/*dao.delete(1);
		List<Product> status10 = dao.getAll();
		System.out.println(status10);
		System.out.println(dao.isContain());*/
		
		//dao.delete(1);
	/*	UserTransactionDAO transactionDAO=context.getBean(UserTransactionDAO.class);
		transactionDAO.add(new Cart(1, 1, 20000, 2, 40000, "product1"));
		//transactionDAO.add(new Cart(1, 2, 2000, 3, 60000, "product1"));
		//System.out.println(transactionDAO.isContain());
		//System.out.println(transactionDAO.delete(2, 1));
		System.out.println(transactionDAO.delete(2, 1));
	}
*/
}

package com.shoppingcart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shoppingcart.cartDAO.ProductDAO;
import com.shoppingcart.model.Product;

public class ProductService {
	
	
	@Autowired
	ProductDAO productdao;
	
	
	
	public ProductDAO getProductdao() {
		return productdao;
	}

	public void setProductdao(ProductDAO productdao) {
		this.productdao = productdao;
	}

	public List<Product> getAllProducts(){
		return productdao.getAll();
		
	}
	
	public List<Product> getProduct(int pid){
		
		return productdao.getProduct(pid);
		
	}
	
	//public static void main(String[] args) {
		/*ApplicationContext applicationContext=new ClassPathXmlApplicationContext("Bean.xml");
		ProductService productService=applicationContext.getBean(ProductService.class);
		System.out.println(productService.getAllProducts());
		System.out.println(productService.getProduct(2));
	}*/
	
}

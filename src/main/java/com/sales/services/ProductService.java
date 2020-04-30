package com.sales.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Product;
import com.sales.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository pr;

	public ArrayList<Product> getAllProducts() {
		return (ArrayList<Product>) pr.findAll();
	}

	public void save(Product p) {
		pr.save(p);
	}

	public void updateQuantity(Product p, int qty) { // take the product and quantity of an order as parameters and update the product information in the db
		p.setQtyInStock(p.getQtyInStock() - qty);
		save(p);
	}

}

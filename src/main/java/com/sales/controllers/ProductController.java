package com.sales.controllers;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sales.models.Product;
import com.sales.services.ProductService;

@Controller
@SessionAttributes("product")
public class ProductController {
	
	@Autowired
	ProductService ps;
	@RequestMapping(value = "/showProducts.html", method=RequestMethod.GET)
	public String listProductGET(Model m) {
		ArrayList<Product> products = ps.getAllProducts();
		m.addAttribute("products", products);
		return "showProducts";
	}
	
	@RequestMapping(value = "/addProduct.html", method=RequestMethod.GET)
	public String addProductGET(Model m) {
		Product p = new Product();
		
		m.addAttribute("product", p);
		
		return "addProduct";
	}
	
	@RequestMapping(value = "/addProduct.html", method=RequestMethod.POST)
	public String addProductPOST(@ModelAttribute("product") Product p) {
		ps.save(p);
		
		return "redirect:showProducts.html";
	}
}

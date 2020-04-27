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

import com.sales.models.Customer;
import com.sales.models.Order;
import com.sales.models.Product;
import com.sales.services.CustomerService;
import com.sales.services.OrderService;
import com.sales.services.ProductService;

@Controller
@SessionAttributes("order")
public class OrderController {

	@Autowired
	OrderService os;
	
	@Autowired
	CustomerService cs;
	
	@Autowired
	ProductService ps;
	
	@RequestMapping(value = "/showOrders.html", method=RequestMethod.GET)
	public String listOrderGET(Model m) {
		ArrayList<Order> orders = os.getAllOrders();
		m.addAttribute("orders", orders);
		return "showOrders";
	}
	
	@RequestMapping(value = "/newOrder.html", method=RequestMethod.GET)
	public String addOrderGET(Model m) {
		ArrayList<Customer> customerList = cs.getAllCustomers();		
		Map<Long, String> customerMap = new LinkedHashMap<Long, String>();
		
		for (Customer c : customerList) {
			customerMap.put(c.getcId(), c.getcName());
		}

		m.addAttribute("customerMap", customerMap);
		
		ArrayList<Product> productList = ps.getAllProducts();		
		Map<Long, String> productMap = new LinkedHashMap<Long, String>();
		
		for (Product p : productList) {
			productMap.put(p.getpId(), p.getpDesc());
		}

		m.addAttribute("productMap", productMap);
		
		Order o = new Order();
		m.addAttribute("order", o);
		return "newOrder";
	}
	
	@RequestMapping(value = "/newOrder.html", method=RequestMethod.POST)
	public String addOrderPOST(@ModelAttribute("order") Order o) {
		
		o.setOrderDate(java.time.LocalDate.now().toString());
		os.save(o);
		return "redirect:showOrders.html";
	}
	
	
	
}

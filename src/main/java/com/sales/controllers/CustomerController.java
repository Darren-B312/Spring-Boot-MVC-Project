package com.sales.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sales.models.Customer;
import com.sales.services.CustomerService;

@Controller
@SessionAttributes("customer")
public class CustomerController {

	@Autowired
	CustomerService cs;
	
	@RequestMapping(value = "/showCustomers.html", method=RequestMethod.GET)
	public String listCustomerGET(Model m) {
		ArrayList<Customer> customers = cs.getAllCustomers();
		m.addAttribute("customers", customers);
		return "showCustomers";
	}
}

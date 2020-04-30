package com.sales.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@RequestMapping(value = "/addCustomer.html", method=RequestMethod.GET)
	public String addCustomerGET(Model m) {
		Customer c = new Customer();
		
		m.addAttribute("customer", c);
		
		return "addCustomer";
	}
	
	@RequestMapping(value = "/addCustomer.html", method=RequestMethod.POST)
	public String addCustomerPOST(@Valid @ModelAttribute("customer") Customer c, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) { // if there were any input areas, don't save the new customer, return the current page but with messages printed
			return "addCustomer";
		}
		
		cs.save(c);
		
		return "redirect:showCustomers.html";
	}
}

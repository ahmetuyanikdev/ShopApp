package com.project.controller;

import com.project.model.Product;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Map;
import java.util.Random;

@Controller
/*@RequestMapping("/")*/
public class HelloController {

	/*@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		Product product = new Product();
		model.addAttribute("message", "Hello world!");
		model.addAttribute("productForm", product);
		return "hello";
	}

	@RequestMapping(value = "/product",method = RequestMethod.POST)
	@ResponseBody
	public String examine(@ModelAttribute("productForm") Product product,ModelMap model){
		String productName = product.getName();
		return "hello";
	}

	@RequestMapping(value = "/return",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Product getProd(Product product){
		Product product1 = new Product();
		product1.setName("sadi");
		return product1;
	}

	@RequestMapping(value = "/ajaxtest", method = RequestMethod.GET)
	@ResponseBody
	public String getTime() {

		Random rand = new Random();
		float r = rand.nextFloat() * 100;
		String result = "<br>Next Random # is <b>" + r + "</b>. Generated on <b>" + new Date().toString() + "</b>";
		System.out.println("Debug Message from CrunchifySpringAjaxJQuery Controller.." + new Date().toString());
		return result;
	}*/
}
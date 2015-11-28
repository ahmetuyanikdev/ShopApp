package com.project.controller;

import com.project.model.Category;
import com.project.model.Product;
import com.project.service.PersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    PersistenceService persistenceService;

    @RequestMapping(method = RequestMethod.GET)
    public String sayHi(ModelMap modelMap){
        Product product = new Product();
        modelMap.addAttribute("message","Hello");
        modelMap.addAttribute("productForm",product);
        modelMap.addAttribute("list",persistenceService.readAll(Product.class));
        return "product";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("productForm") Product product,ModelMap modelMap){
        persistenceService.create(product);
        modelMap.addAttribute("list",persistenceService.readAll(Product.class));
        return "product";
    }

    @RequestMapping(value = "/getAll",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List findAll(ModelMap modelMap){
        return persistenceService.readAll(Product.class);
    }
}

package com.project.controller;

import com.project.helper.ProductHelper;
import com.project.model.Product;
import com.project.service.PersistenceService;
import com.project.utility.ProductForm;
import com.project.utility.ProductWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    PersistenceService persistenceService;

    @Autowired
    ProductHelper productHelper;

    List<ProductWrapper> wrappers;

    Map<Integer,String> idMap;

    @RequestMapping(method = RequestMethod.GET)
    public String init(ModelMap modelMap){
        List<Product> products=new LinkedList<Product>();
        ProductForm form = new ProductForm();
        Product product = new Product();
        ProductWrapper wrapper = new ProductWrapper();
        wrapper.setProduct(product);
        products = persistenceService.readAll(Product.class);
        wrappers = productHelper.initWrapperList(products);
        wrappers.add(0, wrapper);
        form.setWrappers(wrappers);
        idMap = productHelper.getIdMap(wrappers);
        modelMap.addAttribute("productForm",form);
        return "product";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String insert(@ModelAttribute("productForm") ProductForm form,ModelMap modelMap){

        for (int i = 0; i <form.getWrappers().size() ; i++) {
            Product prd = form.getWrappers().get(i).getProduct();
            if(!prd.getName().equals("")){
                prd.setId(idMap.get(i));
                persistenceService.update(prd);
            }
        }
        wrappers = productHelper.initWrapperList(persistenceService.readAll(Product.class));
        modelMap.addAttribute("list",wrappers);
        return "product";
    }

    @RequestMapping(value = "/getAll",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List findAll(ModelMap modelMap){
        return persistenceService.readAll(Product.class);
    }

}

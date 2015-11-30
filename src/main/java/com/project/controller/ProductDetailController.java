package com.project.controller;

import com.project.model.Product;
import com.project.model.PurchaseItem;
import com.project.service.PersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/productDetail")
public class ProductDetailController {
    @Autowired
    PersistenceService persistenceService;

    @RequestMapping(method = RequestMethod.GET)
    public String init(@RequestParam String productId,ModelMap modelMap){

        Product product = (Product)persistenceService.read(productId,Product.class);
        PurchaseItem purchaseItem = new PurchaseItem();
        purchaseItem.setProductPrice(product.getUnitPrice());
        purchaseItem.setQuantity(1);
        purchaseItem.setName(product.getName());

        modelMap.addAttribute("productDetailForm",purchaseItem);
        return "productDetail";
    }

    @RequestMapping(value = "/addBasket",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List addToBasket(@RequestBody PurchaseItem purchaseItem){
        PurchaseItem pr = purchaseItem;
        persistenceService.create(purchaseItem);
        return  persistenceService.readAll(PurchaseItem.class);
    }
}

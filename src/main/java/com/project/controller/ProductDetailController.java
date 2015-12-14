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

    Product product;

    @RequestMapping(method = RequestMethod.GET)
    public String init(@RequestParam String productId,ModelMap modelMap){

        product = (Product)persistenceService.read(productId,Product.class);
        PurchaseItem purchaseItem = new PurchaseItem();
        purchaseItem.productPrice=product.getUnitPrice();
        purchaseItem.setName(product.getName());

        modelMap.addAttribute("productDetailForm",purchaseItem);
        List<PurchaseItem> purchaseItems = persistenceService.readAll(PurchaseItem.class);
        modelMap.addAttribute("purchaseItemList",purchaseItems);
        return "productDetail";
    }

    @RequestMapping(value = "/addToBasket",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List addToBasket(@RequestBody PurchaseItem purchaseItem){

        purchaseItem.setProductId(product.getId());
        purchaseItem.setName(product.getName());
        persistenceService.create(purchaseItem);
        return persistenceService.readAll(PurchaseItem.class);
    }

    public PersistenceService getPersistenceService() {
        return persistenceService;
    }

    public void setPersistenceService(PersistenceService persistenceService) {
        this.persistenceService = persistenceService;
    }
}

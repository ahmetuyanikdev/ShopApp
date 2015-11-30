package com.project.controller;

import com.project.helper.CategoryHelper;
import com.project.helper.ProductHelper;
import com.project.helper.SaleItemHelper;
import com.project.model.Category;
import com.project.model.Product;
import com.project.model.SaleItem;
import com.project.service.PersistenceService;
import com.project.utility.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/saleItem")
public class SaleItemController {

    @Autowired
    PersistenceService persistenceService;

    List<CategoryWrapper> categoryWrappers = new LinkedList<CategoryWrapper>();
    List<ProductWrapper> productWrappers = new LinkedList<ProductWrapper>();
    List<SaleItem> saleItems = new LinkedList<SaleItem>();
    List<SaleItemWrapper> saleItemWrappers = new LinkedList<SaleItemWrapper>();

    SaleItemForm form = new SaleItemForm();
    CategoryHelper categoryHelper  = new CategoryHelper();
    ProductHelper productHelper =  new ProductHelper();
    SaleItemHelper saleItemHelper = new SaleItemHelper();
    Map<Integer,String> categoryIdMap;
    Map<Integer,String> productIdMap;
    Map<String,Category> categoryMap;
    Map<String,Product> productMap;


    @RequestMapping(method = RequestMethod.GET)
    public String init(ModelMap modelMap){
        categoryWrappers = categoryHelper.initWrapperList(persistenceService.readAll(Category.class));
        productWrappers = productHelper.initWrapperList(persistenceService.readAll(Product.class));
        saleItems = persistenceService.readAll(SaleItem.class);
        form.setCategoryWrappers(categoryWrappers);
        form.setProductWrappers(productWrappers);
        modelMap.addAttribute("saleItemForm",form);
        categoryMap = categoryHelper.getCategoryMap(categoryWrappers);
        productMap=productHelper.getProductMap(productWrappers);
        categoryIdMap = categoryHelper.getIdMap(categoryWrappers);
        productIdMap = productHelper.getIdMap(productWrappers);
        saleItemWrappers = saleItemHelper.initWrapperList(saleItems,categoryMap,productMap);
        modelMap.addAttribute("saleItemList",saleItemWrappers);

        return "saleItem";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String insert(@ModelAttribute("saleItemForm") SaleItemForm form,ModelMap modelMap){

        SaleItem saleItem;

        for (int i = 0; i < form.getCategoryWrappers().size(); i++) {

            if(form.getCategoryWrappers().get(i).getSelected()){

                for (int j = 0; j < form.getProductWrappers().size(); j++) {

                    if(form.getProductWrappers().get(i).selected){
                        saleItem = new SaleItem();
                        saleItem.setCategoryId(categoryIdMap.get(i));
                        saleItem.setProductId(productIdMap.get(i));
                        persistenceService.update(saleItem);
                    }
                }
            }
        }



        return "saleItem";
    }

}

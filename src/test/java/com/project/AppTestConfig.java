package com.project;


import com.project.calculator.TaxCalculation;
import com.project.calculator.TotalCalculation;
import com.project.controller.*;
import com.project.helper.CategoryHelper;
import com.project.helper.ProductHelper;
import com.project.helper.PurchaseItemHelper;
import com.project.helper.SaleItemHelper;
import com.project.service.PersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(MongoTestConfig.class)
@Configuration
public class AppTestConfig {

    @Autowired
    PersistenceService persistenceService;

    @Autowired
    CategoryHelper categoryHelper;

    @Autowired
    ProductHelper productHelper;

    @Autowired
    PurchaseItemHelper purchaseItemHelper;

    @Autowired
    SaleItemHelper saleItemHelper;

    @Bean
    TaxCalculation taxCalculation(){
        return  new TaxCalculation();
    }

    @Bean
    TotalCalculation totalCalculation(){
        return  new TotalCalculation();
    }

    @Bean
    CategoryController categoryController(){
        CategoryController categoryController  = new CategoryController();
        categoryController.categoryHelper = categoryHelper;
        categoryController.setPersistenceService(persistenceService);
        return categoryController;
    }

    @Bean
    ProductController productController(){
        ProductController productController = new ProductController();
        productController.productHelper = productHelper;
        productController.setPersistenceService(persistenceService);
        return productController;
    }

    @Bean
    ProductDetailController productDetailController(){
        ProductDetailController productDetailController = new ProductDetailController();
        productDetailController.setPersistenceService(persistenceService);
        return productDetailController;
    }

    @Bean
    PurchaseItemController purchaseItemController(TaxCalculation taxCalculation,TotalCalculation totalCalculation){
        PurchaseItemController purchaseItemController= new PurchaseItemController();
        purchaseItemController.setPersistenceService(persistenceService);
        purchaseItemController.purchaseItemHelper = purchaseItemHelper;
        purchaseItemController.setTaxCalculation(taxCalculation);
        purchaseItemController.setTotalCalculation(totalCalculation);
        return purchaseItemController;
    }

    @Bean
    SaleItemController saleItemController(){
        SaleItemController saleItemController = new SaleItemController();
        saleItemController.setPersistenceService(persistenceService);
        saleItemController.productHelper = productHelper;
        saleItemController.categoryHelper = categoryHelper;
        saleItemController.saleItemHelper = saleItemHelper;
        return saleItemController;
    }


}

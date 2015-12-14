package com.project.config;

import com.mongodb.MongoClient;
import com.project.calculator.TaxCalculation;
import com.project.calculator.TotalCalculation;
import com.project.helper.CategoryHelper;
import com.project.helper.ProductHelper;
import com.project.helper.PurchaseItemHelper;
import com.project.helper.SaleItemHelper;
import com.project.interfaces.Calculation;
import com.project.service.PersistenceService;
import com.project.utility.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Import(MongoConfig.class)
@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.project.model,com.project.controller")
public class AppConfig {

    @Autowired
    MongoOperations mongoOperations;

    @Bean
    PersistenceService persistenceService(){
        PersistenceService persistenceService = new PersistenceService();
        persistenceService.setMongoOperations(mongoOperations);
        return persistenceService;
    }

    @Bean
    CategoryHelper categoryHelper(){
        return new CategoryHelper();
    }

    @Bean
    ProductHelper productHelper(){
        return new ProductHelper();
    }

    @Bean
    PurchaseItemHelper purchaseItemHelper(){
        return new PurchaseItemHelper();
    }

    @Bean
    SaleItemHelper saleItemHelper(){
        return new SaleItemHelper();
    }

    @Bean
    TaxCalculation taxCalculation(){
       return new TaxCalculation();
    }

    @Bean
    TotalCalculation totalCalculation(){
        return new TotalCalculation();
    }
}

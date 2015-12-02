package com.project;

import com.project.controller.*;
import com.project.helper.CategoryHelper;
import com.project.helper.ProductHelper;
import com.project.helper.PurchaseItemHelper;
import com.project.helper.SaleItemHelper;
import com.project.service.PersistenceService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoOperations;

@Configuration
public class MongoTestConfig {

    @Bean
    MongoOperations mongoOperations(){
        return Mockito.mock(MongoOperations.class);
    }

    @Bean
    PersistenceService persistenceService(){
        PersistenceService persistenceService = new PersistenceService();
        persistenceService.setMongoOperations(mongoOperations());
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




}

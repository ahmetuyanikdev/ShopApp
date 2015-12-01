package com.project.config;

import com.mongodb.MongoClient;
import com.project.helper.CategoryHelper;
import com.project.helper.ProductHelper;
import com.project.helper.PurchaseItemHelper;
import com.project.helper.SaleItemHelper;
import com.project.service.PersistenceService;
import com.project.utility.Constants;
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

    @Bean
    MongoClient mongoClient() throws Exception{
        return new MongoClient(Constants.MongoDbHost);
    }

    @Bean
    MongoOperations mongoOperations(MongoClient mongoClient){
        return new MongoTemplate(mongoClient,Constants.MongoDatabase);
    }

    @Bean
    PersistenceService persistenceService(MongoOperations mongoOperations){
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

}

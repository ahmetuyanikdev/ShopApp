package com.project.config;

import com.mongodb.MongoClient;
import com.project.service.PersistenceService;
import com.project.utility.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Import(MongoConfig.class)
@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.project.model,com.project.controller")
public class AppConfig {

    @Autowired
    MongoOperations mongoOperations;

    @Autowired
    GridFsOperations gridFsOperations;

    @Bean
    PersistenceService persistenceService(){
        PersistenceService persistenceService = new PersistenceService();
        persistenceService.setMongoOperations(mongoOperations);
        persistenceService.setGridFsOperations(gridFsOperations);
        return persistenceService;
    }
}

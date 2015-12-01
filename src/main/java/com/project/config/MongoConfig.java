package com.project.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.project.utility.Constants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return Constants.MongoDatabase;
    }

    @Override
    @Bean
    public Mongo mongo() throws Exception {
        return new MongoClient(Constants.MongoDbHost);
    }

    @Bean
    MongoOperations mongoOperations(Mongo mongo ){
        return new MongoTemplate(mongo,getDatabaseName());
    }

    @Bean
    public GridFsOperations gridFsOperations() throws Exception {
        return new GridFsTemplate(mongoDbFactory(), mappingMongoConverter());
    }

}

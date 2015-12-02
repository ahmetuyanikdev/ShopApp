package com.project.service;

import com.project.interfaces.Crud;
import com.project.model.Shop;
import org.apache.log4j.Logger;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;


import javax.annotation.PostConstruct;
import java.io.InputStream;
import java.util.List;

public class PersistenceService implements Crud {

    private MongoOperations mongoOperations;

    public static Logger log;

    @PostConstruct
    public void init(){
        log = Logger.getLogger(PersistenceService.class);
        log.info("#--- Application Persistence Service initialize ");
    }

    @Override
    public void create(Shop obj) {
        log.info("#--- Creating new shopping instance");
        mongoOperations.insert(obj);
    }

    @Override
    public void delete(Shop obj) {
        log.info("#--- Deleting shopping instance with name "+obj.getName());
        mongoOperations.remove(obj);
    }

    @Override
    public void update(Shop obj) {
        log.info("#--- Saving shopping instance with name "+obj.getName());
        mongoOperations.save(obj);
    }

    @Override
    public Shop read(String id, Class cls) {
        log.info("#--- Fetching shopping instance by id "+id);
        return  (Shop)mongoOperations.findById(id,cls);
    }

    public List readByQuery(Query query,Class cls){
        return mongoOperations.find(query,cls);
    }

    @Override
    public List readAll(Class cls) {
        log.info("#--- Fetching all instance of document class "+cls.getName());
        return mongoOperations.findAll(cls);
    }

    public void setMongoOperations(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public MongoOperations getMongoOperations() {
        return mongoOperations;
    }
}

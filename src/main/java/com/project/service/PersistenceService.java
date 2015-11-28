package com.project.service;

import com.project.interfaces.Crud;
import com.project.model.Shop;
import org.springframework.data.mongodb.core.MongoOperations;

import java.util.List;

public class PersistenceService implements Crud {

    private MongoOperations mongoOperations;

    @Override
    public void create(Shop obj) {
        mongoOperations.insert(obj);
    }

    @Override
    public void delete(Shop obj) {
        mongoOperations.remove(obj);
    }

    @Override
    public void update(Shop obj) {
        mongoOperations.save(obj);
    }

    @Override
    public Object read(String id, Class cls) {
        return  mongoOperations.findById(id,cls);
    }

    @Override
    public List readAll(Class cls) {
        return mongoOperations.findAll(cls);
    }

    public MongoOperations getMongoOperations() {
        return mongoOperations;
    }

    public void setMongoOperations(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }
}

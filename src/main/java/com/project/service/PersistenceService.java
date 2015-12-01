package com.project.service;

import com.mongodb.gridfs.GridFSDBFile;
import com.project.interfaces.Crud;
import com.project.model.Shop;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

import java.io.InputStream;
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
    public Shop read(String id, Class cls) {
        return  (Shop)mongoOperations.findById(id,cls);
    }

    public List readByQuery(Query query,Class cls){
        return mongoOperations.find(query,cls);
    }

    @Override
    public List readAll(Class cls) {
        return mongoOperations.findAll(cls);
    }

    public void setMongoOperations(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }




}

package com.project.interfaces;

import com.project.model.Shop;

import java.util.List;

/**
 * Created by ahmet on 27/11/15.
 */
public interface Crud {
    public void create(Shop obj);
    public void delete(Shop obj);
    public void update(Shop obj);
    public Shop read(String id, Class cls);
    public List readAll(Class cls);
}

package com.project.helper;

import com.project.model.Product;
import com.project.utility.ProductWrapper;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ProductHelper {

    public List<ProductWrapper> initWrapperList(List<Product> objects){
        List<ProductWrapper> wraps = new LinkedList<ProductWrapper>();
        for (int i = 0; i < objects.size(); i++) {
            ProductWrapper wrapper = new ProductWrapper();
            wrapper.setSelected(false);
            wrapper.setProduct(objects.get(i));
            wraps.add(wrapper);
        }
        return wraps;
    }

    public Map<Integer,String> getIdMap(List<ProductWrapper> productWrappers){
        Map<Integer,String> idMap = new HashMap<Integer, String>();
        for (int i = 0; i < productWrappers.size(); i++) {
            idMap.put(i,productWrappers.get(i).getProduct().getId());
        }
        return idMap;
    }

    public Map<String,Product> getProductMap(List<ProductWrapper> productWrappers){
        Map<String,Product> productMap = new HashMap<String, Product>();
        for (int i = 0; i < productWrappers.size(); i++) {
            productMap.put(productWrappers.get(i).product.getId(),productWrappers.get(i).product);
        }
        return productMap;
    }

    

}

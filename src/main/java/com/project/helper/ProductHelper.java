package com.project.helper;


import com.project.model.Product;
import com.project.wrapper.ProductWrapper;

import java.util.LinkedList;
import java.util.List;

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

}

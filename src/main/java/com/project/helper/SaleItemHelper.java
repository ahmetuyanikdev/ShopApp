package com.project.helper;


import com.project.model.Category;
import com.project.model.Product;
import com.project.model.SaleItem;
import com.project.utility.SaleItemWrapper;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SaleItemHelper {

    public List<SaleItemWrapper> initWrapperList(List<SaleItem> saleItems,Map<String,Category> categoryMap,Map<String,Product> productMap){
        String categoryId;
        String productId;
        Category category;
        Product product;
        SaleItemWrapper saleItemWrapper;
        List<SaleItemWrapper> saleItemWrappers = new LinkedList<SaleItemWrapper>();
        for (int i = 0; i < saleItems.size() ; i++) {
            categoryId = saleItems.get(i).getCategoryId();
            category = categoryMap.get(categoryId);
            productId = saleItems.get(i).getProductId();
            product=productMap.get(productId);
            saleItemWrapper =  new SaleItemWrapper();
            saleItemWrapper.setProduct(product);
            saleItemWrapper.setCategory(category);
            saleItemWrappers.add(saleItemWrapper);
        }
        return saleItemWrappers;
    }

}

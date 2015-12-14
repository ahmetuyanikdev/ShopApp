package com.project.model;

import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class SaleItem extends Shop {

    public SaleItem() {
        super();
    }

    String categoryId;
    String productId;

    public String getId() {
        return id;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}

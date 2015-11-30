package com.project.utility;

import com.project.model.Category;
import com.project.model.Product;

public class SaleItemWrapper extends BaseWrapper {

    Product product;
    Category category;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

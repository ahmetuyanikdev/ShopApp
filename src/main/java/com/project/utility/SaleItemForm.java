package com.project.utility;

import java.util.List;

public class SaleItemForm {

    public List<CategoryWrapper> categoryWrappers;
    public List<ProductWrapper> productWrappers;

    public List<CategoryWrapper> getCategoryWrappers() {
        return categoryWrappers;
    }

    public void setCategoryWrappers(List<CategoryWrapper> categoryWrappers) {
        this.categoryWrappers = categoryWrappers;
    }

    public List<ProductWrapper> getProductWrappers() {
        return productWrappers;
    }

    public void setProductWrappers(List<ProductWrapper> productWrappers) {
        this.productWrappers = productWrappers;
    }
}

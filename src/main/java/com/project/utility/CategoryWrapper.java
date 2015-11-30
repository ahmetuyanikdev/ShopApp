package com.project.utility;

import com.project.model.Category;
import com.project.model.Product;

import java.util.List;

/**
 * Created by ahmet on 28/11/15.
 */
public class CategoryWrapper extends BaseWrapper {

    public Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;

    }
}

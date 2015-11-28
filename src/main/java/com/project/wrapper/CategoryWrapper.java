package com.project.wrapper;

import com.project.model.Category;

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

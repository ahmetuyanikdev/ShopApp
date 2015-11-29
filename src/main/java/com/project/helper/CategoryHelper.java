package com.project.helper;

import com.project.model.Category;
import com.project.wrapper.CategoryWrapper;

import java.util.LinkedList;
import java.util.List;

public class CategoryHelper {

    public List<CategoryWrapper> initWrapperList(List<Category> objects){
        List<CategoryWrapper> wraps = new LinkedList<CategoryWrapper>();
        for (int i = 0; i < objects.size(); i++) {
            CategoryWrapper wrapper = new CategoryWrapper();
            wrapper.setSelected(false);
            wrapper.setCategory(objects.get(i));
            wraps.add(wrapper);
        }
        return wraps;
    }
}

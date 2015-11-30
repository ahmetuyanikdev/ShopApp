package com.project.helper;

import com.project.model.Category;
import com.project.utility.CategoryWrapper;
import com.project.utility.ProductWrapper;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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

    public Map<Integer,String> getIdMap(List<CategoryWrapper> categoryWrappers){
        Map<Integer,String> idMap = new HashMap<Integer, String>();
        for (int i = 0; i < categoryWrappers.size(); i++) {
            idMap.put(i,categoryWrappers.get(i).getCategory().getId());
        }
        return idMap;
    }

    public Map<String,Category> getCategoryMap(List<CategoryWrapper> categoryWrappers){
        Map<String,Category> categoryMap = new HashMap<String, Category>();
        for (int i = 0; i < categoryWrappers.size(); i++) {
            categoryMap.put(categoryWrappers.get(i).category.getId(),categoryWrappers.get(i).category);
        }
        return categoryMap;
    }
}

package com.project.controller;

import com.project.helper.CategoryHelper;
import com.project.model.Category;
import com.project.service.PersistenceService;
import com.project.utility.CategoryForm;
import com.project.utility.CategoryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/category")
public class CategoryController{

    @Autowired
    PersistenceService persistenceService;

    @Autowired
    CategoryHelper categoryHelper;

    List<CategoryWrapper> wrappers;

    Map<Integer,String> idMap;

    @RequestMapping(method = RequestMethod.GET)
    public String init(ModelMap modelMap){

        CategoryForm form = new CategoryForm();
        Category category =  new Category();
        CategoryWrapper wrapper = new CategoryWrapper();
        wrapper.setCategory(category);
        modelMap.addAttribute("message","Hi..");
        wrappers = categoryHelper.initWrapperList(persistenceService.readAll(Category.class));
        wrappers.add(0,wrapper);
        form.setWrappers(wrappers);
        idMap = categoryHelper.getIdMap(wrappers);
        modelMap.addAttribute("categoryForm",form);
        modelMap.addAttribute("list",wrappers);
        return "category";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String insert(@ModelAttribute("categoryForm") CategoryForm form,ModelMap modelMap){

        for (int i = 0; i <form.getWrappers().size(); i++) {
            Category category = form.getWrappers().get(i).getCategory();
            if(!category.getName().equals("")){
                category.setId(idMap.get(i));
                persistenceService.update(category);
            }
        }
        wrappers = categoryHelper.initWrapperList(persistenceService.readAll(Category.class));
        modelMap.addAttribute("list",wrappers);
        return "category";
    }

    @RequestMapping(value = "/getAll",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List findAll(ModelMap modelMap){
        return persistenceService.readAll(Category.class);
    }
}

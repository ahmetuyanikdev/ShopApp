package com.project.controller;

import com.project.model.Category;
import com.project.service.PersistenceService;
import com.project.wrapper.CategoryWrapper;
import com.project.wrapper.Form;
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

@Controller
@RequestMapping("/category")
public class CategoryController{

    @Autowired
    PersistenceService persistenceService;

    List<CategoryWrapper> wrappers = new LinkedList<CategoryWrapper>();

    Form form = new Form();

    @RequestMapping(method = RequestMethod.GET)
    public String init(ModelMap modelMap){

        Category category =  new Category();
        CategoryWrapper wrapper = new CategoryWrapper();
        wrapper.setCategory(category);
        modelMap.addAttribute("message","Hi..");
        wrappers = initWrapperList(persistenceService.readAll(Category.class));
        wrappers.add(0,wrapper);
        form.setWrappers(wrappers);
        modelMap.addAttribute("categoryForm",form);
        modelMap.addAttribute("list",wrappers);
        return "category";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String insert(@ModelAttribute("categoryForm") Form form,ModelMap modelMap){

        Category newCategory = form.getWrappers().get(0).getCategory();

        if(!newCategory.getName().equals(null)){
            persistenceService.create(newCategory);
        }

        wrappers = initWrapperList(persistenceService.readAll(Category.class));
        modelMap.addAttribute("list",wrappers);
        return "category";
    }

    @RequestMapping(value = "/getAll",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List findAll(ModelMap modelMap){
        return persistenceService.readAll(Category.class);
    }


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

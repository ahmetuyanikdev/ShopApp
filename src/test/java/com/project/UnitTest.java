package com.project;

import com.project.controller.CategoryController;
import com.project.controller.ProductController;
import com.project.controller.PurchaseItemController;
import com.project.controller.SaleItemController;
import com.project.model.Category;
import com.project.model.Product;
import com.project.model.SaleItem;
import com.project.utility.CategoryForm;
import com.project.utility.ProductForm;
import com.project.utility.SaleItemForm;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.ModelMap;

import java.util.LinkedList;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppTestConfig.class)
public class UnitTest {

    @Autowired
    CategoryController categoryController;

    @Autowired
    ProductController productController;

    @Autowired
    SaleItemController saleItemController;

    @Autowired
    PurchaseItemController purchaseItemController;

    @Before
    public void setUp() throws Exception {

    }


    @org.junit.Test
    public void saveCategories(){

        List<String> categoryNames = new LinkedList<String>();
        categoryNames.add("Winter");
        categoryNames.add("Spring");

        List<Category> categoryList = getCategoryList(categoryNames);

        MongoOperations mongoOperations = categoryController.getPersistenceService().getMongoOperations();
        Mockito.when(mongoOperations.findAll(Category.class)).thenReturn(categoryList);
        ModelMap modelMap = new ModelMap();

        categoryController.init(modelMap);
        CategoryForm form = new CategoryForm();
        form.setWrappers(categoryController.wrappers);

        categoryController.insert(form,modelMap);

        for (int i = 0; i <categoryList.size() ; i++) {
            Mockito.verify(mongoOperations,Mockito.times(1)).save(categoryList.get(i));
        }
    }
    @org.junit.Test
    public void saveProducts(){
        List<String> productNames = new LinkedList<String>();
        productNames.add("Adidas");
        productNames.add("Nike");
        List<Float> priceList = new LinkedList<Float>();
        priceList.add(55.5f);
        priceList.add(45.9f);
        List<Product> productList = getProductList(productNames,priceList);
        MongoOperations mongoOperations = productController.getPersistenceService().getMongoOperations();
        Mockito.when(mongoOperations.findAll(Product.class)).thenReturn(productList);
        ModelMap modelMap = new ModelMap();
        productController.init(modelMap);
        ProductForm form = new ProductForm();
        form.setWrappers(productController.wrappers);

        productController.insert(form,modelMap);

        for (int i = 0; i <productList.size() ; i++) {
            Mockito.verify(mongoOperations,Mockito.times(1)).save(productList.get(i));
        }

        List<Product> products = productController.findAll(modelMap);

        assert products.size()==2;
    }

    @org.junit.Test
    public void saveSaleItems(){
        List<String> categoryNames = new LinkedList<String>();
        categoryNames.add("Winter");
        categoryNames.add("Spring");
        List<Category> categoryList = getCategoryList(categoryNames);

        List<String> productNames = new LinkedList<String>();
        productNames.add("Adidas");
        productNames.add("Nike");
        productNames.add("Puma");
        List<Float> priceList = new LinkedList<Float>();
        priceList.add(55.5f);
        priceList.add(45.9f);
        priceList.add(35.0f);

        List<Product> productList = getProductList(productNames,priceList);

        MongoOperations mongoOperations = saleItemController.getPersistenceService().getMongoOperations();
        Mockito.when(mongoOperations.findAll(Category.class)).thenReturn(categoryList);
        Mockito.when(mongoOperations.findAll(Product.class)).thenReturn(productList);
        ModelMap modelMap = new ModelMap();

        saleItemController.init(modelMap,null);

        SaleItemForm form = new SaleItemForm();
        form.setCategoryWrappers(saleItemController.categoryWrappers);
        form.setProductWrappers(saleItemController.productWrappers);

        assert saleItemController.categoryWrappers.size() == 2;
        assert saleItemController.productWrappers.size() == 3;

        saleItemController.insert(form,modelMap);
        Mockito.verify(mongoOperations,Mockito.times(0)).save(Mockito.any(SaleItem.class));

        saleItemController.categoryWrappers.get(0).setSelected(true);
        saleItemController.categoryWrappers.get(1).setSelected(true);

        saleItemController.productWrappers.get(0).setSelected(true);
        saleItemController.productWrappers.get(1).setSelected(true);
        saleItemController.productWrappers.get(2).setSelected(true);

        form.setCategoryWrappers(saleItemController.categoryWrappers);
        form.setProductWrappers(saleItemController.productWrappers);
        saleItemController.insert(form,modelMap);

        Mockito.verify(mongoOperations,Mockito.times(6)).save(Mockito.any(SaleItem.class));

    }




    public List<Category> getCategoryList(List<String> names){
        List<Category> categories = new LinkedList<Category>();
        for (int i = 0; i < names.size(); i++) {
            Category category = new Category();
            category.setName(names.get(i));
            categories.add(category);
        }
        return categories;
    }

    public List<Product> getProductList(List<String> names , List<Float> unitPrices){
        List<Product> products = new LinkedList<Product>();
        for (int i = 0; i <names.size() ; i++) {
            Product product = new Product();
            product.setUnitPrice(unitPrices.get(i));
            product.setName(names.get(i));
            products.add(product);
        }
        return products;
    }

}

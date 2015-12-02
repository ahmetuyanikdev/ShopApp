package com.project.controller;

import com.project.helper.PurchaseItemHelper;
import com.project.model.PurchaseItem;
import com.project.service.PersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/purchases")
public class PurchaseItemController {

    @Autowired
    PersistenceService persistenceService;

    @Autowired
    public PurchaseItemHelper purchaseItemHelper;

    List<PurchaseItem> purchaseItems;

    Map<String,PurchaseItem> purchaseItemMap;

    @RequestMapping(method = RequestMethod.GET)
    public String init(ModelMap modelMap){
        purchaseItems = persistenceService.readAll(PurchaseItem.class);
        purchaseItemMap = purchaseItemHelper.getPurchaseItemMap(purchaseItems);
        modelMap.addAttribute("purchaseItems",purchaseItems);
        modelMap.addAttribute("grandTotal",getGrandTotal());
        return "purchase";
    }

    public float getGrandTotal(){
        float grandTotal=0;
        for (int i = 0; i <purchaseItems.size() ; i++) {
                grandTotal=grandTotal+purchaseItems.get(i).getTotal();
        }
        return grandTotal;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public String deletePurchaseItem(@RequestParam String purchaseItemId,ModelMap modelMap){
        PurchaseItem purchaseItem = purchaseItemMap.get(purchaseItemId);
        persistenceService.delete(purchaseItem);
        purchaseItems = persistenceService.readAll(PurchaseItem.class);
        modelMap.addAttribute("purchaseItems",purchaseItems);
        modelMap.addAttribute("grandTotal",getGrandTotal());
        return "purchase";
    }

    public PersistenceService getPersistenceService() {
        return persistenceService;
    }

    public void setPersistenceService(PersistenceService persistenceService) {
        this.persistenceService = persistenceService;
    }
}

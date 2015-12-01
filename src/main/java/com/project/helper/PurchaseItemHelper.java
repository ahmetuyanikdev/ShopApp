package com.project.helper;


import com.project.model.PurchaseItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PurchaseItemHelper {

    public Map<String,PurchaseItem> getPurchaseItemMap(List<PurchaseItem> purchaseItems){

        Map<String,PurchaseItem> purchaseItemMap = new HashMap<String, PurchaseItem>();

        for (int i = 0; i < purchaseItems.size(); i++) {
            purchaseItemMap.put(purchaseItems.get(i).getId(),purchaseItems.get(i));
        }
        return purchaseItemMap;
    }
}

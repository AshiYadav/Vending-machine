package model;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Inventory {

    ConcurrentHashMap<Product,Integer> map;

    public Inventory() {
        this.map = new ConcurrentHashMap<>();
    }

    public void addProduct(Product product , int quantity){

            map.put(product, quantity);

    }

    public void removeProduct(Product product){
        map.remove(product);
    }

    public void AddQty(Product product,int quantity){
        map.put(product, quantity);
    }

    public void updateQty(Product product, int quantity){
        map.put(product, quantity);
    }

    public int getQty(Product product){
        return map.get(product);
    }

    public boolean isAvailable(Product product) {
        return map.containsKey(product) && map.get(product) > 0;
    }

}
